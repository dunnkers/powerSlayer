package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.methods.CombatStyle.Style;
import org.powerbot.powerslayer.wrappers.*;
import org.rsbot.script.methods.Equipment;
import org.rsbot.script.wrappers.Tile;


public enum Monsters {
    // TODO Add locations
    ABBERANT_SPECTRE("Aberrant Spectre", new Requirements(new EquipmentItems(
            new String[]{"Slayer helmet", "Nosepeg"}, Equipment.HELMET)), new CombatStyle(
            Style.MAGIC), new Tile(3418, 3549, 1)),
    ABYSSAL_DEMON("Abyssal Demon", new CombatStyle(Style.MELEE), new Tile(
            3418, 3567, 2)),
    AQUANITE("Aquanite", new MonsterProfile(new CombatStyle(Style.MAGIC)), new Tile(
            2715, 9973)),
    ANKOU("Ankou", new CombatStyle(Style.MELEE), new Tile(2326, 5199)),
    BANSHEE("Banshee", new Requirements(new EquipmentItems(new String[]{
            "Earmuffs", "Masked earmuffs", "Slayer helmet"}, Equipment.HELMET)), new CombatStyle(
            Style.MAGICAL_MELEE), new Tile(3441, 3546)),
    BASILISK("Basilisk", new Requirements(new EquipmentItems(
            new String[]{"Mirror shield"}, Equipment.SHIELD)), new CombatStyle(
            Style.MELEE), new Tile(2742, 10010)),
    BAT("Bat", new Tile(0, 0, 0)),
    BEAR("Black bear", new Tile(0, 0, 0)),
    BIRD("Chicken", new Tile(0, 0, 0)),
    BLACK_DEMON("Black demon", new Tile(0, 0, 0)),
    BLACK_DRAGON("Black dragon", new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Tile(
            0, 0, 0)),
    BLOODVELD("Bloodveld", new CombatStyle(Style.MAGICAL_MELEE), new Tile(
            3420, 3564, 1)),
    BLUE_DRAGON("Blue dragon", new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Tile(
            0, 0, 0)),
    BRINE_RAT("Brine rat", new Tile(0, 0, 0)),
    BRONZE_DRAGON("Bronze dragon", new CombatStyle(Style.MELEE,
            Style.RANGED_DRAGONFIRE), new Tile(0, 0, 0)),
    CATABLEPON("Catablepon", new CombatStyle(Style.MELEE, Style.MAGIC), new Tile(
            2153, 5253), new Tile(2161, 5282), new Tile(2166, 5303), new Tile(
            2122, 5299)),
    CAVE_BUG("Cave bug", new Requirements(true), new Tile(0, 0, 0)),
    CAVE_CRAWLER("Cave crawler", null, new MonsterProfile(new CombatStyle(
            Style.MELEE), true), new Tile(2787, 9997, 0)),
    CAVE_HORROR("Cave horror", new Requirements(new EquipmentItems(
            new String[]{"Witchwood icon"}, Equipment.NECK), true), new Tile(
            0, 0, 0)),
    CAVE_SLIME("Cave slime", null, new MonsterProfile(new CombatStyle(
            Style.MELEE), true), new Tile(0, 0, 0)),
    COCKATRICE("Cockatrice", new Requirements(new EquipmentItems(
            new String[]{"Mirror sheild"}, Equipment.SHIELD)), new Tile(
            2790, 10035)),
    COW("Cow", new Tile(0, 0, 0)),
    CROCODILE("Crocodile", new Requirements(new SlayerItem[]{
            new SlayerItem(new String[]{"Waterskin (1)", "Waterskin (2)",
                    "Waterskin (3)", "Waterskin (4)"}),
            new SlayerItem(new String[]{"Ice coolers"})}, new Finisher(
            new String[]{"Rock hammer"})), new Tile(0, 0, 0)),
    DRAGANNOTH("Dragannoth", new Tile(0, 0, 0)),
    DARK_BEAST("Dark beast", new Tile(0, 0, 0)),
    CRAWLING_HAND("Crawling hand", new Tile(3422, 3546)),
    // TODO Moruner Armour...
    DESERT_LIZARD("Desert lizard", new Requirements(new SlayerItem(
            new String[]{"Waterskin (1)", "Waterskin (2)", "Waterskin (3)",
                    "Waterskin (4)"}))),
    DOG("Guard dog", new Tile(0, 0, 0), new Tile(0, 0, 0)),
    DUST_DEVIL("Dust devil", new Requirements(new EquipmentItems(new String[]{
            "Slayer helmet", "Facemask"}, Equipment.HELMET)), new Tile(0, 0,
            0)),
    DWARF("Dwarf", new Tile(0, 0, 0)),
    EARTH_WARRIOR("Earth warrior", new Tile(0, 0, 0)),
    ELF("Elf warrior", new Tile(0, 0, 0)),
    FEVER_SPIDER("Fever spider", new Requirements(new EquipmentItems(
            new String[]{"Slayer gloves"}, Equipment.HANDS)), new Tile(0,
            0, 0)),
    FIRE_GIANTS("Fire giants", new Tile(0, 0, 0)),
    FLESH_CRAWLERS("Flesh crawlers", new Tile(0, 0, 0)),
    GARGOYLE("Gargoyle", new Requirements(new SlayerItem(
            new String[]{"Rock hammer"}), new Finisher(
            new String[]{"Rock hammer"})), new Tile(3441, 3544, 2)),
    GHOST("Ghost", new Tile(0, 0, 0)),
    GHOUL("Ghoul", new Tile(0, 0, 0)),
    GIANT_SPIDER("Giant spider", new Tile(0, 0, 0)),
    GOBLIN("Goblin", new Tile(0, 0, 0)),
    GORAK("Gorak", new Tile(0, 0, 0)),
    GREATER_DEMON("Greater demon", new Tile(0, 0, 0)),
    GREEN_DRAGON("Green dragon", null, new CombatStyle(Style.MELEE,
            Style.DRAGONFIRE), new Tile(0, 0, 0)),
    HARPIE_BUG_SWARM("Harpie Bug Swarm", new Requirements(new EquipmentItems(
            new String[]{"Bug lantern"}, Equipment.SHIELD)), new Tile(0,
            0, 0)),
    HELLHOUND("Hellhound", new Tile(0, 0, 0)),
    HILL_GIANT("Hill giant", new Tile(0, 0, 0)),
    ICEFIEND("Icefiend", new Tile(0, 0, 0)),
    ICE_GIANT("Ice giant", new Tile(0, 0, 0)),
    ICE_WARRIOR("Ice warrior", new Tile(0, 0, 0)),
    INFERNAL_MAGE("Infernal mage", new Tile(3439, 3564, 1)),
    IRON_DRAGON("Iron dragon", null, new CombatStyle(Style.MELEE,
            Style.RANGED_DRAGONFIRE), new Tile(0, 0, 0)),
    JELLY("Jelly", null, new MonsterProfile(
            new CombatStyle(Style.MAGICAL_MELEE), true), new Tile(2704, 10027)),
    JUNGLE_HORROR("Jungle horror", new Tile(0, 0, 0)),
    KALPHITES("Kalphite worker", new Tile(0, 0, 0)),
    KILLERWATT("Killerwatt", new Requirements(new EquipmentItems(
            new String[]{"Insulated boots"}, Equipment.FEET)), new Tile(0,
            0, 0)),
    KURASK("Kurask", new Requirements(new EquipmentItems(new String[]{
            "Leaf-bladed sword", "Leaf-bladed spear"}, Equipment.WEAPON)), new Tile(
            2705, 9999)),
    LESSER_DEMON("Lesser demon", new Tile(0, 0, 0)),
    MITHRIL_DRAGON("Mithril dragon", null, new CombatStyle(Style.MELEE,
            Style.RANGED_DRAGONFIRE), new Tile(0, 0, 0)),
    MINOTAUR("Minotaur", new Tile(0, 0, 0)),
    MOGRE("Mogre", new Tile(0, 0, 0)),
    // TODO get requirments
    MOLANISK("Molanisk", new Requirements(new SlayerItem(
            new String[]{"Slayer bell"}), new Starter(
            new String[]{"Slayer bell"})), new Tile(0, 0, 0)),
    MONKEY("Monkey", new Requirements(new CombatStyle(CombatStyle.Style.RANGE)), new Tile(
            0, 0, 0)),
    MOSS_GIANT("Moss giant", new Tile(0, 0, 0)),
    MUTATED_ZYGOMITE("Mutated zygomite", new Requirements(new SlayerItem(
            new String[]{"Fungicide spray"}), new Finisher(
            new String[]{"Fungicide spray"})), new Tile(0, 0, 0)),
    NECHRYAEL("Nechryael", new Tile(3441, 3567, 2)),
    // TODO Needs nosepeg for walking past spectres...
    OGRE("Ogre", new Tile(0, 0, 0)),
    OTHERWORLDLY_BEINGS("Otherworldly beings", new Tile(0, 0, 0)),
    PYREFIEND("Pyrefiend", new Tile(2761, 10008)),
    ROCK_SLUG("Rock slug", new Requirements(new SlayerItem(
            new String[]{"Bag of salt"}), new Finisher(
            new String[]{"Bag of salt"})), new Tile(2798, 10019, 0)),
    SCABARITES(" ", new Tile(0, 0, 0)),
    // TODO find the best scabarites
    SCORPION("Scorpion", new Tile(0, 0, 0)),
    SEA_SNAKE("Sea snake hatchlings", null, new MonsterProfile(new CombatStyle(
            Style.MELEE), true), new Tile(0, 0, 0)),
    SHADE("Shade", new Tile(2361, 5213)),
    SHADOW_WARRIOR("Shadow warrior", new Tile(0, 0, 0)),
    SKELETAL_WYVERN("Skeletal wyvern", new Requirements(new EquipmentItems(
            new String[]{"Dragonfire shield", "Mind shield",
                    "Elemental shield", "Body Shield", "Chaos Shield",
                    "Cosmic Shield"}, Equipment.SHIELD)), new Tile(0, 0, 0)),
    SKELETON("Skeleton", new Tile(0, 0, 0)),
    SPIDER("Spider", new Tile(0, 0, 0)),
    SPIRITUAL_MAGES("Spiritual mage", new Tile(0, 0, 0)),
    SPIRITUAL_RANGER("Spiritual ranger", new Tile(0, 0, 0)),
    SPIRITUAL_WARRIOR("Spiritual warrior", new Tile(0, 0, 0)),
    STEEL_DRAGON("Steel dragon", null, new CombatStyle(Style.MELEE,
            Style.RANGED_DRAGONFIRE), new Tile(0, 0, 0)),
    SUPAH("Suquh", new Tile(0, 0, 0)),
    TROLL("Troll", new Tile(0, 0, 0)),
    TUROTH("Turoth", new Requirements(new EquipmentItems(new String[]{
            "Leaf-bladed sword", "Leaf-bladed spear"}, Equipment.WEAPON)), new Tile(
            2720, 10008)),
    VAMPIRE("Vampire", new Requirements(new EquipmentItems(
            new String[]{"Blessed holy symbol"}, Equipment.NECK)), new Tile(
            0, 0, 0)),
    WALL_BEAST("Wall beast", new Requirements(new EquipmentItems(new String[]{
            "Slayer helmet", "Spiny helmet"}, Equipment.HELMET)), new Tile(
            0, 0, 0)),
    WARPED_TERRORBIRD("Warped terrorbird", new Requirements(new SlayerItem(
            new String[]{"Crystal chime"})), new Tile(0, 0, 0)),
    WARPED_TORTOISE("Warped tortoise", new Requirements(new SlayerItem(
            new String[]{"Crystal chime"})), new Tile(0, 0, 0)),
    WATERFIEND("Waterfiend", new Tile(0, 0, 0)),
    WEREWOLF(new String[]{"Werewolf", "Lev", "Svetlana", "Eduard", "Irina",
            "Boris"}, new Tile(0, 0, 0)),
    WOLF(new String[]{"White wolf", "Big wolf", "Wolf"}, new Tile(0, 0, 0)),
    ZOMBIE("Zombie", new Tile(0, 0, 0)),
    UNKNOWN("", null);
    private String[] names;
    private Requirements Requirements;
    private Tile[] location;
    private MonsterProfile profile = null;

