package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.rsbot.script.methods.*;
import org.rsbot.script.wrappers.GroundItem;
import org.rsbot.script.wrappers.Item;
import org.rsbot.script.wrappers.NPC;

//TODO: Zalgo2462 Touch up State
public class FighterState extends State {

    public FighterState(MethodBase methods) {
        super(methods);
    }

    private int badFoodCount = 0;
    private LoopAction[] loopActions = new LoopAction[]{new InCombatLoop(), new AttackLoop()};
    private boolean killCondition = false;
    @Override
    public int loop() {
        if (!Walking.isRunEnabled() && Walking.getEnergy() > random(60, 90)) {
            methods.parent.paint.Current = "Setting Run";
            Walking.setRun(true);
            return random(1200, 1600);
        }
        if (Interfaces.canContinue()) {
            methods.parent.paint.Current = "Clicking Continue";
            Interfaces.clickContinue();
            return random(1200, 1600);
        }
        if (Game.getTab() != Game.Tab.INVENTORY) {
            methods.parent.paint.Current = "Opening Inventory";
            Game.openTab(Game.Tab.INVENTORY);
            return random(700, 1500);
        }
        if (methods.fighter.eat.needEat()) {
            if (methods.fighter.eat.haveFood()) {
                badFoodCount = 0;
                methods.parent.paint.Current = "Eating";
                methods.fighter.eat.eatFood();
            } else if (methods.fighter.eat.haveB2pTab() && methods.fighter.eat.haveBones()) {
                methods.parent.paint.Current = "Casting B2P";
                methods.fighter.eat.breakB2pTab();
                return random(2600, 3000);
            } else {
                badFoodCount++;
                if (badFoodCount > 5) {
                    log("You ran out of food! Stopping Fighter.");
                    killCondition = true;
                }
            }
            return random(1200, 1600);
        }

        methods.fighter.pot.usePotions();

		if(methods.fighter.pot.getPotions().get("PRAYER").length != 0 && !Prayer.isQuickPrayerOn() &&  methods.fighter.pot.setQuickPrayer) {
            Prayer.setQuickPrayer(true);
        }

	     if(methods.fighter.loot.onlyTakeLootFromKilled && methods.fighter.npcs.lastClickedNPC != null) {
				methods.fighter.npcs.sleepWhileNpcIsDying(methods.fighter.npcs.lastClickedNPC);
		 }

        for (LoopAction a : loopActions)
            if (a != null && a.activate())
                return a.loop();
        return random(50, 200);
    }

    @Override
    public boolean activeCondition() {

        return methods.fighter.npcs.getNPC() != null && !killCondition && Settings.get(394) != 0 && checkItems();
    }

    public interface LoopAction {
        public int loop();

        public boolean activate();
    }




	private class InCombatLoop implements LoopAction {

			public int loop() {
				methods.parent.paint.Current = "Fighting";

				if(methods.fighter.npcs.getInteracting() != null) {
					if(methods.fighter.npcs.getInteracting().getHPPercent() <= 10 &&
                    methods.parent.currentTask.getMonster().getRequirements().getFinisher() != null) {
						if(!methods.fighter.npcs.useFinisher(methods.fighter.npcs.getInteracting())) {
							log("You ran out of finishers! Stopping Fighter.");
							killCondition = true;
						}
					}

					if( methods.fighter.npcs.useSpecial() && !Combat.isSpecialEnabled() && !methods.fighter.npcs.getInteracting().isDead()) {
						sleep(random(500, 1000));
						Combat.setSpecialAttack(true);
					}


					if(methods.fighter.loot.onlyTakeLootFromKilled) {
						if(methods.fighter.npcs.getInteracting() != null){
							if(!methods.fighter.npcs.tilesFoughtOn.contains(methods.fighter.npcs.getInteracting().getLocation())
									&& !methods.fighter.npcs.getInteracting().isMoving()) {
								methods.fighter.npcs.tilesFoughtOn.add(methods.fighter.npcs.getInteracting().getLocation());
							}
						}
					}
				}
				methods.fighter.antiban();
				return random(50, 200);
			}

			public boolean activate() {
				return methods.fighter.npcs.isInCombat();
			}

		}

		private class AttackLoop implements LoopAction {

			public int loop() {
				NPC inter = methods.fighter.npcs.getInteracting();
				NPC n = inter != null ? inter : methods.fighter.npcs.getNPC();
				if (n != null) {
					int result = -5;
					if(methods.parent.currentTask.getRequirements().getStarter() != null) {
						if(!methods.fighter.npcs.useStarter(n)) {
							log("You ran out of starters! Stopping Fighter.");
							killCondition = true;
						}
						result = 0;
					}
					else {
						methods.parent.paint.Current = "Attacking " + n.getName();
						result = methods.fighter.npcs.clickNPC(n, "Attack " + n.getName());
					}
					if (result == 0) {
						waitWhileMoving();
						return random(300, 500);
					} else if (result == 1) {
						waitWhileMoving();
						return random(0, 200);
					}
				} else {
					if (Calculations.distanceTo(methods.fighter.tiles.getNearestTile(methods.parent.currentTask.getMonster().getLocation())) > 10) {
						Walking.walkTileMM(Walking.getClosestTileOnMap(methods.fighter.tiles.getNearestTile(methods.parent.currentTask.getMonster().getLocation())));
						waitWhileMoving();
					} else {
						methods.fighter.antiban();
					}
				}
				return random(50, 200);
			}

			public boolean activate() {
				return !methods.fighter.npcs.isInCombat();
			}

		}


		private class LootLoop implements LoopAction {

			private GroundItem loot = null;

			public int loop() {
				int origCount = Inventory.getCount(true);
				String name = loot.getItem().getName();
				int count = loot.getItem().getStackSize();
				int result = methods.fighter.loot.takeItem(loot);
				if (result == 0) {
					waitWhileMoving();
					if (methods.fighter.waitForInvChange(origCount)) {
						if(methods.fighter.loot.onlyTakeLootFromKilled && methods.fighter.npcs.tilesFoughtOn.contains(loot.getLocation())) {
							methods.fighter.npcs.tilesFoughtOn.remove(loot.getLocation());
						}
					}
				} else if (result == 1) {
					waitWhileMoving();
				}
				return random(50, 200);
			}

			public boolean activate() {
				return (loot = methods.fighter.loot.getLoot()) != null;
			}
		}


    /**
     * Waits until we are no longer moving.
     */
    public void waitWhileMoving() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1500 && !getMyPlayer().isMoving()) {
            sleep(random(50, 200));
        }
        while (getMyPlayer().isMoving()) {
            sleep(random(20, 50));
        }
    }

    public boolean checkItems() {
        for (SlayerEquipment i : methods.parent.currentTask.getRequirements().getEquipment()) {
            if (!isInInvent(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInInvent(SlayerEquipment i) {
    	for (Item item : Inventory.getItems()) {
    		if (item.getName().equalsIgnoreCase(i.getName())) {
    			if (Inventory.getCount(true, item.getID()) >= i.getAmount())
    				return true;
    		}
    	}

    	return false;
    }

}

