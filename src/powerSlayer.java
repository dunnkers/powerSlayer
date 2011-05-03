import org.rsbot.event.listeners.PaintListener;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.methods.Magic;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.RSArea;
import org.rsbot.script.wrappers.RSItem;
import org.rsbot.script.wrappers.RSNPC;
import org.rsbot.script.wrappers.RSTile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ScriptManifest(authors = {"Powerbot Scripters Team"}, name = "Power Slayer", version = 0.1, description = "Slayer bot.")
public class powerSlayer extends Script implements PaintListener, MouseListener {
    private Task currentTask;
    private SlayerMaster slayerMaster;
    private int weaponSpecUsage = -1;
    private List<String> pickup = new ArrayList<String>();
    private RSNPC currentMonster;
    private int tab = 1;

    private enum SlayerMaster {
        MAZCHNA("Mazchna", new RSTile(0, 0), 20),
        TURAEL("Turael", new RSTile(0, 0), 3);
        private RSTile location;
        private String name;
        private int combatLevel;
        private int slayerLevel;

        private SlayerMaster(String name, RSTile location, int combatLevel) {
            this.name = name;
            this.location = location;
            this.combatLevel = combatLevel;
            this.slayerLevel = 0;
        }

        private SlayerMaster(String name, RSTile location, int combatLevel, int slayerLevel) {
            this.name = name;
            this.location = location;
            this.combatLevel = combatLevel;
            this.slayerLevel = slayerLevel;
        }

        public SlayerMaster get(String name) {
            for (SlayerMaster master : values()) {
                if (name.toLowerCase().contains(master.getName().toLowerCase())) {
                    return master;
                }
            }
            return null;
        }

        public RSTile getLocation() {
            return this.location;
        }

        public String getName() {
            return this.name;
        }

        private int getSlayerLevel() {
            return this.slayerLevel;
        }

        private int getCombatLevel() {
            return this.combatLevel;
        }
    }

