package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.rsbot.script.methods.Skills;
import org.rsbot.script.util.Filter;
import org.rsbot.script.wrappers.RSCharacter;
import org.rsbot.script.wrappers.RSItem;
import org.rsbot.script.wrappers.RSModel;
import org.rsbot.script.wrappers.RSNPC;
import org.rsbot.script.wrappers.RSPlayer;
import org.rsbot.script.wrappers.RSTile;

public class UniversalFighter extends DMethodProvider {
	public UniversalFighter(MethodBase methods) {
		super(methods);
	}

		private long nextAntiban = 0;
        public NPCs npcs = new NPCs();
		public Eating eat = new Eating();
        public Potion pot = new Potion();

		/**
		 * Waits until the inventory count changes
		 */
		public boolean waitForInvChange(int origCount) {
			long start = System.currentTimeMillis();
			while (methods.inventory.getCount(true) == origCount && System.currentTimeMillis() - start < 2000) {
				sleep(random(20, 70));
			}
			return methods.inventory.getCount(true) != origCount;
		}


		public int[] toIntArray(Integer[] ints) {
			int[] done = new int[ints.length];
			for (int i = 0; i < done.length; i++) {
				done[i] = ints[i].intValue();
			}
			return done;
		}

		/**
		 * Performs a random action, always.
		 * Actions: move mouse, move mouse off screen, move camera.
		 */
		public void antiban() {
			if (System.currentTimeMillis() > nextAntiban) {
				nextAntiban = System.currentTimeMillis() + random(2000, 30000);
			} else {
				return;
			}
			Thread mouseThread = new Thread() {
				public void run() {
					switch(random(0, 5)) {
					case 0:
						methods.mouse.moveOffScreen();
						break;
					case 1:
						methods.mouse.move(random(0, methods.game.getWidth()), random(0, methods.game.getHeight()));
						break;
					case 2:
						methods.mouse.move(random(0, methods.game.getWidth()), random(0, methods.game.getHeight()));
						break;
					}
				}
			};
			Thread keyThread = new Thread() {
				public void run() {
					switch(random(0, 4)) {
					case 0:
						methods.camera.setAngle(methods.camera.getAngle() + random(-100, 100));
						break;
					case 1:
						methods.camera.setAngle(methods.camera.getAngle() + random(-100, 100));
						break;
					case 2:
						methods.camera.setAngle(methods.camera.getAngle() + random(-100, 100));
						break;
					}
				}
			};
			if(random(0, 2) == 0) {
				keyThread.start();
				sleep(random(0, 600));
				mouseThread.start();
			} else {
				mouseThread.start();
				sleep(random(0, 600));
				keyThread.start();
			}
			while(keyThread.isAlive() || mouseThread.isAlive())
				sleep(random(30, 100));
		}

		public class NPCs {

			private String[] npcNames = methods.parent.currentTask.getMonster().getNames();
			/**
			 * Checks if we are in combat.
			 *
			 * @return True if we are in combat.
			 */
			public boolean isInCombat() {
				return getMyPlayer().getInteracting() instanceof RSNPC;
			}

			/**
			 * Clicks an NPC based on its model.
			 *
			 * @param npc    The NPC to click.
			 * @param action The action to perform.
			 * @return 0 if the NPC was clicked, 1 if we walked to it, or -1 if nothing happened.
			 */
			public int clickNPC(RSNPC npc, String action) {
				for (int i = 0; i < 10; i++) {
					if (isPartiallyOnScreen(npc.getModel())) {
						Point p =  getPointOnScreen(npc.getModel(), false);
						if (p == null || !methods.calc.pointOnScreen(p)) {
							continue;
						}
						methods.mouse.move(p, 0, 0);
						String[] items = methods.menu.getItems();
						if (items.length > 0 && items[0].contains(action)) {
							methods.mouse.click(true);
							return 0;
						} else if (methods.menu.contains(action)) {
							methods.mouse.click(false);
							sleep(random(100, 200));
							for (int x = 0; x < 4; x++) {
								if (!methods.menu.contains(action)) {
									break;
								}
								if (methods.menu.doAction(action)) {
									return 0;
								}
							}
						}
					} else {
						int angle = methods.camera.getCharacterAngle(npc);
						if (methods.calc.distanceTo(npc) < 10 && Math.abs(angle - methods.camera.getAngle()) > 20) {
							methods.camera.setAngle(angle + random(-20, 20));
						}
					}
				}
				return -1;
			}

			/**
			 * Checks if a model is partially on screen.
			 *
			 * @param m The RSModel to check.
			 * @return True if any point on the model is on screen.
			 */
			private boolean isPartiallyOnScreen(RSModel m) {
				return getPointOnScreen(m, true) != null;
			}

