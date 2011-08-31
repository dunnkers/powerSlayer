package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.methods.SlayerInventory;
import org.powerbot.powerslayer.methods.UniversalFighter;
import org.rsbot.script.methods.Calculations;
import org.rsbot.script.methods.Game;
import org.rsbot.script.methods.Game.Tabs;
import org.rsbot.script.methods.NPCs;
import org.rsbot.script.methods.Settings;
import org.rsbot.script.methods.Walking;
import org.rsbot.script.methods.tabs.Combat;
import org.rsbot.script.methods.tabs.Inventory;
import org.rsbot.script.methods.tabs.Prayer;
import org.rsbot.script.methods.ui.Interfaces;
import org.rsbot.script.wrappers.GroundItem;
import org.rsbot.script.wrappers.NPC;
import org.rsbot.script.wrappers.Tile;

//TODO: Zalgo2462 Touch up State
public class FighterState extends State {

    public FighterState(PowerSlayer parent) {
        super(parent);
    }

    private int badFoodCount = 0;
    private LoopAction[] loopActions = new LoopAction[]{new InCombatLoop(), new AttackLoop()};
    private boolean killCondition = false;
    @Override
    public int loop() {
        if (!Walking.isRunEnabled() && Walking.getEnergy() > random(60, 90)) {
            PowerSlayer.Paint.Current = "Setting Run";
            for (int i = 0; i < 5 && !Walking.isRunEnabled(); i++)
            	Walking.setRun(true);
        }

	    //TODO: Zalgo implement explorers ring
        if (Interfaces.canContinue()) {
            PowerSlayer.Paint.Current = "Clicking Continue";
            for (int i = 0; i < 5 && Interfaces.canContinue(); i++)
            	Interfaces.clickContinue();
        }
        if (Game.getCurrentTab() != Game.Tabs.INVENTORY) {
            PowerSlayer.Paint.Current = "Opening Inventory";
            for (int i = 0; i < 5 && !Game.getCurrentTab().equals(Tabs.INVENTORY); i++) {
            	Game.openTab(Tabs.INVENTORY);
            }
        }
        if (UniversalFighter.Eating.needEat()) {
            if (UniversalFighter.Eating.haveFood()) {
                badFoodCount = 0;
                PowerSlayer.Paint.Current = "Eating";
                UniversalFighter.Eating.eatFood();
            } else if (UniversalFighter.Eating.haveB2pTab() && UniversalFighter.Eating.haveBones()) {
                PowerSlayer.Paint.Current = "Casting B2P";
                UniversalFighter.Eating.breakB2pTab();
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

        UniversalFighter.Potion.usePotions();

		if (UniversalFighter.Potion.getPotions().get("PRAYER").length != 0 && !Prayer.isQuickPrayersActive() &&  UniversalFighter.Potion.setQuickPrayer) {
            Prayer.toggleQuickPrayers(true);
        }

	     if (UniversalFighter.Loot.onlyTakeLootFromKilled && UniversalFighter.SlayerNPCs.lastClickedNPC != null) {
				UniversalFighter.SlayerNPCs.sleepWhileNpcIsDying(5000);
		 }

        for (LoopAction a : loopActions)
            if (a != null && a.activate())
                return a.loop();
        return random(50, 200);
    }

    @Override
    public boolean activeCondition() {
    	return UniversalFighter.SlayerNPCs.getNPC() != null && !killCondition && Settings.get(394) != 0 && checkItems();
    }

    public interface LoopAction {
        public int loop();
        public boolean activate();
    }




	private class InCombatLoop implements LoopAction {

			public int loop() {
				PowerSlayer.Paint.Current = "Fighting";

				if (UniversalFighter.SlayerNPCs.getInteracting() != null) {
					if (UniversalFighter.SlayerNPCs.getInteracting().getHPPercent() <= 10 &&
						PowerSlayer.currentTask.getMonster().getRequirements().getFinisher() != null) {
						if (!UniversalFighter.SlayerNPCs.useFinisher(UniversalFighter.SlayerNPCs.getInteracting())) {
							log("You ran out of finishers! Stopping Fighter.");
							killCondition = true;
						}
					}

					if (UniversalFighter.SlayerNPCs.useSpecial() && !Combat.isSpecialEnabled() && !UniversalFighter.SlayerNPCs.getInteracting().isDead()) {
						sleep(random(500, 1000));
						Combat.setSpecial(true);
					}

					if (UniversalFighter.Loot.onlyTakeLootFromKilled) {
						if (UniversalFighter.SlayerNPCs.getInteracting() != null){
							if (!UniversalFighter.SlayerNPCs.tilesFoughtOn.contains(UniversalFighter.SlayerNPCs.getInteracting().getLocation())
									&& !UniversalFighter.SlayerNPCs.getInteracting().isMoving()) {
								UniversalFighter.SlayerNPCs.tilesFoughtOn.add(UniversalFighter.SlayerNPCs.getInteracting().getLocation());
							}
						}
					}
				}
				UniversalFighter.antiban();
				return random(50, 200);
			}

			public boolean activate() {
				return UniversalFighter.SlayerNPCs.isInCombat();
			}

		}

		private class AttackLoop implements LoopAction {

			public int loop() {
				NPC inter = UniversalFighter.SlayerNPCs.getInteracting();
				NPC n = inter != null ? inter : UniversalFighter.SlayerNPCs.getNPC();
				if (n != null) {
					int result;
					if (PowerSlayer.currentTask.getRequirements().getStarter() != null) {
						if (!UniversalFighter.SlayerNPCs.useStarter(n)) {
							log("You ran out of starters! Stopping Fighter.");
							killCondition = true;
						}
						result = 0;
					}
					else {
						PowerSlayer.Paint.Current = "Attacking " + n.getName();
						result = UniversalFighter.SlayerNPCs.clickNPC(n, "Attack " + n.getName());
					}
					if (result == 0) {
						waitWhileMoving();
						return random(300, 500);
					} else if (result == 1) {
						waitWhileMoving();
						return random(0, 200);
					}
				} else {
					String[] currMonster = PowerSlayer.currentTask.getMonster().getNames();
					Tile currTile = NPCs.getNearest(currMonster).getLocation();
					if (Calculations.distanceTo(currTile) > 10) {
						Walking.walkTileMM(Walking.getClosestTileOnMap(currTile));
						waitWhileMoving();
					} else {
						UniversalFighter.antiban();
					}
				}
				return random(50, 200);
			}

			public boolean activate() {
				return !UniversalFighter.SlayerNPCs.isInCombat();
			}

		}


	    //TODO: Find a way to get a list of loots to feed into the loot loop
		@SuppressWarnings("unused")
		private class LootLoop implements LoopAction {

			private GroundItem loot = null;

			public int loop() {
				int origCount = Inventory.getCount(true);
				String name = loot.getItem().getName();
				int count = loot.getItem().getStackSize();
				int result = UniversalFighter.Loot.takeItem(loot);
				if (result == 0) {
					waitWhileMoving();
					if (SlayerInventory.waitForInvChange(origCount, 2000)) {
						if (UniversalFighter.Loot.onlyTakeLootFromKilled && UniversalFighter.SlayerNPCs.tilesFoughtOn.contains(loot.getLocation())) {
							UniversalFighter.SlayerNPCs.tilesFoughtOn.remove(loot.getLocation());
						}
					}
				} else if (result == 1) {
					waitWhileMoving();
				}
				return random(50, 200);
			}

			public boolean activate() {
				return (loot = UniversalFighter.Loot.getLoot()) != null;
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
        return SlayerInventory.containsAllEquipment();
    }
}

