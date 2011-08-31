package org.powerbot.powerslayer.methods;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.HashMap;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.wrappers.Finisher;
import org.powerbot.powerslayer.wrappers.Starter;
import org.rsbot.script.methods.Calculations;
import org.rsbot.script.methods.Game;
import org.rsbot.script.methods.GroundItems;
import org.rsbot.script.methods.Menu;
import org.rsbot.script.methods.Mouse;
import org.rsbot.script.methods.NPCs;
import org.rsbot.script.methods.Players;
import org.rsbot.script.methods.Settings;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.methods.Walking;
import org.rsbot.script.methods.tabs.Combat;
import org.rsbot.script.methods.tabs.Inventory;
import org.rsbot.script.methods.tabs.Prayer;
import org.rsbot.script.methods.ui.Camera;
import org.rsbot.script.methods.ui.Interfaces;
import org.rsbot.script.util.Filter;
import org.rsbot.script.wrappers.Area;
import org.rsbot.script.wrappers.Character;
import org.rsbot.script.wrappers.GameModel;
import org.rsbot.script.wrappers.GroundItem;
import org.rsbot.script.wrappers.Item;
import org.rsbot.script.wrappers.NPC;
import org.rsbot.script.wrappers.Player;
import org.rsbot.script.wrappers.Tile;

//TODO: Zalgo2462 Touch up
public class UniversalFighter extends DMethodProvider {
	public UniversalFighter(MethodBase methods) {
		super(methods);
	}