			/**
			 * Gets a point on a model that is on screen.
			 *
			 * @param m     The RSModel to test.
			 * @param first If true, it will return the first point that it finds on screen.
			 * @return A random point on screen of an object.
			 */
			private Point getPointOnScreen(RSModel m, boolean first) {
				if (m == null)
					return null;
				ArrayList<Point> list = new ArrayList<Point>();
				try {
					Polygon[] tris = m.getTriangles();
					for (int i = 0; i < tris.length; i++) {
						Polygon p = tris[i];
						for (int j = 0; j < p.xpoints.length; j++) {
							Point pt = new Point(p.xpoints[j], p.ypoints[j]);
							if (methods.calc.pointOnScreen(pt)) {
								if (first)
									return pt;
								list.add(pt);
							}
						}
					}
				} catch (Exception e) {
				}
				return list.size() > 0 ? list.get(random(0, list.size())) : null;
			}



			/**
			 * Calculates the distance between two points.
			 *
			 * @param p1 The first point.
			 * @param p2 The second point.
			 * @return The distance between the two points, using the distance formula.
			 */
			private double distanceBetween(Point p1, Point p2) {
				return Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y)));
			}

			/**
			 * Gets a closer tile to us within dist.
			 *
			 * @param t    The tile to start with.
			 * @param dist The max dist.
			 * @return A closer tile.
			 */
			private RSTile closerTile(RSTile t, int dist) {
				RSTile loc = getMyPlayer().getLocation();
				int newX = t.getX(), newY = t.getY();
				for (int i = 1; i < dist; i++) {
					newX = t.getX() != loc.getX() ? (t.getX() < loc.getX() ? newX-- : newX++) : newX;
					newY = t.getY() != loc.getY() ? (t.getY() < loc.getY() ? newY-- : newY++) : newY;
				}
				return new RSTile(newX, newY);
			}

			/**
			 * Returns the nearest NPC.
			 *
			 * @return The nearest NPC that matches the filter.
			 */
			public RSNPC getNPC() {
				RSNPC onScreen = methods.npcs.getNearest(npcOnScreenFilter);
				if(onScreen != null)
					return onScreen;
				return methods.npcs.getNearest(npcFilter);
			}

			/**
			 * Returns the interacting NPC that matches our description, if any.
			 *
			 * @return The closest interacting NPC that matches the filter.
			 */
			public RSNPC getInteracting() {
				RSNPC npc = null;
				int dist = 20;
				for (RSNPC n : methods.npcs.getAll()) {
					if (!isOurNPC(n))
						continue;
					RSCharacter inter = n.getInteracting();
					if (inter != null && inter instanceof RSPlayer && inter.equals(getMyPlayer()) && methods.calc.distanceTo(n) < dist) {
						dist = methods.calc.distanceTo(n);
						npc = n;
					}
				}
				return npc;
			}

			private boolean isOurNPC(RSNPC t) {
				String name = t.getName();
				boolean good = false;
				for (String s : npcNames) {
					if (name.toLowerCase().equals(s.toLowerCase()))
						good = true;
				}
				return good;
			}

			/**
			 * The filter we use!
			 */
			 private final Filter<RSNPC> npcFilter = new Filter<RSNPC>() {
				public boolean accept(RSNPC t) {
					return (isOurNPC(t) && t.isValid() && !t.isInCombat() && t.getInteracting() == null && t.getHPPercent() != 0);
				}
			 };

			 /**
			  * Will only return an on screen NPC. Based on npcFilter.
			  */
			 private final Filter<RSNPC> npcOnScreenFilter = new Filter<RSNPC>() {
				 public boolean accept(RSNPC n) {
					 return npcFilter.accept(n) && getPointOnScreen(n.getModel(), true) != null;
				 }
			 };
		}

		public class Eating {

			private final int[] B2P_TAB_ID = new int[]{8015};
			private final int[] BONES_ID = new int[]{526, 532, 530, 528, 3183, 2859};

			private int toEatAtPercent = getRandomEatPercent();

			/**
			 * Returns a random integer of when to eat.
			 * @return A random integer of the percent to eat at.
			 */
			private int getRandomEatPercent() {
				return random(45, 60);
			}

			/**
			 * Checks if we have at least one B2P tab.
			 *
			 * @return True if we have a tab.
			 */
			public boolean haveB2pTab() {
				return methods.inventory.getCount(B2P_TAB_ID) > 0;
			}

			/**
			 * Breaks a B2P tab.
			 */
			public void breakB2pTab() {
				RSItem i = methods.inventory.getItem(B2P_TAB_ID);
				if (i != null)
					i.doClick(true);
			}

			/**
			 * Checks if the inventory contains bones, for B2P.
			 *
			 * @return True if we have bones.
			 */
			public boolean haveBones() {
				return methods.inventory.getCount(BONES_ID) > 0;
			}

			/**
			 * Checks if we have food.
			 *
			 * @return True if we have food.
			 */
			public boolean haveFood() {
				return getFood() != null;
			}

			/**
			 * Finds food based on inventory actions.
			 *
			 * @return The RSItem of food, or null if none was found.
			 */
			private RSItem getFood() {
				for (RSItem i : methods.inventory.getItems()) {
					if (i == null || i.getID() == -1)
						continue;
					if (i.getComponent().getActions() == null || i.getComponent().getActions()[0] == null)
						continue;
					if (i.getComponent().getActions()[0].contains("Eat"))
						return i;
				}
				return null;
			}

			/**
			 * Attempts to eat food.
			 *
			 * @return True if we ate.
			 */
			public boolean eatFood() {
				RSItem i = getFood();
				for (int j = 0; j < 3; j++) {
					if (i == null)
						break;
					if (i.doAction("Eat")) {
						return true;
					}
				}
				return false;
			}

			/**
			 * Checks whether you need to eat or not.
			 *
			 * @return True if we need to eat.
			 */
			public boolean needEat() {
				if(getHPPercent() <= toEatAtPercent) {
					toEatAtPercent = getRandomEatPercent();
					return true;
				}
				return false;
			}

			/**
			 * Returns an integer representing the current health percentage.
			 * @return The current health percentage.
			 */
			public int getHPPercent() {
				try {
					return ((int) ((Integer.parseInt(methods.interfaces.get(748).getComponent(8).getText().trim()) / (double)(methods.skills.getRealLevel(Skills.CONSTITUTION) * 10)) * 100));
				} catch (Exception e) {
					return 100;
				}
			}
		}

		public class Potion {

			private final int[] MAGIC_POTIONS = new int[] {3040, 3042, 3044, 3046, 11513, 11515, 13520, 13521, 13522, 13523};

			private final int[] PRAYER_POTIONS = new int[] {2434, 139, 141, 143, 11465, 11467};

			private final int[] RANGE_POTIONS = new int[] {2444, 169, 171, 173, 11509, 11511, 13524, 13525, 15326, 15327};

			private final int[] ENERGY_POTIONS = new int[] {3008, 3010, 3012, 3014, 3016, 3018, 3020, 3022, 11453, 11455,
															11481, 11483};

			private final int[] COMBAT_POTIONS = new int[] {9739, 9741, 9743, 9745, 11445, 11447};

			private final int[] ATTACK_POTIONS = new int[] {2428, 121, 123, 125, 2436, 145, 147, 149, 11429, 11431,
															11429, 11431, 11429, 11431, 11469, 11471, 15308	, 15309, 15310, 15311};

			private final int[] STRENGTH_POTIONS = new int[] {113, 115, 117, 119, 2440, 157, 159, 161, 11443, 11441,
															  11485, 11487, 15312, 15313, 15314, 15315};

			private final int[] DEFENSE_POTIONS = new int[] {2432, 133, 135, 137, 2442, 163, 165, 167, 11457, 11459,
															 11497, 11499, 15316, 15317, 15318, 15319};

			private final int[] ANTIPOISON = new int[] {2446, 175, 177, 179, 2448, 181, 183, 185, 5952, 5954,
														5956, 5958, 5943, 5945, 5947, 5949, 11433, 11435, 11501, 11503};

			private final int[] ZAMORAK_POTIONS = new int[] {2450, 189, 191, 193, 11521, 11523};

			private final int[] SARADOMIN_POTIONS = new int[] {6685, 6687, 6689, 6691};

			private final int[] OVERLOAD_POTIONS = new int[] {15332, 15333, 15334, 15335};

			private final int[] VIAL = new int[] {229};

			private HashMap<String, RSItem[]> getPotions() {
				HashMap<String, RSItem[]> potions = new HashMap<String, RSItem[]>();
				potions.put("MAGIC", methods.inventory.getItems(MAGIC_POTIONS));
				potions.put("PRAYER", methods.inventory.getItems(PRAYER_POTIONS));
				potions.put("RANGE", methods.inventory.getItems(RANGE_POTIONS));
				potions.put("ENERGY", methods.inventory.getItems(ENERGY_POTIONS));
				potions.put("COMBAT", methods.inventory.getItems(COMBAT_POTIONS));
				potions.put("ATTACK", methods.inventory.getItems(ATTACK_POTIONS));
				potions.put("STRENGTH", methods.inventory.getItems(STRENGTH_POTIONS));
				potions.put("DEFENSE", methods.inventory.getItems(DEFENSE_POTIONS));
				potions.put("ANTIPOISON", methods.inventory.getItems(ANTIPOISON));
				potions.put("ZAMORAK", methods.inventory.getItems(ZAMORAK_POTIONS));
				potions.put("SARADOMIN", methods.inventory.getItems(SARADOMIN_POTIONS));
				potions.put("OVERLOAD", methods.inventory.getItems(OVERLOAD_POTIONS));
				return potions;
			}

			public boolean needPot() {
				HashMap<String, RSItem[]> potions = getPotions();

				if(methods.inventory.getItems(VIAL).length != 0) {
					for( RSItem i : methods.inventory.getItems(VIAL)) {
						int n = methods.inventory.getCount(true);
						i.doAction("Drop Vial");
						waitForInvChange(n);
					}
				}

				if( potions.get("MAGIC").length != 0 && !statIsBoosted(Skills.MAGIC)) {
					return true;
				}
                /// uses statIsBoosted to see if any prayer was used since the levels wont equal each other
				if( potions.get("PRAYER").length != 0 && statIsBoosted(Skills.PRAYER)) {
					return true;
				}

				if(potions.get("RANGE").length != 0 && !statIsBoosted(Skills.RANGE)) {
					return true;
				}
				if(potions.get("ENERGY").length != 0 && methods.walking.getEnergy() < random(40, 70)) {
					return true;
				}

				if(potions.get("COMBAT").length != 0 && (!statIsBoosted(Skills.ATTACK) || !statIsBoosted(Skills.STRENGTH))) {
					return true;
				}

				if(potions.get("ATTACK").length != 0 && !statIsBoosted(Skills.ATTACK)) {
					return true;
				}

				if(potions.get("STRENGTH").length != 0 && !statIsBoosted(Skills.STRENGTH)) {
					return true;
				}

				if(potions.get("DEFENSE").length != 0 && !statIsBoosted(Skills.DEFENSE)) {
					return true;
				}

				if(potions.get("ANTIPOISON").length != 0 && methods.combat.isPoisoned()) {
					return true;
				}

				if(potions.get("ZAMORAK").length != 0 && (!statIsBoosted(Skills.ATTACK) || !statIsBoosted(Skills.STRENGTH))) {
					return true;
				}

				if(potions.get("SARADOMIN").length != 0 && !statIsBoosted(Skills.DEFENSE)) {
					return true;
				}

				if(potions.get("OVERLOAD").length != 0 && (!statIsBoosted(Skills.ATTACK) || !statIsBoosted(Skills.STRENGTH) ||
					!statIsBoosted(Skills.DEFENSE) || !statIsBoosted(Skills.RANGE) || !statIsBoosted(Skills.MAGIC))) {
					return true;
				}
				return false;
			}

			public int usePotions() {
				HashMap<String, RSItem[]> potions = getPotions();

				if(!(statIsBoosted(Skills.MAGIC)) && (potions.get("MAGIC").length != 0 || potions.get("OVERLOAD").length != 0)) {
					if(potions.get("MAGIC").length != 0) {
						potions.get("MAGIC")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("OVERLOAD").length != 0) {
						potions.get("OVERLOAD")[0].doClick(true);
						return random(2000, 2500);
					}
				}

				if( (methods.skills.getRealLevel(Skills.PRAYER) - methods.skills.getCurrentLevel(Skills.PRAYER) >= random( Math.floor(7 + methods.skills.getRealLevel(Skills.PRAYER) / 4) - 2 , Math.floor(7 +(methods.skills.getRealLevel(Skills.PRAYER) / 4))  + 2)) && potions.get("PRAYER").length != 0) {
					return random(2000, 2500);
				}

				if(!(statIsBoosted(Skills.RANGE)) && (potions.get("RANGE").length != 0 || potions.get("OVERLOAD").length != 0)) {
					if(potions.get("RANGE").length != 0) {
						potions.get("RANGE")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("OVERLOAD").length != 0) {
						potions.get("OVERLOAD")[0].doClick(true);
						return random(2000, 2500);
					}
				}

				if(methods.walking.getEnergy() < random(40, 70) && potions.get("ENERGY").length != 0) {
					potions.get("ENERGY")[0].doClick(true);

					return random(2000, 2500);
				}

				if(!(statIsBoosted(Skills.STRENGTH)) && (potions.get("STRENGTH").length != 0 || potions.get("COMBAT").length != 0 || potions.get("ZAMORAK").length != 0  || potions.get("OVERLOAD").length != 0)) {
					if(potions.get("COMBAT").length != 0) {
						potions.get("COMBAT")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("STRENGTH").length != 0) {
						potions.get("STRENGTH")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("ZAMORAK").length != 0) {
						potions.get("ZAMORAK")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("OVERLOAD").length != 0) {
						potions.get("OVERLOAD")[0].doClick(true);
						return random(2000, 2500);
					}
				}

				if(!(statIsBoosted(Skills.DEFENSE)) && (potions.get("DEFENSE").length != 0 || potions.get("SARADOMIN").length != 0 || potions.get("OVERLOAD").length != 0)) {
					if(potions.get("DEFENSE").length != 0) {
						potions.get("DEFENSE")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("SARADOMIN").length != 0) {
						potions.get("SARADOMIN")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("OVERLOAD").length != 0) {
						potions.get("OVERLOAD")[0].doClick(true);
						return random(2000, 2500);
					}
				}

				if(!(statIsBoosted(Skills.ATTACK)) && (potions.get("ATTACK").length != 0 || potions.get("COMBAT").length != 0 || potions.get("ZAMORAK").length != 0 || potions.get("OVERLOAD").length != 0)) {
					if(potions.get("COMBAT").length != 0) {
						potions.get("COMBAT")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("ATTACK").length != 0) {
						potions.get("ATTACK")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("ZAMORAK").length != 0) {
						potions.get("ZAMORAK")[0].doClick(true);
						return random(2000, 2500);
					}
					else if(potions.get("OVERLOAD").length != 0) {
						potions.get("OVERLOAD")[0].doClick(true);
						return random(2000, 2500);
					}
				}

				if(methods.combat.isPoisoned() && potions.get("ANTIPOISON").length != 0) {
					potions.get("ANTIPOISON")[0].doClick(true);
					return random(2000, 2500);
				}

				return random(50, 200);

			}


			private boolean statIsBoosted(int Skill) {
				return methods.skills.getCurrentLevel(Skill) != methods.skills.getRealLevel(Skill);
			}

		}

