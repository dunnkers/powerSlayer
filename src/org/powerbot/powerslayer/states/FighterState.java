package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.common.MethodBase;
import org.rsbot.script.methods.Game;
import org.rsbot.script.wrappers.RSNPC;


public class FighterState extends State {

    public FighterState(MethodBase methods) {
        super(methods);
    }

    private int badFoodCount = 0;
    private LoopAction[] loopActions = new LoopAction[]{new InCombatLoop(), new AttackLoop()};

    @Override
    public int loop() {
        if (!methods.walking.isRunEnabled() && methods.walking.getEnergy() > random(60, 90)) {
            methods.walking.setRun(true);
            return random(1200, 1600);
        }
        if (methods.interfaces.canContinue()) {
            methods.interfaces.clickContinue();
            return random(1200, 1600);
        }
        if (methods.game.getCurrentTab() != Game.TAB_INVENTORY) {
            methods.game.openTab(Game.TAB_INVENTORY);
            return random(700, 1500);
        }
        if (methods.fighter.eat.needEat()) {
            if (methods.fighter.eat.haveFood()) {
                badFoodCount = 0;
                methods.fighter.eat.eatFood();
            } else if (methods.fighter.eat.haveB2pTab() && methods.fighter.eat.haveBones()) {
                methods.fighter.eat.breakB2pTab();
                return random(2600, 3000);
            } else {
                badFoodCount++;
                if (badFoodCount > 5) {
                    log("You ran out of food! Stopping.");
                    methods.parent.stopScript(true);
                }
            }
            return random(1200, 1600);
        }

        if (methods.fighter.pot.needPot()) {
            return methods.fighter.pot.usePotions();
        }

        for (LoopAction a : loopActions)
            if (a != null && a.activate())
                return a.loop();
        return random(50, 200);
    }

    @Override
    public boolean activeCondition() {
        RSNPC inter = methods.fighter.npcs.getInteracting();
        RSNPC n = inter != null ? inter : methods.fighter.npcs.getNPC();
        return n != null;
    }

    public interface LoopAction {
        public int loop();

        public boolean activate();
    }

    public class InCombatLoop implements LoopAction {

        public int loop() {
            // add finisher code
            methods.fighter.antiban();
            return random(50, 200);
        }

        public boolean activate() {
            return methods.fighter.npcs.isInCombat();
        }

    }

    public class AttackLoop implements LoopAction {

        public int loop() {
            RSNPC inter = methods.fighter.npcs.getInteracting();
            RSNPC n = inter != null ? inter : methods.fighter.npcs.getNPC();
            if (n != null) {
                // add starter code
                int result = methods.fighter.npcs.clickNPC(n, "Attack " + n.getName());
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
}

