package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.wrappers.SlayerItem;
import org.rsbot.script.methods.Game;
import org.rsbot.script.methods.Interfaces;
import org.rsbot.script.methods.Inventory;
import org.rsbot.script.methods.Prayer;
import org.rsbot.script.methods.Settings;
import org.rsbot.script.methods.Walking;
import org.rsbot.script.wrappers.Item;
import org.rsbot.script.wrappers.NPC;


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
        if(methods.fighter.pot.getPotions().get("PRAYER").length != 0) {
            methods.parent.paint.Current = "Setting Prayer";
           	Prayer.setQuickPrayer(true);
        }
        if (methods.fighter.pot.needPot()) {
            methods.parent.paint.Current = "Using Potions";
            return methods.fighter.pot.usePotions();
        }

        for (LoopAction a : loopActions)
            if (a != null && a.activate())
                return a.loop();
        return random(50, 200);
    }

    @Override
    public boolean activeCondition() {
        NPC inter = methods.fighter.npcs.getInteracting();
        NPC n = inter != null ? inter : methods.fighter.npcs.getNPC();

        return n != null && !killCondition && Settings.get(394) != 0 && checkItems();
    }

    public interface LoopAction {
        public int loop();

        public boolean activate();
    }


    public class InCombatLoop implements LoopAction {

        public int loop() {
            //TODO: Double Check If Finisher Code Will Work
            NPC n = methods.fighter.npcs.getInteracting();
            if(n != null && methods.fighter.npcs.getInteracting().getHPPercent() <= 10 &&
                    methods.parent.currentTask.getMonster().getRequirements().getFinisher() != null) {

                if(!methods.fighter.npcs.useFinisher(n)) {
                    log("You ran out of finishers! Stopping Fighter.");
                    killCondition = true;
                }
            }
            else {
                methods.parent.paint.Current = "Fighting";
                methods.fighter.antiban();
            }
            return random(50, 200);
        }

        public boolean activate() {
            return methods.fighter.npcs.isInCombat();
        }

    }

    public class AttackLoop implements LoopAction {

        public int loop() {
            NPC inter = methods.fighter.npcs.getInteracting();
            NPC n = inter != null ? inter : methods.fighter.npcs.getNPC();
            if (n != null) {
                int result;
                //TODO: Double Check If Starter Code Will Work
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
                methods.fighter.antiban();
            }
            return random(50, 200);
        }

        public boolean activate() {
            return !methods.fighter.npcs.isInCombat();
        }

    }

//		private class LootLoop implements LoopAction {
//
//			private RSGroundItem loot = null;
//
//			public int loop() {
//				int origCount = methods.inventory.getCount(true);
//				String name = loot.getItem().getName();
//				int count = loot.getItem().getStackSize();
//				int result = u.loot.takeItem(loot);
//				if (result == 0) {
//					waitWhileMoving();
//				} else if (result == 1) {
//					waitWhileMoving();
//				}
//				return random(50, 200);
//			}
//
//			public boolean activate() {
//				return (loot = u.loot.getLoot()) != null;
//			}
//
//		}

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
        for (SlayerItem i : methods.parent.currentTask.getRequirements().getItems()) {
            if (!isInInvent(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isInInvent(SlayerItem items) {
        for (Item item : Inventory.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    if (Inventory.getCount(true, item.getID()) >= items.getAmount())
                        return true;
                }
            }
        }
        return false;
    }

}