    Monsters(String[] names, Requirements Requirements, Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = Requirements;
    }

    Monsters(String[] names, Requirements Requirements, MonsterProfile prof,
             Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = Requirements;
        this.profile = prof;
    }

    Monsters(String[] names, Requirements Requirements, CombatStyle prof,
             Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = Requirements;
        this.profile = new MonsterProfile(prof);
    }

    Monsters(String[] names, MonsterProfile prof, Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = null;
        this.profile = prof;
    }

    Monsters(String[] names, CombatStyle prof, Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = null;
        this.profile = new MonsterProfile(prof);
    }

    Monsters(String[] names, Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = null;
        this.profile = null;
    }

    Monsters(String name, Tile... location) {
        this.names = new String[]{name};
        this.location = location;
        this.Requirements = null;
        this.profile = null;
    }

    Monsters(String name, Requirements Requirements, Tile... location) {
        this(new String[]{name}, Requirements, location);
    }

    Monsters(String name, Requirements Requirements, MonsterProfile prof,
             Tile... location) {
        this(new String[]{name}, Requirements, prof, location);
    }

    Monsters(String name, Requirements Requirements, CombatStyle prof,
             Tile... location) {
        this(new String[]{name}, Requirements, new MonsterProfile(prof),
                location);
    }

    Monsters(String name, MonsterProfile prof, Tile... location) {
        this(new String[]{name}, null, prof, location);
    }

    Monsters(String name, CombatStyle prof, Tile... location) {
        this(new String[]{name}, null, new MonsterProfile(prof), location);
    }

    public MonsterProfile getProfile() {
        return profile;
    }

    public Tile[] getLocation() {
        return this.location;
    }

    public Tile getNearest(Tile base) {
        Tile best = null;
        double len = -1;
        for (Tile t : location) {
            int dX = t.getX() - base.getX();
            int dY = t.getY() - base.getY();
            double tLen = Math.sqrt((dX * dX) + (dY * dY));
            if (len == -1 || tLen < len) {
                best = t;
                len = tLen;
            }
        }
        return best;
    }

    public Requirements getRequirements() {
        return Requirements;
    }

    public boolean isPoisonous() {
        return profile != null ? profile.poisonous() : false;
    }

    public boolean needsAntiFire() {
        return profile != null && profile.dragonfire();
    }

    public CombatStyle getStyle() {
        return profile != null ? profile.getStyle() : new CombatStyle(
                Style.MELEE);
    }

    public String[] getNames() {
        return this.names;
    }
}