    private static enum Monsters {
        ABBERANT_SPECTRE("Aberrant Spectre", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Slayer helmet", "Nosepeg"}, org.rsbot.script.methods.Equipment.HELMET))),
        ABYSSAL_DEMON("Abyssal Demon", new Location(new RSTile(0, 0), 0)),
        AQUANITE("Aquanite", new Location(new RSTile(0, 0), 0)),
        ANKOU("Ankou", new Location(new RSTile(0, 0), 0)),
        BANSHEE("Banshee", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Earmuffs", "Masked earmuffs", "Slayer helmet"}, org.rsbot.script.methods.Equipment.HELMET))),
        BASILISK("Basilisk", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Mirror shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        BAT("Bat", new Location(new RSTile(0, 0), 0)),
        BEAR("Black bear", new Location(new RSTile(0, 0), 0)),
        BIRD("Chicken", new Location(new RSTile(0, 0), 0)),
        BLACK_DEMON("Black demon", new Location(new RSTile(0, 0), 0)),
        BLACK_DRAGON("Black dragon", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Dragonfire shield", "Anti-dragon shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        BLOODVELD("Bloodveld", new Location(new RSTile(0, 0), 0)),
        BLUE_DRAGON("Blue dragon", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Dragonfire shield", "Anti-dragon shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        BRINE_RAT("Brine rat", new Location(new RSTile(0, 0), 0)),
        BRONZE_DRAGON("Bronze dragon", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Dragonfire shield", "Anti-dragon shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        CATABLEPON("Catablepon", new Location(new RSTile(0, 0), 0)),
        CAVE_BUG("Cave bug", new Location(new RSTile(0, 0), 0)),
        CAVE_CRAWLER("Cave crawler", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Antipoison (1)", "Antipoison (2)", "Antipoison (3)", "Antipoison (4)"}))),
        CAVE_HORROR("Cave horror", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Witchwood icon"}, org.rsbot.script.methods.Equipment.NECK))),
        CAVE_SLIME("Cave slime", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Antipoison (1)", "Antipoison (2)", "Antipoison (3)", "Antipoison (4)"}))),
        COCKATRICE("Cockatrice", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Mirror sheild"}, org.rsbot.script.methods.Equipment.SHIELD))),
        COW("Cow", new Location(new RSTile(0, 0), 0)),
        CROCODILE("Crocodile", new Location(new RSTile(0, 0), 0), new Requirements(new Item[]{new Item(new String[]{"Waterskin (1)", "Waterskin (2)", "Waterskin (3)", "Waterskin (4)"}), new Item(new String[]{"Ice coolers"})}, new Finisher(new String[]{"Rock hammer"}))),
        DRAGANNOTH("Dragannoth", new Location(new RSTile(0, 0), 0)),
        DARK_BEAST("Dark beast", new Location(new RSTile(0, 0), 0)),
        //Moruner Armour...
        DESERT_LIZARD("Desert lizard", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Waterskin (1)", "Waterskin (2)", "Waterskin (3)", "Waterskin (4)"}))),
        DOG("Guard dog", new Location(new RSTile(0, 0), 0)),
        DUST_DEVIL("Dust devil", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Slayer helmet", "Facemask"}, org.rsbot.script.methods.Equipment.HELMET))),
        DWARF("Dwarf", new Location(new RSTile(0, 0), 0)),
        EARTH_WARRIOR("Earth warrior", new Location(new RSTile(0, 0), 0)),
        ELF("Elf warrior", new Location(new RSTile(0, 0), 0)),
        FEVER_SPIDER("Fever spider", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Slayer gloves"}, org.rsbot.script.methods.Equipment.HANDS))),
        FIRE_GIANTS("Fire giants", new Location(new RSTile(0, 0), 0)),
        FLESH_CRAWLERS("Flesh crawlers", new Location(new RSTile(0, 0), 0)),
        GARGOYLE("Gargoyle", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Rock hammer"}), new Finisher(new String[]{"Rock hammer"}))),
        GHOST("Ghost", new Location(new RSTile(0, 0), 0)),
        GHOUL("Ghoul", new Location(new RSTile(0, 0), 0)),
        GIANT_SPIDER("Giant spider", new Location(new RSTile(0, 0), 0)),
        GOBLIN("Goblin", new Location(new RSTile(0, 0), 0)),
        GORAK("Gorak", new Location(new RSTile(0, 0), 0)),
        GREATER_DEMON("Greater demon", new Location(new RSTile(0, 0), 0)),
        GREEN_DRAGON("Green dragon", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Dragonfire shield", "Anti-dragon shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        HARPIE_BUG_SWARM("Harpie Bug Swarm", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Bug lantern"}, org.rsbot.script.methods.Equipment.SHIELD))),
        HELLHOUND("Hellhound", new Location(new RSTile(0, 0), 0)),
        HILL_GIANT("Hill giant", new Location(new RSTile(0, 0), 0)),
        ICEFIEND("Icefiend", new Location(new RSTile(0, 0), 0)),
        ICE_GIANT("Ice giant", new Location(new RSTile(0, 0), 0)),
        ICE_WARRIOR("Ice warrior", new Location(new RSTile(0, 0), 0)),
        INFERNAL_MAGE("Infernal mage", new Location(new RSTile(0, 0), 0)),
        IRON_DRAGON("Iron dragon", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Dragonfire shield", "Anti-dragon shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        JELLY("Jelly", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Antipoison (1)", "Antipoison (2)", "Antipoison (3)", "Antipoison (4)"}))),
        JUNGLE_HORROR("Jungle horror", new Location(new RSTile(0, 0), 0)),
        KALPHITES("Kalphite worker", new Location(new RSTile(0, 0), 0)),
        KILLERWATT("Killerwatt", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Insulated boots"}, org.rsbot.script.methods.Equipment.FEET))),
        KURASK("Kurask", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Leaf-bladed sword", "Leaf-bladed spear"}, org.rsbot.script.methods.Equipment.WEAPON))),
        LESSER_DEMON("Lesser demon", new Location(new RSTile(0, 0), 0)),
        MITHRIL_DRAGON("Mithril dragon", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Dragonfire shield", "Anti-dragon shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        MINOTAUR("Minotaur", new Location(new RSTile(0, 0), 0)),
        MOGRE("Mogre", new Location(new RSTile(0, 0), 0)),
        //Need to complete a 'mini quest'
        MOLANISK("Molanisk", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Slayer bell"}), new Starter(new String[]{"Slayer bell"}))),
        MONKEY("Monkey", new Location(new RSTile(0, 0), 0), new Requirements(new CombatStyle(Style.RANGE))),
        MOSS_GIANT("Moss giant", new Location(new RSTile(0, 0), 0)),
        MUTATED_ZYGOMITE("Mutated zygomite", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Fungicide spray"}), new Finisher(new String[]{"Fungicide spray"}))),
        NECHRYAEL("Nechryael", new Location(new RSTile(0, 0), 0)),
        //Needs nosepeg for walking past spectres...
        OGRE("Ogre", new Location(new RSTile(0, 0), 0)),
        OTHERWORLDLY_BEINGS("Otherworldly beings", new Location(new RSTile(0, 0), 0)),
        PYREFIEND("Pyrefiend", new Location(new RSTile(0, 0), 0)),
        ROCK_SLUG("Rock slug", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Bag of salt"}), new Finisher(new String[]{"Bag of salt"}))),
        SCABARITES(" ", new Location(new RSTile(0, 0), 0)),
        //Need more infomation...
        SCORPION("Scorpion", new Location(new RSTile(0, 0), 0)),
        SEA_SNAKE("Sea snake hatchlings", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Antipoison (1)", "Antipoison (2)", "Antipoison (3)", "Antipoison (4)"}))),
        SHADE("Shade", new Location(new RSTile(0, 0), 0)),
        SHADOW_WARRIOR("Shadow warrior", new Location(new RSTile(0, 0), 0)),
        SKELETAL_WYVERN("Skeletal wyvern", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Dragonfire shield", "Mind shield", "Elemental shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        SKELETON("Skeleton", new Location(new RSTile(0, 0), 0)),
        SPIDER("Spider", new Location(new RSTile(0, 0), 0)),
        SPIRITUAL_MAGES("Spiritual mage", new Location(new RSTile(0, 0), 0)),
        SPIRITUAL_RANGER("Spiritual ranger", new Location(new RSTile(0, 0), 0)),
        SPIRITUAL_WARRIOR("Spiritual warrior", new Location(new RSTile(0, 0), 0)),
        STEEL_DRAGON("Steel dragon", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Dragonfire shield", "Anti-dragon shield"}, org.rsbot.script.methods.Equipment.SHIELD))),
        SUPAH("Suquh", new Location(new RSTile(0, 0), 0)),
        TROLL("Troll", new Location(new RSTile(0, 0), 0)),
        TUROTH("Turoth", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Leaf-bladed sword", "Leaf-bladed spear"}, org.rsbot.script.methods.Equipment.WEAPON))),
        VAMPIRE("Vampire", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Blessed holy symbol"}, org.rsbot.script.methods.Equipment.NECK))),
        WALL_BEAST("Wall beast", new Location(new RSTile(0, 0), 0), new Requirements(new Equipment(new String[]{"Slayer helmet", "Spiny helmet"}, org.rsbot.script.methods.Equipment.HELMET))),
        WARPED_TERRORBIRD("Warped terrorbird", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Crystal chime"}))),
        WARPED_TORTOISE("Warped tortoise", new Location(new RSTile(0, 0), 0), new Requirements(new Item(new String[]{"Crystal chime"}))),
        WATERFIEND("Waterfiend", new Location(new RSTile(0, 0), 0)),
        WEREWOLF(new String[]{"Werewolf", "Lev", "Svetlana", "Eduard", "Irina", "Boris"}, new Location(new RSTile(0, 0), 0)),
        WOLF(new String[]{"White wolf", "Big wolf", "Wolf"}, new Location(new RSTile(0, 0), 0)),
        ZOMBIE("Zombie", new Location(new RSTile(0, 0), 0)),
        UNKNOWN("", null);
        private String[] names;
        private Location location;
        private Requirements Requirements;

        Monsters(String[] names, Location location, Requirements Requirements) {
            this.names = names;
            this.location = location;
            this.Requirements = Requirements;
        }

        Monsters(String[] names, Location location) {
            this(names, location, null);
        }

        Monsters(String name, Location location) {
            this(new String[]{name}, location, null);
        }

        Monsters(String name, Location location, Requirements Requirements) {
            this(new String[]{name}, location, Requirements);
        }

        private Location getLocation() {
            return this.location;
        }

        private String[] getNames() {
            return this.names;
        }
    }

    private static class Requirements {
        List<Item> items = new ArrayList<Item>();
        Finisher finisher;
        Starter starter;
        List<Equipment> equipments = new ArrayList<Equipment>();
        CombatStyle style = null;

        private Requirements(Item[] itemArray, Finisher finisher, Starter starter, Equipment[] equipmentArray, CombatStyle style) {
            this.items.addAll(Arrays.asList(itemArray));
            this.finisher = finisher;
            this.starter = starter;
            this.equipments.addAll(Arrays.asList(equipmentArray));
            this.style = style;
        }

        private Requirements(Item[] itemArray, Finisher finisher, Starter starter, Equipment[] equipmentArray) {
            this(itemArray, finisher, starter, equipmentArray, null);
        }

        private Requirements(Item[] itemArray, Finisher finisher, Starter starter) {
            this(itemArray, finisher, starter, null, null);
        }

        private Requirements(Item[] itemArray, Finisher finisher) {
            this(itemArray, finisher, null, null, null);
        }

        private Requirements(Item item, Finisher finisher) {
            this(new Item[]{item}, finisher, null, null, null);
        }

        private Requirements(Item[] itemArray, Starter starter) {
            this(itemArray, null, starter, null, null);
        }

        private Requirements(Item item, Starter starter) {
            this(new Item[]{item}, null, starter, null, null);
        }

        private Requirements(CombatStyle style) {
            this(null, null, null, null, style);
        }

        private Requirements(Equipment[] equipmentArray, CombatStyle style) {
            this(null, null, null, equipmentArray, style);
        }

        private Requirements(Equipment[] equipmentArray) {
            this(null, null, null, equipmentArray, null);
        }

        private Requirements(Equipment equipment) {
            this(null, null, null, new Equipment[]{equipment}, null);
        }

        private Requirements(Item[] itemArray) {
            this(itemArray, null, null, null, null);
        }

        private Requirements(Item item) {
            this(new Item[]{item}, null, null, null, null);
        }

        Item[] getItems() {
            Item[] itemArray = null;
            this.items.toArray(itemArray);
            return itemArray;
        }

        Finisher getFinisher() {
            return this.finisher;
        }

        Starter getStarter() {
            return this.starter;
        }

        Equipment[] getEquipment() {
            Equipment[] equipmentArray = null;
            this.equipments.toArray(equipmentArray);
            return equipmentArray;
        }

        CombatStyle getCombatStyle() {
            return this.style;
        }
    }

    private static class Item {
        private String[] names;
        private int amount;
        private int type;

        public final static int NOT_EQUIPED = 1;
        public final static int COULD_BE_EQUIPED = 2;
        public final static int NEEDS_TO_BE_EQUIPED = 3;

        private Item(int type, String[] names, int amount) {
            this.names = names;
            this.amount = amount;
            this.type = type;
        }

        private Item(String[] names) {
            this(1, names, 1);
        }

        private Item(String name) {
            this(1, new String[]{name}, 1);
        }

        private Item(int type, String name) {
            this(type, new String[]{name}, 1);
        }

        private Item(String name, int amount) {
            this(1, new String[]{name}, amount);
        }

        private int getAmount() {
            return this.amount;
        }

        private int getType() {
            return this.type;
        }

        private String[] getNames() {
            return this.names;
        }
    }

    private static class Finisher {
        private String[] names;
        private int amount;

        private Finisher(String[] names, int amount) {
            this.names = names;
            this.amount = amount;
        }

        private Finisher(String[] names) {
            this(names, 1);
        }

        private Finisher(String name) {
            this(new String[]{name}, 1);
        }

        private Finisher(String name, int amount) {
            this(new String[]{name}, amount);
        }

        private Finisher(String[] names, boolean full) {
            this(names, (full ? 28 : 1));
        }

        private Finisher(String name, boolean full) {
            this(new String[]{name}, (full ? 28 : 1));
        }

        private int getAmount() {
            return this.amount;
        }

        private String[] getNames() {
            return this.names;
        }
    }

    private static class Starter {
        private String[] names;
        private int amount;

        private Starter(String[] names, int amount) {
            this.names = names;
            this.amount = amount;
        }

        private Starter(String[] names) {
            this(names, 1);
        }

        private Starter(String name) {
            this(new String[]{name}, 1);
        }

        private Starter(String name, int amount) {
            this(new String[]{name}, amount);
        }

        private Starter(String[] names, boolean full) {
            this(names, (full ? 28 : 1));
        }

        private Starter(String name, boolean full) {
            this(new String[]{name}, (full ? 28 : 1));
        }

        private int getAmount() {
            return this.amount;
        }

        private String[] getNames() {
            return this.names;
        }
    }

    private static class Equipment {
        private String[] names;
        private int slot;

        private Equipment(String[] names, int slot) {
            this.names = names;
            this.slot = slot;
        }

        private Equipment(String name, int slot) {
            this(new String[]{name}, slot);
        }

        private String[] getNames() {
            return this.names;
        }

        private int getSlot() {
            return this.slot;
        }
    }

    private static class CombatStyle {
        Style style;

        private CombatStyle(Style style) {
            this.style = style;
        }
    }

    private static enum Style {
        MELEE,
        MAGIC,
        RANGE;
    }

    private static class Location {
        private RSTile tile;
        private int plane;

        private Location(RSTile tile, int plane) {
            this.tile = tile;
            this.plane = plane;
        }

        private RSTile getTile() {
            return this.tile;
        }

        private int getPlane() {
            return this.plane;
        }
    }

    private class Task {
        private Monsters monster;

        private Task(Monsters monster) {
            this.monster = monster;
        }

        private Requirements getRequirements() {
            return this.monster.Requirements;
        }

        private Monsters getMonster() {
            return this.monster;
        }

        private void setMonster(Monsters monster) {
            this.monster = monster;
        }
    }

    private int getKillsLeft() {
        return settings.getSetting(394);
    }

    private int inventSpace() {
        return (28 - inventory.getCount());
    }

    private int specialUsage() {
        int[] amountUsage = {10, 25, 33, 35, 45, 50, 55, 60, 80, 85, 100};
        String[][] weapons = {{"Rune thrownaxe", "Rod of ivandis"},
                {"Dragon Dagger", "Dragon dagger (p)", "Dragon dagger (p+)", "Dragon dagger (p++)", "Dragon Mace", "Dragon Spear", "Dragon longsword", "Rune claws"},
                {"Dragon Halberd"}, {"Magic Longbow"}, {"Magic Composite Bow"},
                {"Dragon Claws", "Abyssal Whip", "Granite Maul", "Darklight", "Barrelchest Anchor", "Armadyl Godsword"},
                {"Magic Shortbow"}, {"Dragon Scimitar", "Dragon 2H Sword", "Zamorak Godsword", "Korasi's sword"},
                {"Dorgeshuun Crossbow", "Bone Dagger", "Bone Dagger (p+)", "Bone Dagger (p++)"},
                {"Brine Sabre"}, {"Bandos Godsword", "Dragon Battleaxe", "Dragon Hatchet", "Seercull Bow", "Excalibur", "Enhanced excalibur", "Ancient Mace", "Saradomin sword"}};
        String str = equipment.getItem(org.rsbot.script.methods.Equipment.WEAPON).getName();
        str = str.substring(str.indexOf(">") + 1);
        for (int i = 0; i < weapons.length; i++) {
            for (int j = 0; j < weapons[i].length; j++) {
                if (weapons[i][j].equalsIgnoreCase(str)) {
                    return amountUsage[i];
                }
            }
        }
        return -1;
    }

	private boolean performAction(Item items, String action) {
		for(RSItem item: inventory.getItems()) {
			for(String name: items.getNames()) {
				if(item.getName().equalsIgnoreCase(name)) {
					return item.doAction(action);
				}
			}
		}
		return false;
	}

    private boolean isInInvent(Item items) {
        for (RSItem item : inventory.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    if(inventory.getCount(true, item.getID()) >= items.amount)     // Make sure you not only have the item, but also enough of the item
                        return true;
                }
            }
        }
        return false;
    }

    private boolean isInBank(Item items) {
        for (RSItem item : bank.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEquiped(Item item) {
        for (RSItem i : equipment.getItems()) {
            for (String name : item.getNames()) {
                if (i.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInInvent(Equipment equip) {
        for (RSItem item : inventory.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEquiped(Equipment equip) {
        for (RSItem item : equipment.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInBank(Equipment equip) {
        for (RSItem item : bank.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String willRemove(Equipment equip) {
        return equipment.getItem(equip.slot).getName();
    }

    private void equip(Equipment equip) {
        for (RSItem item : inventory.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    item.doClick(true);
                    return;
                }
            }
        }
    }

    private boolean isFullyEquiped(Requirements req) {
        for (Equipment e : req.getEquipment()) {
            if (!isEquiped(e)) {
                if (isInInvent(e)) {
                    for (Equipment r : req.getEquipment()) {
                        for (String name : r.getNames()) {
                            if (willRemove(e).equals(name)) {
                                return false;
                            }
                        }
                    }
                    equip(e);
                    if (!isEquiped(e)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean inventReady(Requirements req) {
        for (Item i : req.getItems()) {
            if (!isInInvent(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInInvent(Finisher fin) {
        for (RSItem item : inventory.getItems()) {
            for (String name : fin.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInBank(Finisher fin) {
        for (RSItem item : bank.getItems()) {
            for (String name : fin.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInInvent(Starter start) {
        for (RSItem item : inventory.getItems()) {
            for (String name : start.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInBank(Starter start) {
        for (RSItem item : bank.getItems()) {
            for (String name : start.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean use(Starter start, RSNPC monster) {
        for (String s : start.getNames()) {
            for (RSItem inventItem : inventory.getItems()) {
                if (s.equalsIgnoreCase(inventItem.getName())) {
                    if (inventory.selectItem(inventItem.getID())) {
                        if (monster != null) {
                            if (!monster.isOnScreen()) {
                                camera.turnTo(monster);
                            }
                            if (monster.isOnScreen()) {
                                return monster.doAction("Use");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean use(Finisher finisher, RSNPC monster) {
        for (String s : finisher.getNames()) {
            for (RSItem inventItem : inventory.getItems()) {
                if (s.equalsIgnoreCase(inventItem.getName())) {
                    if (inventory.selectItem(inventItem.getID())) {
                        if (monster != null) {
                            if (!monster.isOnScreen()) {
                                camera.turnTo(monster);
                            }
                            if (monster.isOnScreen()) {
                                return monster.doAction("Use");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // A mix of teleporting and walking/running to travel
    // to certain slayer masters, tasks, and banks
    private class Travel {

        private boolean travelToMaster(SlayerMaster master) {
            Teleport t = getBestTeleport(master.getLocation());
            if(t != null)
                return castTeleport(t);
            else
                return walking.getWebPath(master.getLocation()).traverse();
        }

        private boolean travelToMonster(Task task) {
            Teleport t = getBestTeleport(task.monster.getLocation().getTile());
            if(t != null)
                return castTeleport(t);
            else
                return walking.getWebPath(task.monster.getLocation().getTile()).traverse();
        }

        // The default will be the closest bank to the player
        private boolean travelToBank() {
            return travelToBank(getNearestBank());
        }

        private boolean travelToBank(Bank bank) {
            Teleport t = getBestTeleport(bank.getRSArea().getCentralTile());
            if(t != null)
                return castTeleport(t);
            else
                return walking.getWebPath(bank.getRSArea().getCentralTile()).traverse();
        }

        private boolean castTeleport(Teleport t) {
            if(t.getType().isSpell()) {
	            return magic.castSpell(t.getType().getSpell());
            } else {
	            return performAction(t.getItems()[0], t.getType().getAction());  // always perform the action on the first item on the list (it should only be one item anyway)
            }
        }

        // returns null if there are no teleports that are closer
        private Teleport getBestTeleport(RSTile dest) {
            Teleport best = null;
            double dist = 0;
            for(Teleport t : Teleport.values()) {
                if(canCast(t)) {
                    if(best == null || calc.distanceBetween(t.getLocation().getTile(), dest) < dist) {
                        best = t;
                        dist = calc.distanceBetween(t.getLocation().getTile(), dest);
                    }
                }
            }
            if(calc.distanceTo(dest) > dist) // player is farthur away than the best teleport
                return best;
            return null;
        }

        // Makes sure the player has the required Magic level, and then
        // checks to make sure all of the required items are available
        private boolean canCast(Teleport t) {
            if(skills.getRealLevel(Skills.MAGIC) < t.magicLevel)
                return false;
            for(Item i : t.getItems()) {
                switch(i.getType()) {
                    case Item.NOT_EQUIPED:
                        if(!isInInvent(i))
                            return false;
                        break;
                    case Item.COULD_BE_EQUIPED:
                        if(!isInInvent(i) && !isEquiped(i))
                            return false;
                        break;
                    case Item.NEEDS_TO_BE_EQUIPED:
                        if(!isEquiped(i))
                            return false;
                        break;
                    default: return false; // Item doesn't have a type: error!
                }
            }
            return true;
        }
    }

    private static enum Bank {
        VARROCK_EAST(new RSArea(new RSTile(3258, 3424), new RSTile(3249, 3415)), 0),
        VARROCK_WEST(new RSArea(new RSTile(3195, 3447), new RSTile(3178, 3431)), 0),
        SEERS(new RSArea(new RSTile(2731, 3495), new RSTile(2719, 3487)), 0),
        EAST_FALADOR(new RSArea(new RSTile(3022, 3359), new RSTile(3007, 3351)), 0),
        WEST_FALADOR(new RSArea(new RSTile(2949, 3374), new RSTile(2941, 3365)), 0),
        DRAYNOR(new RSArea(new RSTile(3098, 3247), new RSTile(3087, 3238)), 0),
        NORTH_ARDOUGNE(new RSArea(new RSTile(2622, 3337), new RSTile(2611, 3328)), 0),
        SOUTH_ARDOUGNE(new RSArea(new RSTile(2660, 3288), new RSTile(2648, 3279)), 0),
        YANNILLE(new RSArea(new RSTile(2617, 3098), new RSTile(2607, 3087)), 0),
        EDGEVILLE(new RSArea(new RSTile(3099, 3500), new RSTile(3089, 3487)), 0),
        AL_KHARID(new RSArea(new RSTile(3273, 3174), new RSTile(3263, 3160)), 0),
        GRAND_EXCHANGE(new RSArea(new RSTile(3171, 3494), new RSTile(3159, 3485)), 0);
        //TODO add a lot more banks.

        private RSArea area;
        private int plane;

        private Bank(RSArea area, int plane) {
            this.area = area;
            this.plane = plane;
        }

        private RSArea getRSArea() {
            return this.area;
        }

        private boolean containsTile(RSTile tile) {
            return this.area.contains(tile);
        }
    }

    private enum TeleportType {
        HOME_SPELL(Magic.SPELL_HOME_TELEPORT),
        VARROCK_SPELL(Magic.SPELL_VARROCK_TELEPORT),
        LUMBRIDGE_SPELL(Magic.SPELL_LUMBRIDGE_TELEPORT),
        FALADOR_SPELL(Magic.SPELL_FALADOR_TELEPORT),
        ARDOUGNE_SPELL(Magic.SPELL_ARDOUGNE_TELEPORT),
        TAB("Break"),
        OTHER();

        private boolean isSpell;
        private int magicSpell;
        private String action;

        // default to the home teleport spell (realistically should never be used though)
        private TeleportType() {
            this(true, Magic.SPELL_HOME_TELEPORT, "");
        }

        private TeleportType(int spell) {
            this(true, spell, "");
        }

        private TeleportType(String action) {
            this(false, 0, "");
        }

        private TeleportType(boolean isSpell, int spell, String action) {
            this.isSpell = isSpell;
            this.magicSpell = spell;
            this.action = action;
        }

        private boolean isSpell() {
            return isSpell;
        }

        private int getSpell() {
            return magicSpell;
        }

        private String getAction() {
            return action;
        }
    }

    private enum Teleport {
        LUMBRIDGE(TeleportType.HOME_SPELL, new Location(new RSTile(0, 0), 0)),
        VARROCK_SPELL_1(TeleportType.VARROCK_SPELL, new Location(new RSTile(0, 0), 0), new Item[]{new Item( Item.NEEDS_TO_BE_EQUIPED, "Fire staff"), new Item("Law rune"), new Item("Air runes", 3)}, 25), // Sadly i think this is the only i can think of to 'cleanly' include staffs
        VARROCK_SPELL_2(TeleportType.VARROCK_SPELL, new Location(new RSTile(0, 0), 0), new Item[]{new Item( Item.NEEDS_TO_BE_EQUIPED, "Lava staff"), new Item("Law rune"), new Item("Air runes", 3)}, 25), // If anyone has any other ways fix this.
        VARROCK_SPELL_3(TeleportType.VARROCK_SPELL, new Location(new RSTile(0, 0), 0), new Item[]{new Item( Item.NEEDS_TO_BE_EQUIPED, "Fire rune"), new Item("Law rune"), new Item("Air staff")}, 25),
        VARROCK_TAB(TeleportType.TAB, new Location(new RSTile(0, 0), 0), new Item[]{new Item("Varrock teleport")}), // This has the value of CANT_EQUIP so you would only check inventory
        // Need to figure out how to handle ROD and other teleport options that change depending on whether they are equipped
        // or in the inventory. ROD is disabled for now (will teleport to lumbridge using home teleport)
        ROD_DUEL_AREA(TeleportType.OTHER, new Location(new RSTile(0, 0), 0), new Item(Item.COULD_BE_EQUIPED, "Ring of dueling")); //For this you would check both inventory and equipment.
        private Item[] items;
        private Location loc;
        private int magicLevel;
        private TeleportType type;

        private Teleport(TeleportType type, Location loc, Item[] items, int magicLevel) {
            this.type = type;
            this.loc = loc;
            this.items = items;
            this.magicLevel = magicLevel;
        }

        private Teleport(TeleportType type, Location loc, Item[] items) {
            this(type, loc, items, 1);
        }

        private Teleport(TeleportType type, Location loc, Item item, int magicLevel) {
            this(type, loc, new Item[]{item}, magicLevel);
        }

        private Teleport(TeleportType type, Location loc, Item item) {
            this(type, loc, new Item[]{item}, 1);
        }

        private Teleport(TeleportType type, Location loc) {
            this(type, loc, (Item) null, 1);
        }

        private Location getLocation() {
            return this.loc;
        }

        private Item[] getItems() {
            return this.items;
        }

        private TeleportType getType() {
            return type;
        }
    }

    private Bank getNearestBank() {
        /*
         *TODO Add a method to remove all banks that a player can not reach.
         *     Use the walking class to return a 'real' distance.
         */
        int[] distance = new int[Bank.values().length];
        int i = 0;
        for (Bank b : Bank.values()) {
            distance[i] = calc.distanceTo(b.getRSArea().getCentralTile());
            i++;
        }
        int min = min(distance);
        if (min == -1) {
            return null;
        }
        return Bank.values()[getArrayIndex(distance, min)];
    }

    public int getArrayIndex(int[] array, int num) {
        for (int i : array) {
            if (i == num) {
                return (i);
            }
        }
        return -1; //Find a suitable alternative
    }

    private int min(int[] a) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            res = Math.min(a[i], res);
        }
        return res;
    }

    @Override
    public int loop() {
        return 0;
    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch (IOException e) {
            return null;
        }
    }

    private enum Skill {
        SLAYER(Skills.SLAYER, "Slayer", 0),
        ATTACK(Skills.ATTACK, "Attack", 1),
        STRENGTH(Skills.STRENGTH, "Strength", 2),
        DEFENCE(Skills.DEFENSE, "Defence", 3),
        CONSTITUTION(Skills.CONSTITUTION, "Constitution", 4),
        RANGE(Skills.RANGE, "Range", 5),
        MAGIC(Skills.MAGIC, "Magic", 6);

        int skillID;
        String skillName;
        int index;

        private Skill(int skillID, String skillName, int index) {
            this.skillID = skillID;
            this.skillName = skillName;
            this.index = index;
        }
    }

    private final Image closed = getImage("http://img88.imageshack.us/img88/4408/closedc.png");
    private final Image tabOne = getImage("http://img18.imageshack.us/img18/2836/gentab.png");
    private final Image tabTwo = getImage("http://img6.imageshack.us/img6/5461/exptab.png");
    private final Rectangle hideRect = new Rectangle(477, 336, 34, 37);
    private final Rectangle tabOneRect = new Rectangle(177, 335, 147, 37);
    private final Rectangle tabTwoRect = new Rectangle(327, 336, 148, 37);

    public void onRepaint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        if (tab == 1) {
            g.drawImage(tabOne, -1, 293, null);
        } else if (tab == 2) {
            g.drawImage(tabTwo, -1, 293, null);
            drawSkillBars(g);
        } else {
            g.drawImage(closed, 162, 293, null);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (hideRect.contains(e.getPoint())) {
            tab = 3;
        } else if (tabOneRect.contains(e.getPoint())) {
            tab = 1;
        } else if (tabTwoRect.contains(e.getPoint())) {
            tab = 2;
        }
    }


    private void drawSkillBars(Graphics g) {
        for (Skill s : Skill.values()) {
            int x = s.index <= 3 ? 20 : 180;
            int y = s.index <= 3 ? 390 + (s.index * 20) : 390 + ((s.index - 3) * 20);
            g.setColor(new Color(153, 153, 153));
            g.drawRect(x, y, 150, 15);
            g.setColor(new Color(0, 0, 0, 80));
            g.fillRect(x, y, (int) (skills.getPercentToNextLevel(s.skillID) * 1.5), 15);
            g.setColor(new Color(90, 15, 15));
            g.setFont(new Font("Serif", 0, 12));
            g.drawString(s.skillName + ": " + skills.getPercentToNextLevel(s.skillID)
                    + "% to level " + (skills.getRealLevel(s.skillID) + 1), x + 4, y + 12);
            g.setColor(new Color(255, 255, 255, 90));
            g.drawString(s.skillName + ": " + skills.getPercentToNextLevel(s.skillID)
                    + "% to level " + (skills.getRealLevel(s.skillID) + 1), x + 5, y + 13);
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