//		private class Loot {
//
//			private String[] lootNames = new String[0];
//
//
//			/**
//			 * Gets the nearest loot, based on the filter
//			 *
//			 * @return The nearest item to loot, or null if none.
//			 */
//			private RSGroundItem getLoot() {
//				return methods.groundItems.getNearest(lootFilter);
//			}
//
//			/**
//			 * Attempts to take an item.
//			 *
//			 * @param item The item to take.
//			 * @return -1 if error, 0 if taken, 1 if walked
//			 */
//			private int takeItem(RSGroundItem item) {
//				if (item == null)
//					return -1;
//				String action = "Take " + item.getItem().getName();
//				if (item.isOnScreen()) {
//					for (int i = 0; i < 5; i++) {
//						if (methods.menu.isOpen())
//							methods.mouse.moveRandomly(300, 500);
//						Point p = methods.calc.tileToScreen(item.getLocation(), random(0.48, 0.52), random(0.48, 0.52), 0);
//						if (!methods.calc.pointOnScreen(p))
//							continue;
//						methods.mouse.move(p, 3, 3);
//						if (methods.menu.contains(action)) {
//							if (methods.menu.getItems()[0].contains(action)) {
//								methods.mouse.click(true);
//								return 0;
//							} else {
//								methods.mouse.click(false);
//								sleep(random(100, 200));
//								if (methods.menu.doAction(action))
//									return 0;
//							}
//						}
//					}
//				} else {
//					methods.walking.walkTileMM(methods.walking.getClosestTileOnMap(item.getLocation()));
//					return 1;
//				}
//				return -1;
//			}
//
//			private final Filter<RSGroundItem> lootFilter = new Filter<RSGroundItem>() {
//				public boolean accept(RSGroundItem t) {
//					//Skip if we can't hold it
//					RSItem i;
//					if (methods.inventory.isFull() && ((i = methods.inventory.getItem(t.getItem().getID())) == null || i.getStackSize() <= 1)) {
//						return false;
//					}
//					//Skip if its out of radius or far away
//					if (methods.calc.distanceTo(t.getLocation()) > 25) {
//						return false;
//					}
//					//Check ID/name
//					boolean good = false;
//					String name = t.getItem().getName();
//					for (String s : lootNames) {
//						if (name != null && name.toLowerCase().contains(s.toLowerCase()))
//							good = true;
//					}
//					return good;
//				}
//			};
//
//		}

	}