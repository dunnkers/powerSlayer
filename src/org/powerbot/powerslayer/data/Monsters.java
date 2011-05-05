package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.wrappers.*;
import org.rsbot.script.methods.Equipment;
import org.rsbot.script.wrappers.RSTile;

public enum Monsters
{
    // TODO Add locations
    ABBERANT_SPECTRE("Aberrant Spectre",
                     new RSTile(0, 0, 0),
                     new Requirements(new EquipmentItems(new String[]{"Slayer helmet", "Nosepeg"}, Equipment.HELMET))),
    ABYSSAL_DEMON("Abyssal Demon", new RSTile(0, 0, 0)),
    AQUANITE("Aquanite", new RSTile(0, 0, 0)),
    ANKOU("Ankou", new RSTile(0, 0, 0)),
    BANSHEE("Banshee",
            new RSTile(0, 0, 0),
            new Requirements(new EquipmentItems(new String[]{"Earmuffs", "Masked earmuffs", "Slayer helmet"},
                                                Equipment.HELMET))),
    BASILISK("Basilisk",
             new RSTile(0, 0, 0),
             new Requirements(new EquipmentItems(new String[]{"Mirror shield"}, Equipment.SHIELD))),
    BAT("Bat", new RSTile(0, 0, 0)),
    BEAR("Black bear", new RSTile(0, 0, 0)),
    BIRD("Chicken", new RSTile(0, 0, 0)),
    BLACK_DEMON("Black demon", new RSTile(0, 0, 0)),
    BLACK_DRAGON("Black dragon",
                 new RSTile(0, 0, 0),
                 new Requirements(new EquipmentItems(new String[]{"Dragonfire shield", "Anti-dragon shield"},
                                                     Equipment.SHIELD))),
    BLOODVELD("Bloodveld", new RSTile(0, 0, 0)),
    BLUE_DRAGON("Blue dragon",
                new RSTile(0, 0, 0),
                new Requirements(new EquipmentItems(new String[]{"Dragonfire shield", "Anti-dragon shield"},
                                                    Equipment.SHIELD))),
    BRINE_RAT("Brine rat", new RSTile(0, 0, 0)),
    BRONZE_DRAGON("Bronze dragon",
                  new RSTile(0, 0, 0),
                  new Requirements(new EquipmentItems(new String[]{"Dragonfire shield", "Anti-dragon shield"},
                                                      Equipment.SHIELD))),
    CATABLEPON("Catablepon", new RSTile(0, 0, 0)),
    CAVE_BUG("Cave bug", new RSTile(0, 0, 0)),
    CAVE_CRAWLER("Cave crawler",
                 new RSTile(0, 0, 0),
                 new Requirements(new Item(new String[]{"Antipoison (1)",
                                                        "Antipoison (2)",
                                                        "Antipoison (3)",
                                                        "Antipoison (4)"}))),
    CAVE_HORROR("Cave horror",
                new RSTile(0, 0, 0),
                new Requirements(new EquipmentItems(new String[]{"Witchwood icon"}, Equipment.NECK))),
    CAVE_SLIME("Cave slime",
               new RSTile(0, 0, 0),
               new Requirements(new Item(new String[]{"Antipoison (1)",
                                                      "Antipoison (2)",
                                                      "Antipoison (3)",
                                                      "Antipoison (4)"}))),
    COCKATRICE("Cockatrice",
               new RSTile(0, 0, 0),
               new Requirements(new EquipmentItems(new String[]{"Mirror sheild"}, Equipment.SHIELD))),
    COW("Cow", new RSTile(0, 0, 0)),
    CROCODILE("Crocodile",
              new RSTile(0, 0, 0),
              new Requirements(new Item[]{new Item(new String[]{"Waterskin (1)",
                                                                "Waterskin (2)",
                                                                "Waterskin (3)",
                                                                "Waterskin (4)"}),
                                          new Item(new String[]{"Ice coolers"})},
                               new Finisher(new String[]{"Rock hammer"}))),
    DRAGANNOTH("Dragannoth", new RSTile(0, 0, 0)),
    DARK_BEAST("Dark beast", new RSTile(0, 0, 0)),
    // TODO Moruner Armour...
    DESERT_LIZARD("Desert lizard",
                  new RSTile(0, 0, 0),
                  new Requirements(new Item(new String[]{"Waterskin (1)",
                                                         "Waterskin (2)",
                                                         "Waterskin (3)",
                                                         "Waterskin (4)"}))),
    DOG("Guard dog", new RSTile(0, 0, 0)),
    DUST_DEVIL("Dust devil",
               new RSTile(0, 0, 0),
               new Requirements(new EquipmentItems(new String[]{"Slayer helmet", "Facemask"}, Equipment.HELMET))),
    DWARF("Dwarf", new RSTile(0, 0, 0)),
    EARTH_WARRIOR("Earth warrior", new RSTile(0, 0, 0)),
    ELF("Elf warrior", new RSTile(0, 0, 0)),
    FEVER_SPIDER("Fever spider",
                 new RSTile(0, 0, 0),
                 new Requirements(new EquipmentItems(new String[]{"Slayer gloves"}, Equipment.HANDS))),
    FIRE_GIANTS("Fire giants", new RSTile(0, 0, 0)),
    FLESH_CRAWLERS("Flesh crawlers", new RSTile(0, 0, 0)),
    GARGOYLE("Gargoyle",
             new RSTile(0, 0, 0),
             new Requirements(new Item(new String[]{"Rock hammer"}), new Finisher(new String[]{"Rock hammer"}))),
    GHOST("Ghost", new RSTile(0, 0, 0)),
    GHOUL("Ghoul", new RSTile(0, 0, 0)),
    GIANT_SPIDER("Giant spider", new RSTile(0, 0, 0)),
    GOBLIN("Goblin", new RSTile(0, 0, 0)),
    GORAK("Gorak", new RSTile(0, 0, 0)),
    GREATER_DEMON("Greater demon", new RSTile(0, 0, 0)),
    GREEN_DRAGON("Green dragon",
                 new RSTile(0, 0, 0),
                 new Requirements(new EquipmentItems(new String[]{"Dragonfire shield", "Anti-dragon shield"},
                                                     Equipment.SHIELD))),
    HARPIE_BUG_SWARM("Harpie Bug Swarm",
                     new RSTile(0, 0, 0),
                     new Requirements(new EquipmentItems(new String[]{"Bug lantern"}, Equipment.SHIELD))),
    HELLHOUND("Hellhound", new RSTile(0, 0, 0)),
    HILL_GIANT("Hill giant", new RSTile(0, 0, 0)),
    ICEFIEND("Icefiend", new RSTile(0, 0, 0)),
    ICE_GIANT("Ice giant", new RSTile(0, 0, 0)),
    ICE_WARRIOR("Ice warrior", new RSTile(0, 0, 0)),
    INFERNAL_MAGE("Infernal mage", new RSTile(0, 0, 0)),
    IRON_DRAGON("Iron dragon",
                new RSTile(0, 0, 0),
                new Requirements(new EquipmentItems(new String[]{"Dragonfire shield", "Anti-dragon shield"},
                                                    Equipment.SHIELD))),
    JELLY("Jelly",
          new RSTile(0, 0, 0),
          new Requirements(new Item(new String[]{"Antipoison (1)",
                                                 "Antipoison (2)",
                                                 "Antipoison (3)",
                                                 "Antipoison (4)"}))),
    JUNGLE_HORROR("Jungle horror", new RSTile(0, 0, 0)),
    KALPHITES("Kalphite worker", new RSTile(0, 0, 0)),
    KILLERWATT("Killerwatt",
               new RSTile(0, 0, 0),
               new Requirements(new EquipmentItems(new String[]{"Insulated boots"}, Equipment.FEET))),
    KURASK("Kurask",
           new RSTile(0, 0, 0),
           new Requirements(new EquipmentItems(new String[]{"Leaf-bladed sword", "Leaf-bladed spear"},
                                               Equipment.WEAPON))),
    LESSER_DEMON("Lesser demon", new RSTile(0, 0, 0)),
    MITHRIL_DRAGON("Mithril dragon",
                   new RSTile(0, 0, 0),
                   new Requirements(new EquipmentItems(new String[]{"Dragonfire shield", "Anti-dragon shield"},
                                                       Equipment.SHIELD))),
    MINOTAUR("Minotaur", new RSTile(0, 0, 0)),
    MOGRE("Mogre", new RSTile(0, 0, 0)),
    // TODO get requirments
    MOLANISK("Molanisk",
             new RSTile(0, 0, 0),
             new Requirements(new Item(new String[]{"Slayer bell"}), new Starter(new String[]{"Slayer bell"}))),
    MONKEY("Monkey", new RSTile(0, 0, 0), new Requirements(new CombatStyle(CombatStyle.Style.RANGE))),
    MOSS_GIANT("Moss giant", new RSTile(0, 0, 0)),
    MUTATED_ZYGOMITE("Mutated zygomite",
                     new RSTile(0, 0, 0),
                     new Requirements(new Item(new String[]{"Fungicide spray"}),
                                      new Finisher(new String[]{"Fungicide spray"}))),
    NECHRYAEL("Nechryael", new RSTile(0, 0, 0)),
    // TODO Needs nosepeg for walking past spectres...
    OGRE("Ogre", new RSTile(0, 0, 0)),
    OTHERWORLDLY_BEINGS("Otherworldly beings", new RSTile(0, 0, 0)),
    PYREFIEND("Pyrefiend", new RSTile(0, 0, 0)),
    ROCK_SLUG("Rock slug",
              new RSTile(0, 0, 0),
              new Requirements(new Item(new String[]{"Bag of salt"}), new Finisher(new String[]{"Bag of salt"}))),
    SCABARITES(" ", new RSTile(0, 0, 0)),
    // TODO find the best scabarites
    SCORPION("Scorpion", new RSTile(0, 0, 0)),
    SEA_SNAKE("Sea snake hatchlings",
              new RSTile(0, 0, 0),
              new Requirements(new Item(new String[]{"Antipoison (1)",
                                                     "Antipoison (2)",
                                                     "Antipoison (3)",
                                                     "Antipoison (4)"}))),
    SHADE("Shade", new RSTile(0, 0, 0)),
    SHADOW_WARRIOR("Shadow warrior", new RSTile(0, 0, 0)),
    SKELETAL_WYVERN("Skeletal wyvern",
                    new RSTile(0, 0, 0),
                    new Requirements(new EquipmentItems(new String[]{"Dragonfire shield",
                                                                     "Mind shield",
                                                                     "Elemental shield"}, Equipment.SHIELD))),
    SKELETON("Skeleton", new RSTile(0, 0, 0)),
    SPIDER("Spider", new RSTile(0, 0, 0)),
    SPIRITUAL_MAGES("Spiritual mage", new RSTile(0, 0, 0)),
    SPIRITUAL_RANGER("Spiritual ranger", new RSTile(0, 0, 0)),
    SPIRITUAL_WARRIOR("Spiritual warrior", new RSTile(0, 0, 0)),
    STEEL_DRAGON("Steel dragon",
                 new RSTile(0, 0, 0),
                 new Requirements(new EquipmentItems(new String[]{"Dragonfire shield", "Anti-dragon shield"},
                                                     Equipment.SHIELD))),
    SUPAH("Suquh", new RSTile(0, 0, 0)),
    TROLL("Troll", new RSTile(0, 0, 0)),
    TUROTH("Turoth",
           new RSTile(0, 0, 0),
           new Requirements(new EquipmentItems(new String[]{"Leaf-bladed sword", "Leaf-bladed spear"},
                                               Equipment.WEAPON))),
    VAMPIRE("Vampire",
            new RSTile(0, 0, 0),
            new Requirements(new EquipmentItems(new String[]{"Blessed holy symbol"}, Equipment.NECK))),
    WALL_BEAST("Wall beast",
               new RSTile(0, 0, 0),
               new Requirements(new EquipmentItems(new String[]{"Slayer helmet", "Spiny helmet"}, Equipment.HELMET))),
    WARPED_TERRORBIRD("Warped terrorbird",
                      new RSTile(0, 0, 0),
                      new Requirements(new Item(new String[]{"Crystal chime"}))),
    WARPED_TORTOISE("Warped tortoise", new RSTile(0, 0, 0), new Requirements(new Item(new String[]{"Crystal chime"}))),
    WATERFIEND("Waterfiend", new RSTile(0, 0, 0)),
    WEREWOLF(new String[]{"Werewolf", "Lev", "Svetlana", "Eduard", "Irina", "Boris"}, new RSTile(0, 0, 0)),
    WOLF(new String[]{"White wolf", "Big wolf", "Wolf"}, new RSTile(0, 0, 0)),
    ZOMBIE("Zombie", new RSTile(0, 0, 0)),
    UNKNOWN("", null);
    private String[] names;
    private Requirements Requirements;
    private RSTile location;

    Monsters(String[] names, RSTile location, Requirements Requirements) {
        this.names = names;
        this.location = location;
        this.Requirements = Requirements;
    }

    Monsters(String[] names, RSTile location) {
        this(names, location, null);
    }

    Monsters(String name, RSTile location) {
        this(new String[]{name}, location, null);
    }

    Monsters(String name, RSTile location, Requirements Requirements) {
        this(new String[]{name}, location, Requirements);
    }

    public RSTile getLocation() {
        return this.location;
    }

    public Requirements getRequirements() {
        return Requirements;
    }

    public String[] getNames() {
        return this.names;
    }
}