	private long nextAntiban = 0;
	public SlayerNPCs npcs = new SlayerNPCs();
	public Eating eat = new Eating();
	public Potion pot = new Potion();
	public Loot loot = new Loot();
	public Tiles tiles = new Tiles();

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
				switch (random(0, 5)) {
				case 0:
					Mouse.moveOffScreen();
					break;
				case 1:
					Mouse.move(random(0, Game.getWidth()), random(0, Game.getHeight()));
					break;
				case 2:
					Mouse.move(random(0, Game.getWidth()), random(0, Game.getHeight()));
					break;
				}
			}
		};
		Thread keyThread = new Thread() {
			public void run() {
				switch (random(0, 4)) {
				case 0:
					Camera.setAngle(Camera.getAngle() + random(-100, 100));
					break;
				case 1:
					Camera.setAngle(Camera.getAngle() + random(-100, 100));
					break;
				case 2:
					Camera.setAngle(Camera.getAngle() + random(-100, 100));
					break;
				}
			}
		};
		if (random(0, 2) == 0) {
			keyThread.start();
			sleep(random(0, 600));
			mouseThread.start();
		} else {
			mouseThread.start();
			sleep(random(0, 600));
			keyThread.start();
		}
		while (keyThread.isAlive() || mouseThread.isAlive())
			sleep(random(30, 100));
	}

	public class SlayerNPCs {

		private String[] npcNames = PowerSlayer.currentTask.getMonster().getNames();

		public NPC lastClickedNPC = null;
		public boolean npcWasClickedLast = false;

		private String weapon = "";
		private boolean hasSpecialWeapon = false;


		public ArrayList<Tile> tilesFoughtOn = new ArrayList<Tile>();

		/**
		 * Checks if we are in combat.
		 *
		 * @return True if we are in combat.
		 */
		public boolean isInCombat() {
			return Players.getLocal().getInteracting() instanceof NPC;
		}

		public boolean useSpecial() {
			if (hasSpecialWeapon) {
				int[] amountUsage = {10, 25, 33, 35, 45, 50, 55, 60, 80, 85, 100};
				String[][] weapons = {
						{"Rune thrownaxe", "Rod of ivandis"},
						{"Dragon Dagger", "Dragon dagger (p)", "Dragon dagger (p+)",
							"Dragon dagger (p++)", "Dragon Mace", "Dragon Spear",
							"Dragon longsword", "Rune claws"},
							{"Dragon Halberd"},
							{"Magic Longbow"},
							{"Magic Composite Bow"},
							{"Dragon Claws", "Abyssal Whip", "Granite Maul", "Darklight",
								"Barrelchest Anchor", "Armadyl Godsword"},
								{"Magic Shortbow"},
								{"Dragon Scimitar", "Dragon 2H Sword", "Zamorak Godsword",
								"Korasi's sword"},
								{"Dorgeshuun Crossbow", "Bone Dagger", "Bone Dagger (p+)",
								"Bone Dagger (p++)"},
								{"Brine Sabre"},
								{"Bandos Godsword", "Dragon Battleaxe", "Dragon Hatchet",
									"Seercull Bow", "Excalibur", "Enhanced excalibur",
									"Ancient Mace", "Saradomin sword"}};

				for (int i = 0; i < weapons.length; i++) {
					for (int j = 0; j < weapons[i].length; j++) {
						if (weapons[i][j].equalsIgnoreCase(weapon)) {
							return Combat.getSpecialEnergy() >= amountUsage[i];
						}
					}
				}
			}
			return false;
		}

		/**
		 * Clicks an NPC based on its model.
		 *
		 * @param npc    The NPC to click.
		 * @param action The action to perform.
		 * @return 0 if the NPC was clicked, 1 if we walked to it, or -1 if nothing happened.
		 */
		public int clickNPC(NPC npc, String action) {
			for (int i = 0; i < 10; i++) {
				if (isPartiallyOnScreen(npc.getModel())) {
					Point p = getPointOnScreen(npc.getModel(), false);
					if (p == null || !Calculations.isPointOnScreen(p)) {
						continue;
					}
					Mouse.move(p, 0, 0);
					String[] items = Menu.getItems();
					if (items.length > 0 && items[0].contains(action)) {
						Mouse.click(true);
						loot.itemWasClickedLast = false;
						npcWasClickedLast = true;
						lastClickedNPC = npc;
						return 0;
					} else if (Menu.contains(action)) {
						Mouse.click(false);
						sleep(random(100, 200));
						for (int x = 0; x < 4; x++) {
							if (!Menu.contains(action)) {
								break;
							}
							if (Menu.click(action)) {
								loot.itemWasClickedLast = false;
								npcWasClickedLast = true;
								lastClickedNPC = npc;
								return 0;
							}
						}
					}
				} else {
					int angle = Camera.getCharacterAngle(npc);
					if (Calculations.distanceTo(npc) < 10 && Math.abs(angle - Camera.getAngle()) > 20) {
						Camera.setAngle(angle + random(-20, 20));
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
		private boolean isPartiallyOnScreen(GameModel m) {
			return getPointOnScreen(m, true) != null;
		}

		/**
		 * Gets a point on a model that is on screen.
		 *
		 * @param m     The RSModel to test.
		 * @param first If true, it will return the first point that it finds on screen.
		 * @return A random point on screen of an object.
		 */
		private Point getPointOnScreen(GameModel m, boolean first) {
			if (m == null) {
				return null;
			}
			ArrayList<Point> list = new ArrayList<Point>();
			try {
				Polygon[] tris = m.getTriangles();
				for (Polygon p : tris) {
					for (int j = 0; j < p.xpoints.length; j++) {
						Point pt = new Point(p.xpoints[j], p.ypoints[j]);
						if (Calculations.isPointOnScreen(pt)) {
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
		private Tile closerTile(Tile t, int dist) {
			Tile loc = getMyPlayer().getLocation();
			int newX = t.getX(), newY = t.getY();
			for (int i = 1; i < dist; i++) {
				newX = t.getX() != loc.getX() ? (t.getX() < loc.getX() ? newX-- : newX++) : newX;
				newY = t.getY() != loc.getY() ? (t.getY() < loc.getY() ? newY-- : newY++) : newY;
			}
			return new Tile(newX, newY);
		}

		/**
		 * Returns the nearest NPC.
		 *
		 * @return The nearest NPC that matches the filter.
		 */
		public NPC getNPC() {
			NPC onScreen = NPCs.getNearest(npcOnScreenFilter);
			if (onScreen != null)
				return onScreen;
			return NPCs.getNearest(npcFilter);
		}

		/**
		 * Returns the interacting NPC that matches our description, if any.
		 *
		 * @return The closest interacting NPC that matches the filter.
		 */
		public NPC getInteracting() {
			NPC npc = null;
			int dist = 20;
			for (NPC n : NPCs.getLoaded()) {
				if (!isOurNPC(n))
					continue;
				Character inter = n.getInteracting();
				if (inter != null && inter instanceof Player && inter.equals(getMyPlayer()) && Calculations.distanceTo(n) < dist) {
					dist = Calculations.distanceTo(n);
					npc = n;
				}
			}
			return npc;
		}

		private boolean isOurNPC(NPC t) {
			String name = t.getName();
			boolean good = false;
			for (String s : npcNames) {
				if (name.toLowerCase().equals(s.toLowerCase()))
					good = true;
			}
			return good;
		}

		public boolean useStarter(NPC monster) {
			return Starter.use(monster);
		}

		public boolean useFinisher(NPC monster) {
			return Finisher.use(monster);
		}

		/**
		 * Waits until the last clicked NPC dies or time runs out... whichever comes first
		 * @param sleep threshold
		 * @return true if last clicked NPC died within threshold, else false
		 */
		public boolean sleepWhileNpcIsDying(int threshold) {
			NPC currNPC = npcs.lastClickedNPC;
			if (currNPC == null || currNPC.isDead())
				return false;
			final Tile npcTile = currNPC.getLocation();
			Filter<NPC> monsterFilter = new Filter<NPC>() {
				public boolean accept(NPC currNPC) {
					return currNPC.getLocation().equals(npcTile);
				}
			};
			for (int i = 0; i < ((threshold/50) + 1); i++) {
				NPC[] NPCList = NPCs.getLoaded(monsterFilter);
				if (NPCList.length == 0)
					break;
				if (i == threshold/50)
					return false;
				sleep (50);
			}
			return true;
		}

		/**
		 * The filter we use!
		 */
		private final Filter<NPC> npcFilter = new Filter<NPC>() {
			public boolean accept(NPC t) {
				return (isOurNPC(t) && t.verify() && !t.isInCombat() && t.getInteracting() == null &&
						t.getHPPercent() != 0 && !tiles.NPCisOnBadTile(t));
			}
		};

		/**
		 * Will only return an on screen NPC. Based on npcFilter.
		 */
		private final Filter<NPC> npcOnScreenFilter = new Filter<NPC>() {
			public boolean accept(NPC n) {
				return npcFilter.accept(n) && getPointOnScreen(n.getModel(), true) != null;
			}
		};
	}

	public class Eating {

		private final int B2P_ID = 8015;
		private final int[] BONES_ID = new int[]{526, 532, 530, 528, 3183, 2859};

		/**
		 * Returns a random integer of when to eat.
		 *
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
			return Inventory.getCount(B2P_ID) > 0;
		}

		/**
		 * Breaks a B2P tab.
		 */
		public void breakB2pTab() {
			Item i = Inventory.getItem(B2P_ID);
			if (i != null)
				i.click(true);
		}

		/**
		 * Checks if the inventory contains bones, for B2P.
		 *
		 * @return True if we have bones.
		 */
		public boolean haveBones() {
			return Inventory.getCount(BONES_ID) > 0;
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
		 * @return The food, or null if none was found.
		 */
		private Item getFood() {
			for (Item i : Inventory.getItems()) {
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
			Item i = getFood();
			if (i == null)
				return false;
			for (int j = 0; j < 3; j++) {
				if (i.interact("Eat")) 
					return true;
			}
			return false;
		}

		/**
		 * Checks whether you need to eat or not.
		 *
		 * @return True if we need to eat.
		 */
		public boolean needEat() {
			return getHPPercent() <= getRandomEatPercent();
		}

		/**
		 * Returns an integer representing the current health percentage.
		 *
		 * @return The current health percentage.
		 */
		public int getHPPercent() {
			try {
				int health = Integer.parseInt(Interfaces.get(748).getComponent(8).getText().trim());
				double ratio = (health*1D)/(Skills.getAbsoluteLevel(Skills.CONSTITUTION) * 10);
				return (int) (100 * ratio);
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

		public boolean setQuickPrayer = true;

		public HashMap<String, Item[]> getPotions() {
			HashMap<String, Item[]> potions = new HashMap<String, Item[]>();

			potions.put("MAGIC", getRealItems(MAGIC_POTIONS));

			potions.put("PRAYER", getRealItems(PRAYER_POTIONS));

			potions.put("RANGE", getRealItems(RANGE_POTIONS));

			potions.put("ENERGY", getRealItems(ENERGY_POTIONS));

			potions.put("COMBAT", getRealItems(COMBAT_POTIONS));

			potions.put("ATTACK", getRealItems(ATTACK_POTIONS));

			potions.put("STRENGTH", getRealItems(STRENGTH_POTIONS));

			potions.put("DEFENSE", getRealItems(DEFENSE_POTIONS));

			potions.put("ANTIPOISON", getRealItems(ANTIPOISON));

			potions.put("ZAMORAK", getRealItems(ZAMORAK_POTIONS));

			potions.put("SARADOMIN", getRealItems(SARADOMIN_POTIONS));

			potions.put("OVERLOAD", getRealItems(OVERLOAD_POTIONS));

			return potions;
		}

		public void usePotions() {
			HashMap<String, Item[]> potions = getPotions();

			if (Inventory.getItems(VIAL).length != 0) {
				for (Item i : Inventory.getItems(VIAL)) {
					int n = Inventory.getCount(true);
					i.interact("Drop Vial");
					SlayerInventory.waitForInvChange(n, 2000);
				}
			}

			if (!(statIsBoosted(Skills.MAGIC)) && (potions.get("MAGIC").length != 0 || potions.get("OVERLOAD").length != 0)) {
				if (potions.get("MAGIC").length != 0) {
					potions.get("MAGIC")[0].click(true);
				}
				else if (potions.get("OVERLOAD").length != 0) {
					potions.get("OVERLOAD")[0].click(true);
				}
			}

			if (shouldUsePrayerPot() && potions.get("PRAYER").length != 0 && setQuickPrayer) {
				int current = Prayer.getRemainingPoints();
				if (potions.get("PRAYER")[0].click(true)) {
					long time = System.currentTimeMillis();
					while(Prayer.getRemainingPoints() == current && System.currentTimeMillis() - time < 10000) {
						sleep(random(200, 500));
					}
				}
			}

			if (!(statIsBoosted(Skills.RANGE)) && (potions.get("RANGE").length != 0 || potions.get("OVERLOAD").length != 0)) {
				if (potions.get("RANGE").length != 0) {
					potions.get("RANGE")[0].click(true);
				}
				else if (potions.get("OVERLOAD").length != 0) {
					potions.get("OVERLOAD")[0].click(true);
				}
			}

			if (Walking.getEnergy() < random(40, 70) && potions.get("ENERGY").length != 0) {
				potions.get("ENERGY")[0].click(true);
			}

			if (!(statIsBoosted(Skills.STRENGTH)) && (potions.get("STRENGTH").length != 0 || potions.get("COMBAT").length != 0 || potions.get("ZAMORAK").length != 0  || potions.get("OVERLOAD").length != 0)) {
				if (potions.get("COMBAT").length != 0) {
					potions.get("COMBAT")[0].click(true);
				}
				else if (potions.get("STRENGTH").length != 0) {
					potions.get("STRENGTH")[0].click(true);
				}
				else if (potions.get("ZAMORAK").length != 0) {
					potions.get("ZAMORAK")[0].click(true);
				}
				else if (potions.get("OVERLOAD").length != 0) {
					potions.get("OVERLOAD")[0].click(true);
				}
			}

			if (!(statIsBoosted(Skills.DEFENSE)) && (potions.get("DEFENSE").length != 0 || potions.get("SARADOMIN").length != 0 || potions.get("OVERLOAD").length != 0)) {
				if (potions.get("DEFENSE").length != 0) {
					potions.get("DEFENSE")[0].click(true);
				}
				else if (potions.get("SARADOMIN").length != 0) {
					potions.get("SARADOMIN")[0].click(true);
				}
				else if (potions.get("OVERLOAD").length != 0) {
					potions.get("OVERLOAD")[0].click(true);
				}
			}

			if (!(statIsBoosted(Skills.ATTACK)) && (potions.get("ATTACK").length != 0 || potions.get("COMBAT").length != 0 || potions.get("ZAMORAK").length != 0 || potions.get("OVERLOAD").length != 0)) {
				if (potions.get("COMBAT").length != 0) {
					potions.get("COMBAT")[0].click(true);
				}
				else if (potions.get("ATTACK").length != 0) {
					potions.get("ATTACK")[0].click(true);
				}
				else if (potions.get("ZAMORAK").length != 0) {
					potions.get("ZAMORAK")[0].click(true);
				}
				else if (potions.get("OVERLOAD").length != 0) {
					potions.get("OVERLOAD")[0].click(true);
				}
			}

			if (isPoisoned() && potions.get("ANTIPOISON").length != 0) {
				potions.get("ANTIPOISON")[0].click(true);
			}
		}

		private Item[] getRealItems(int[] ids) {
			Item[] raw = Inventory.getItems(ids);
			ArrayList<Item> refined = new ArrayList<Item>();
			for (Item item : raw) {
				if (item != null) {
					if (item.getID() != -1) {
						refined.add(item);
					}
				}
			}
			return refined.toArray(new Item[refined.size()]);
		}

		private boolean shouldUsePrayerPot() {
			return (Skills.getAbsoluteLevel(Skills.PRAYER) - Prayer.getRemainingPoints()) > (7+Math.floor(Skills.getAbsoluteLevel(Skills.PRAYER)/4));
		}

		private boolean statIsBoosted(int Skill) {
			return Skills.getLevel(Skill) != Skills.getAbsoluteLevel(Skill);
		}
	}

	public class Loot {

		private String[] lootNames = new String[0];

		public GroundItem lastClickedItem = null;
		public boolean itemWasClickedLast = false;

		public boolean onlyTakeLootFromKilled = false;

		/**
		 * Gets the nearest loot, based on the filter
		 *
		 * @return The nearest item to loot, or null if none.
		 */
		public GroundItem getLoot() {
			return GroundItems.getNearest(lootFilter);
		}

		/**
		 * Attempts to take an item.
		 *
		 * @param item The item to take.
		 * @return -1 if error, 0 if taken, 1 if walked
		 */
		
		public int takeItem(GroundItem item) {
			if (item == null)
				return -1;
			String action = "Take " + item.getItem().getName();
			if (item.isOnScreen()) {
				for (int i = 0; i < 5; i++) {
					if (Menu.isOpen())
						Mouse.moveRandomly(300, 500);
					Point p = item.getLocation().toScreen(random(0.48, 0.52), random(0.48, 0.52), 0);
					if (!Calculations.isPointOnScreen(p))
						continue;
					Mouse.move(p, 3, 3);
					if (Menu.contains(action)) {
						if (Menu.getItems()[0].contains(action)) {
							Mouse.click(true);
							itemWasClickedLast = true;
							npcs.npcWasClickedLast = false;
							lastClickedItem = item;
							return 0;
						} else {
							Mouse.click(false);
							sleep(random(100, 200));
							if (Menu.click(action)) {
								itemWasClickedLast = true;
								npcs.npcWasClickedLast = false;
								lastClickedItem = item;
								return 0;
							}
						}
					}
				}
			} else {
				Walking.walkTileMM(Walking.getClosestTileOnMap(item.getLocation()));
				sleep(random(1500, 2000));
				if (!Players.getLocal().isMoving()) {
					tiles.addBadTile(item.getLocation());
					return -1;
				}
				return 1;
			}
			return -1;
		}

		private final Filter<GroundItem> lootFilter = new Filter<GroundItem>() {
			public boolean accept(GroundItem t) {
				//Skip if we can't hold it
				Item i;
				if (Inventory.isFull() && ((i = Inventory.getItem(t.getItem().getID())) == null || i.getStackSize() <= 1)) {
					return false;
				}
				//Skip if its out of radius or far away
				if (Calculations.distanceTo(t.getLocation()) > 25) {
					return false;
				}
				//Check ID/getName
				boolean good = false;
				String name = t.getItem().getName();
				for (String s : lootNames) {
					if (name != null && name.toLowerCase().contains(s.toLowerCase()))
						good = true;
				}

				if (good) {
					for (Tile badTile : tiles.badTiles) {
						if (t.getLocation().getX() == badTile.getX() && t.getLocation().getY() == badTile.getY() ) {
							good = false;
							break;
						}
					}
				}
				if (good && onlyTakeLootFromKilled) {
					if (!npcs.tilesFoughtOn.isEmpty()) {
						for (Tile tileFoughtOn : npcs.tilesFoughtOn) {
							if (t.getLocation().getX() == tileFoughtOn.getX() && t.getLocation().getY() == tileFoughtOn.getY()) {
								return true;
							} else {
								good = false;
							}
						}
					} else {
						good = false;
					}
				}
				return good;
			}
		};

	}

	public class Tiles {
		ArrayList<Tile> badTiles = new ArrayList<Tile>();
		int threshold = 5;

		public Tile getNearestTile(Tile[] tiles) {
			Tile closest = null;
			for (Tile t : tiles) {
				if (closest == null || Calculations.distanceTo(t) < Calculations.distanceTo(closest))
					closest = t;
			}
			return closest;
		}

		public void addBadTile(Tile tile) {
			addBadTile(tile, threshold);
		}

		public void addBadTile(Tile tile, int thres) {
			if (thres > -1) {
				if (badTiles.size() > 0) {

					ArrayList<Tile> tilesWithinRadius = new ArrayList<Tile>();

					for (Tile badTile : badTiles) {
						if (Calculations.distanceBetween(badTile, tile) < thres) {
							tilesWithinRadius.add(badTile);
						}
					}

					if (tilesWithinRadius.size() > 1) {
						tilesWithinRadius.add(tile);
						Area temp = new Area(tilesWithinRadius.toArray(new Tile[tilesWithinRadius.size()]));
						Tile[] areaTiles = temp.getTileArray();
						for (Tile tileToAdd : areaTiles) {
							if (!badTiles.contains(tileToAdd)) {
								badTiles.add(tileToAdd);
							}
						}
						if (!badTiles.contains(tile)) {
							badTiles.add(tile);
						}

					} else {
						if (!badTiles.contains(tile)) {
							badTiles.add(tile);
						}
					}
				} else {
					badTiles.add(tile);
				}
			}
		}

		private boolean NPCisOnBadTile(NPC t) {
			for (Tile badTile: badTiles) {
				if (t.getLocation().getX() == badTile.getX() &&
						t.getLocation().getY() == badTile.getY() ) {
					return true;
				}
			}
			return false;
		}


	}

	private boolean isPoisoned() {
		return Settings.get(102) > 0 || Interfaces.getComponent(748, 4).getTextureID() == 1801;
	}
}