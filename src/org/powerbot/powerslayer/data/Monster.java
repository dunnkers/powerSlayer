package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.methods.CombatStyle.Style;
import org.powerbot.powerslayer.wrappers.Finisher;
import org.powerbot.powerslayer.wrappers.MonsterProfile;
import org.powerbot.powerslayer.wrappers.MonsterProfile.Weakness;
import org.powerbot.powerslayer.wrappers.Requirements;
import org.powerbot.powerslayer.wrappers.Starter;
import org.rsbot.script.wrappers.Tile;


public enum Monster {
    // TODO Convert Locations to MonsterLocations and fix code on top of the framework
	// TODO Add Loots?
	// TODO Add SlayerItem groups
	// TODO Add Slayer Monster groups: Dagannoth, Kalphite, Dog, Monkey, Scabarites, Sea Snake, Shade, Spider, Troll, Wolf
    ABBERANT_SPECTRE
    	("Aberrant Spectre", new Requirements(new SlayerEquipment[] {SlayerEquipment.Nosepeg, SlayerEquipment.Slayer_Helmet}),
    		new MonsterProfile (new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.UNDEAD}), new Tile (3418, 3549, 1)),
    ABYSSAL_DEMON
		("Abyssal Demon", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SILVERLIGHT, Weakness.DARKLIGHT}), new Tile(3418, 3567, 2)),
    AQUANITE
		("Aquanite", new MonsterProfile (new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.STAB, Weakness.RANGE}), new Tile(2715, 9973)),
    ANKOU
    	("Ankou", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD, Weakness.STAB, Weakness.RANGE, Weakness.MAGIC}), new Tile(2326, 5199)),
    BANSHEE
    	("Banshee", new Requirements(new SlayerEquipment[] {SlayerEquipment.Earmuffs, SlayerEquipment.Masked_Earmuffs, SlayerEquipment.Slayer_Helmet}), 
    	new MonsterProfile (new CombatStyle (Style.MAGICAL_MELEE), new Weakness[] {Weakness.UNDEAD}),  new Tile(3441, 3546)), 
    BASILISK
    	("Basilisk", new Requirements(new SlayerEquipment[] {SlayerEquipment.Mirror_Shield}),
    	new CombatStyle(Style.MELEE), new Tile(2742, 10010)),
    BAT
    	("Bat", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.RANGE}), new Tile(0, 0, 0)),
    BEAR
    	("Black bear", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC}), new Tile(0, 0, 0)),
    BIRD
    	("Chicken", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {}),new Tile(0, 0, 0)),
    BLACK_DEMON
    	("Black demon", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}), new Tile(0, 0, 0)),
    BLACK_DRAGON
    	("Black dragon", new MonsterProfile (new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.RANGE}), new Tile(0, 0, 0)),
    BLOODVELD
    	("Bloodveld", new MonsterProfile(new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.SLASH, Weakness.RANGE, Weakness.SILVERLIGHT, Weakness.DARKLIGHT}), new Tile(3420, 3564, 1)),
    BLUE_DRAGON
    	("Blue dragon", new MonsterProfile (new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.RANGE}), new Tile(0, 0, 0)),
    BRINE_RAT
    	("Brine rat", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB}), new Tile(0, 0, 0)),
    BRONZE_DRAGON
    	("Bronze dragon", new MonsterProfile(new CombatStyle(Style.MELEE,Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.MAGIC, Weakness.STAB}), new Tile(0, 0, 0)),
    CATABLEPON
    	("Catablepon", new MonsterProfile (new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.CRUSH, Weakness.RANGE}), new Tile(2153, 5253), 
    	new Tile(2161, 5282), new Tile(2166, 5303), new Tile(2122, 5299)),
    CAVE_BUG
    	("Cave bug", new Requirements(true), new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}), new Tile(0, 0, 0)),
    CAVE_CRAWLER
    	("Cave crawler", null, new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH, Weakness.DORGESHUUN},true), new Tile(2787, 9997, 0)),
    CAVE_HORROR
    	("Cave horror", new Requirements(new SlayerEquipment[] {SlayerEquipment.Witchwood_Icon}, true), new MonsterProfile(new CombatStyle (Style.MELEE, Style.MAGICAL_MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}), new Tile(0, 0, 0)),
    CAVE_SLIME
    	("Cave slime", null, new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}, true), new Tile(0, 0, 0)),
    COCKATRICE
    	("Cockatrice", new Requirements(new SlayerEquipment[] {SlayerEquipment.Mirror_Shield}), new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}),new Tile(2790, 10035)),
    COW
    	("Cow", new MonsterProfile(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), new Tile(0, 0, 0)),
    CROCODILE
    	("Crocodile", new Requirements(new SlayerEquipment[] {SlayerEquipment.Water_Skin, SlayerEquipment.Ice_Cooler}), 
    	new Finisher(SlayerEquipment.Rock_Hammer), new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), new Tile(0, 0, 0)),
    DAGANNOTH
    	("Dagannoth", new Tile(0, 0, 0)),
    DARK_BEAST
    	("Dark beast", new MonsterProfile (new CombatStyle (Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.SLASH}), new Tile(0, 0, 0)),
    CRAWLING_HAND
    	("Crawling hand", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD}), new Tile(3422, 3546)),
    // TODO Moruner Armour...
    DESERT_LIZARD
    	("Desert lizard", new Requirements(new SlayerEquipment[] {SlayerEquipment.Water_Skin}), new MonsterProfile (new CombatStyle (Style.MELEE) , new Weakness[] {Weakness.MAGIC})),
    DOG
    	("Guard dog", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), new Tile(0, 0, 0), new Tile(0, 0, 0)),
    DUST_DEVIL
    	("Dust devil", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Helmet, SlayerEquipment.Face_Mask}), 
    	new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}),new Tile(0, 0,0)),
    DWARF
    	("Dwarf", new MonsterProfile (new CombatStyle (Style.MELEE)), new Tile(0, 0, 0)),
    EARTH_WARRIOR
    	("Earth warrior", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.CRUSH}), new Tile(0, 0, 0)),
    ELF_WARRIOR
    	("Elf warrior", new MonsterProfile (new CombatStyle (Style.MELEE, Style.RANGE), new Weakness[] {Weakness.STAB, Weakness.SLASH}), new Tile(0, 0, 0)),
    FEVER_SPIDER
    	("Fever spider", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Gloves}), new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH}), new Tile(0, 0, 0)),
    FIRE_GIANTS
    	("Fire giants", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.MAGIC_WATER}), new Tile(0, 0, 0)),
    FLESH_CRAWLERS
    	("Flesh crawlers", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.MELEE}), new Tile(0, 0, 0)),
    GARGOYLE
    	("Gargoyle", new Requirements(new SlayerEquipment[] {SlayerEquipment.Rock_Hammer}, new Finisher(SlayerEquipment.Rock_Hammer)), 
    	new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.CRUSH}), new Tile(3441, 3544, 2)),
    GHOST
    	("Ghost", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD, Weakness.MAGIC}), new Tile(0, 0, 0)),
    GHOUL
    	("Ghoul", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MELEE}), new Tile(0, 0, 0)),
    GIANT_SPIDER
    	("Giant spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH, Weakness.RANGE}), new Tile(0, 0, 0)),
    GOBLIN
    	("Goblin", new MonsterProfile (new CombatStyle (Style.MELEE), null), new Tile(0, 0, 0)),
    GORAK
    	("Gorak", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), new Tile(0, 0, 0)),
    GREATER_DEMON
    	("Greater demon", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}), new Tile(0, 0, 0)),
    GREEN_DRAGON
    	("Green dragon", null, new MonsterProfile (new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.MAGIC, Weakness.RANGE, Weakness.STAB}), new Tile(0, 0, 0)),
    HARPIE_BUG_SWARM
    	("Harpie Bug Swarm", new Requirements(new SlayerEquipment[] {SlayerEquipment.Lit_Bug_Lantern}), new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}),new Tile(0,0, 0)),
    HELLHOUND
    	("Hellhound", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB, Weakness.SLASH}), new Tile(0, 0, 0)),
    HILL_GIANT
    	("Hill giant", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), new Tile(0, 0, 0)),
    ICEFIEND
    	("Icefiend", new MonsterProfile (new CombatStyle (Style.MELEE, Style.MAGIC, Style.RANGE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH}), new Tile(0, 0, 0)),
    ICE_GIANT
    	("Ice giant", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH, Weakness.RANGE}), new Tile(0, 0, 0)),
    ICE_WARRIOR
    	("Ice warrior", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.MAGIC_FIRE}), new Tile(0, 0, 0)),
    INFERNAL_MAGE
    	("Infernal mage", new MonsterProfile (new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.SLASH, Weakness.RANGE}), new Tile(3439, 3564, 1)),
    IRON_DRAGON
    	("Iron dragon", null, new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.MAGIC_FIRE}), new Tile(0, 0, 0)),
    JELLY
    	("Jelly", null, new MonsterProfile(new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.SLASH, Weakness.CRUSH}), new Tile(2704, 10027)),
    JUNGLE_HORROR
    	("Jungle horror", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.RANGE}), new Tile(0, 0, 0)),
    KALPHITES
    	("Kalphite worker", new Tile(0, 0, 0)),
    KILLERWATT
    	("Killerwatt", new Requirements(new SlayerEquipment[] {SlayerEquipment.Insulated_Boots}), new MonsterProfile (new CombatStyle (Style.MAGICAL_MELEE, Style.RANGE), new Weakness[] {Weakness.MELEE}), new Tile(0,0, 0)),
    KURASK
    	("Kurask", new Requirements(new SlayerEquipment[] {SlayerEquipment.LeafBladed_Spear, SlayerEquipment.LeafBladed_Sword}),
    	new MonsterProfile (new CombatStyle(Style.MELEE)), new Tile(2705, 9999)),
    LESSER_DEMON
    	("Lesser demon", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}), new Tile(0, 0, 0)),
    MITHRIL_DRAGON
    	("Mithril dragon", null, new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE, Style.RANGE, Style.MAGIC), new Weakness[] {Weakness.MAGIC, Weakness.STAB}), new Tile(0, 0, 0)),
    MINOTAUR
    	("Minotaur", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}), new Tile(0, 0, 0)),
    MOGRE
    	("Mogre", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}), new Tile(0, 0, 0)),
    // TODO get requirements
    MOLANISK
    	("Molanisk", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Bell}, new Starter(SlayerEquipment.Slayer_Bell)), 
    	new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB}), new Tile(0, 0, 0)),
    MONKEY
    	("Monkey", new Requirements(new CombatStyle(CombatStyle.Style.RANGE)), new Tile(0, 0, 0)),
    MOSS_GIANT
    	("Moss giant", new MonsterProfile (new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.STAB}), new Tile(0, 0, 0)),
    MUTATED_ZYGOMITE
    	("Mutated zygomite", new Requirements(new SlayerEquipment[] {SlayerEquipment.Fungicide_Spray}, new Finisher(SlayerEquipment.Fungicide_Spray)), 
    	new MonsterProfile (new CombatStyle(Style.MAGICAL_MELEE, Style.MAGICAL_RANGE), new Weakness[] {Weakness.SLASH}), new Tile(0, 0, 0)),
    NECHRYAEL
    	("Nechryael", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.DEMONIC}), new Tile(3441, 3567, 2)),
    // TODO Needs nosepeg for walking past spectres...
    OGRE
    	("Ogre", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}), new Tile(0, 0, 0)),
    OTHERWORLDLY_BEINGS
    	("Otherworldly beings", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}), new Tile(0, 0, 0)),
    PYREFIEND
    	("Pyrefiend", new MonsterProfile (new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.MAGIC_WATER, Weakness.DARKLIGHT, Weakness.SILVERLIGHT, Weakness.STAB}), new Tile(2761, 10008)),
    ROCK_SLUG
    	("Rock slug", new Requirements(new SlayerEquipment[] {SlayerEquipment.Bag_Of_Salt}, new Finisher(SlayerEquipment.Bag_Of_Salt)), 
    	new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}), new Tile(2798, 10019, 0)),
    SCABARITES
    	(" ", new Tile(0, 0, 0)),
    SCORPION
    	("Scorpion", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.CRUSH}), new Tile(0, 0, 0)),
    SEA_SNAKE
    	("Sea snake hatchlings", null, new MonsterProfile(new CombatStyle(Style.MELEE), true), new Tile(0, 0, 0)),
    SHADE
    	("Shade", new Tile(2361, 5213)),
    SHADOW_WARRIOR
    	("Shadow warrior", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH}), new Tile(0, 0, 0)),
    SKELETAL_WYVERN
    	("Skeletal wyvern", new Requirements(new SlayerEquipment[] {SlayerEquipment.Elemental_Shield, SlayerEquipment.Mind_Shield, SlayerEquipment.Body_Shield, SlayerEquipment.Dragonfire_Shield}),
    	new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGE), new Weakness[] {Weakness.CRUSH}), new Tile(0, 0, 0)),
    SKELETON
    	("Skeleton", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.UNDEAD}), new Tile(0, 0, 0)),
    SPIDER
    	("Spider", new Tile(0, 0, 0)),
    SPIRITUAL_MAGES
    	("Spiritual mage", new MonsterProfile (new CombatStyle(Style.MAGIC), new Weakness[] {Weakness.RANGE}), new Tile(0, 0, 0)),
    SPIRITUAL_RANGER
    	("Spiritual ranger", new MonsterProfile (new CombatStyle(Style.RANGE), new Weakness[] {Weakness.MELEE}), new Tile(0, 0, 0)),
    SPIRITUAL_WARRIOR
    	("Spiritual warrior", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}), new Tile(0, 0, 0)),
    STEEL_DRAGON
    	("Steel dragon", null, new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH, Weakness.STAB}), new Tile(0, 0, 0)),
    SUQAH
    	("Suquh", new MonsterProfile (new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.SLASH}), new Tile(0, 0, 0)),
    TROLL
    	("Troll", new Tile(0, 0, 0)),
    TUROTH
    	("Turoth", new Requirements(new SlayerEquipment[] {SlayerEquipment.LeafBladed_Spear, SlayerEquipment.LeafBladed_Sword}), 
    	new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}), new Tile( 2720, 10008)),
    VAMPIRE
    	("Vampire", new Requirements(new SlayerEquipment[] {SlayerEquipment.Holy_Symbol}), 
    	new MonsterProfile (new CombatStyle(Style.MELEE), null), new Tile(0, 0, 0)),
    WALL_BEAST 
    	("Wall beast", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Helmet, SlayerEquipment.Spiny_Helmet}), 
    	new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH}), new Tile(0, 0, 0)),
    WARPED_TERRORBIRD 
    	("Warped terrorbird", new Requirements(new SlayerEquipment[] {SlayerEquipment.Crystal_Chime}), new Tile(0, 0, 0)),
    //TODO weakness depends on head appendage: probably different IDs
    WARPED_TORTOISE
    	("Warped tortoise", new Requirements(new SlayerEquipment[] {SlayerEquipment.Crystal_Chime}), 
    	new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGE), new Weakness[] {Weakness.SLASH, Weakness.STAB, Weakness.CRUSH}), new Tile(0, 0, 0)),
    WATERFIEND
    	("Waterfiend", new MonsterProfile (new CombatStyle(Style.MAGIC, Style.MAGICAL_RANGE), new Weakness[] {Weakness.CRUSH}), new Tile(0, 0, 0)),
    //TODO Add wolfbane weapon method
    WEREWOLF
    	(new String[]{"Werewolf", "Lev", "Svetlana", "Eduard", "Irina", "Boris"}, 
    	new MonsterProfile (new CombatStyle(Style.MELEE), null), new Tile(0, 0, 0)),
    WOLF
    	(new String[]{"White wolf", "Big wolf", "Wolf"}, new Tile(0, 0, 0)),
    ZOMBIE
    	("Zombie", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH, Weakness.UNDEAD}), new Tile(0, 0, 0)),
    UNKNOWN
    	("", new Tile(0, 0, 0));
    private String[] names;
    private Requirements Requirements;
    private Tile[] location;
    private MonsterProfile profile = null;

    Monster(String[] names, Requirements Requirements, Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = Requirements;
    }

    Monster(String[] names, Requirements Requirements, MonsterProfile prof,
            Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = Requirements;
        this.profile = prof;
    }

    Monster(String[] names, Requirements Requirements, CombatStyle prof,
            Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = Requirements;
        this.profile = new MonsterProfile(prof);
    }

    Monster(String[] names, MonsterProfile prof, Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = null;
        this.profile = prof;
    }

    Monster(String[] names, CombatStyle prof, Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = null;
        this.profile = new MonsterProfile(prof);
    }

    Monster(String[] names, Tile... location) {
        this.names = names;
        this.location = location;
        this.Requirements = null;
        this.profile = null;
    }

    Monster(String name, Tile... location) {
        this.names = new String[]{name};
        this.location = location;
        this.Requirements = null;
        this.profile = null;
    }

    Monster(String name, Requirements Requirements, Tile... location) {
        this(new String[]{name}, Requirements, location);
    }
    
    Monster(String name, Requirements Requirements, Finisher finisher, MonsterProfile prof, Tile... location) {
        this(new String[]{name}, Requirements, location);
    }

    Monster(String name, Requirements Requirements, MonsterProfile prof,
            Tile... location) {
        this(new String[]{name}, Requirements, prof, location);
    }

    Monster(String name, Requirements Requirements, CombatStyle prof,
            Tile... location) {
        this(new String[]{name}, Requirements, new MonsterProfile(prof),
                location);
    }

    Monster(String name, MonsterProfile prof, Tile... location) {
        this(new String[]{name}, null, prof, location);
    }

    Monster(String name, CombatStyle prof, Tile... location) {
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
        return profile != null && profile.dragonFire();
    }

    public CombatStyle getStyle() {
        return profile != null ? profile.getStyle() : new CombatStyle(
                Style.MELEE);
    }

    public String[] getNames() {
        return this.names;
    }
}