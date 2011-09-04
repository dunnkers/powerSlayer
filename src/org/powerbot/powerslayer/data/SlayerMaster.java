package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.data.Monsters.Monster;
import org.powerbot.powerslayer.data.Quests.Quest;
import org.rsbot.script.methods.Players;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.Tile;

public enum SlayerMaster {
	// TODO Complete locations; Chaeldar and Kuradel
	TURAEL(new String[] { "Turael", "Spria" },
			new Monster[] {
				Monster.BANSHEE,
				Monster.BAT,
				Monster.BIRD,
				Monster.BEAR,
				Monster.CAVE_BUG,
				Monster.CAVE_SLIME,
				Monster.COW,
				Monster.CRAWLING_HAND,
				Monster.DESERT_LIZARD,
				Monster.GUARD_DOG,
				Monster.DWARF,
				Monster.GHOST,
				Monster.GOBLIN,
				Monster.ICEFIEND,
				Monster.MINOTAUR,
				Monster.MONKEY,
				Monster.SCORPION,
				Monster.SKELETON,
				Monster.SPIDER,
				Monster.WOLF,
				Monster.ZOMBIE
			},
			new Tile(2930, 3535), 3),
	MAZCHNA(new String[] { "Mazchna", "Achtryn" },
			new Monster[] {
				Monster.BANSHEE,
				Monster.BAT,
				Monster.BEAR,
				Monster.CATABLEPON,
				Monster.CAVE_CRAWLER,
				Monster.CAVE_SLIME,
				Monster.COCKATRICE,
				Monster.CRAWLING_HAND,
				Monster.DESERT_LIZARD,
				Monster.GUARD_DOG,
				Monster.FLESH_CRAWLERS,
				Monster.GHOUL,
				Monster.GHOST,
				Monster.HILL_GIANT,
				Monster.HOBGOBLIN,
				Monster.ICE_WARRIOR,
				Monster.KALPHITE_GUARDIAN,
				Monster.MOGRE,
				Monster.PYREFIEND,
				Monster.ROCK_SLUG,
				Monster.SKELETON,
				Monster.VAMPIRE,
				Monster.WALL_BEAST,
				Monster.WOLF,
				Monster.ZOMBIE
			},
			new Tile(3510, 3509), 20, 0, Quest.PRIEST_IN_PERIL),
	VANNAKA(new String[] { "Vannaka" },
			new Monster[] {
				Monster.ABERRANT_SPECTRE,
				Monster.ANKOU,
				Monster.BANSHEE,
				Monster.BASILISK,
				Monster.BLOODVELD,
				Monster.BRINE_RAT,
				Monster.COCKATRICE,
				Monster.CROCODILE,
				Monster.CYCLOPS,
				Monster.DUST_DEVIL,
				Monster.EARTH_WARRIOR,
				Monster.GHOUL,
				Monster.GREEN_DRAGON,
				Monster.HARPIE_BUG_SWARM,
				Monster.HILL_GIANT,
				Monster.ICE_GIANT,
				Monster.ICE_WARRIOR,
				Monster.INFERNAL_MAGE,
				Monster.JELLY,
				Monster.JUNGLE_HORROR,
				Monster.KILLERWATT,
				Monster.LESSER_DEMON,
				Monster.MOGRE,
				Monster.MOLANISK,
				Monster.MOSS_GIANT,
				Monster.OGRE,
				Monster.OTHERWORLDLY_BEINGS,
				Monster.PYREFIEND,
				Monster.SEA_SNAKE_YOUNG,
				Monster.SHADE,
				Monster.SHADOW_WARRIOR,
				Monster.TUROTH,
				Monster.VAMPIRE,
				Monster.WEREWOLF
				},
			new Tile(3146, 9914, -1), 40),
	CHAELDAR(new String[] { "Chaeldar" },
			new Monster[] {
				Monster.ABERRANT_SPECTRE,
				Monster.BANSHEE,
				Monster.BASILISK,
				Monster.BLOODVELD,
				Monster.BLUE_DRAGON,
				Monster.BRINE_RAT,
				Monster.BRONZE_DRAGON,
				Monster.CAVE_CRAWLER,
				Monster.CAVE_HORROR,
				Monster.CRAWLING_HAND,
				Monster.DAGANNOTH,
				Monster.DUST_DEVIL,
				Monster.ELF_WARRIOR,
				Monster.FEVER_SPIDER,
				Monster.FIRE_GIANTS,
				Monster.GARGOYLE,
				Monster.HARPIE_BUG_SWARM,
				Monster.JUNGLE_STRYKEWYRM,
				Monster.INFERNAL_MAGE,
				Monster.JELLY,
				Monster.JUNGLE_HORROR,
				Monster.KALPHITE_GUARDIAN,
				Monster.KURASK,
				Monster.LESSER_DEMON,
				Monster.MUTATED_ZYGOMITE,
				Monster.SHADOW_WARRIOR,
				Monster.TROLL_GENERAL,
				Monster.TUROTH,
				Monster.WARPED_TORTOISE
			},
			new Tile(0, 0), 70, 0, Quest.LOST_CITY),
	SUMONA(new String[] { "Sumona" },
			new Monster[] {
				Monster.ABERRANT_SPECTRE,
				Monster.ABYSSAL_DEMON,
				Monster.AQUANITE,
				Monster.BANSHEE,
				Monster.BASILISK,
				Monster.BLACK_DEMON,
				Monster.BLOODVELD,
				Monster.BLUE_DRAGON,
				Monster.CAVE_CRAWLER,
				Monster.CAVE_HORROR,
				Monster.DAGANNOTH,
				Monster.DESERT_STRYKEWYRM,
				Monster.DUST_DEVIL,
				Monster.ELF_WARRIOR,
				Monster.FIRE_GIANTS,
				Monster.GARGOYLE,
				Monster.GREATER_DEMON,
				Monster.HELLHOUND,
				Monster.IRON_DRAGON,
				Monster.JUNGLE_STRYKEWYRM,
				Monster.KALPHITE_GUARDIAN,
				Monster.KURASK,
				Monster.MUTATED_JADINKO,
				Monster.NECHRYAEL,
				Monster.RED_DRAGON,
				Monster.SMALL_SCARAB,
				Monster.SPIRITUAL_MAGES,
				Monster.SPIRITUAL_WARRIOR,
				Monster.TERROR_DOG,
				Monster.TROLL_GENERAL,
				Monster.TUROTH,
				Monster.WARPED_TORTOISE
			},
			new Tile(3358, 2994), 85, 35, Quest.SMOKING_KILLS),
	DURADEL(new String[] { "Duradel", "Lapalok" },
			new Monster[] {
				Monster.ABERRANT_SPECTRE,
				Monster.ABYSSAL_DEMON,
				Monster.AQUANITE,
				Monster.BLACK_DEMON,
				Monster.BLACK_DRAGON,
				Monster.BLOODVELD,
				Monster.DAGANNOTH,
				Monster.DARK_BEAST,
				Monster.DESERT_STRYKEWYRM,
				Monster.DUST_DEVIL,
				Monster.FIRE_GIANTS,
				Monster.GARGOYLE,
				Monster.GORAK,
				Monster.GREATER_DEMON,
				Monster.HELLHOUND,
				Monster.ICE_STRYKEWYRM,
				Monster.IRON_DRAGON,
				Monster.JUNGLE_STRYKEWYRM,
				Monster.KALPHITE_GUARDIAN,
				Monster.MITHRIL_DRAGON,
				Monster.MUTATED_JADINKO,
				Monster.NECHRYAEL,
				Monster.SMALL_SCARAB,
				Monster.SKELETAL_WYVERN,
				Monster.SPIRITUAL_MAGES,
				Monster.STEEL_DRAGON,
				Monster.SUQAH,
				Monster.WARPED_TERRORBIRD,
				Monster.WATERFIEND
			},
			new Tile(2869, 2982, 1), 100, 50, Quest.SHILO_VILLAGE),
	KURADEL(new String[] { "Kuradel" },
			new Monster[] {
				Monster.ABERRANT_SPECTRE,
				Monster.ABYSSAL_DEMON,
				Monster.AQUANITE,
				Monster.BLACK_DEMON,
				Monster.BLACK_DRAGON,
				Monster.BLOODVELD,
				Monster.BLUE_DRAGON,
				Monster.DAGANNOTH,
				Monster.DARK_BEAST,
				Monster.DESERT_STRYKEWYRM,
				Monster.DUST_DEVIL,
				Monster.FIRE_GIANTS,
				Monster.GARGOYLE,
				Monster.GREATER_DEMON,
				Monster.HELLHOUND,
				Monster.ICE_STRYKEWYRM,
				Monster.IRON_DRAGON,
				Monster.JUNGLE_STRYKEWYRM,
				Monster.KALPHITE_GUARDIAN,
				Monster.MITHRIL_DRAGON,
				Monster.MUTATED_JADINKO,
				Monster.NECHRYAEL,
				Monster.SKELETAL_WYVERN,
				Monster.SPIRITUAL_MAGES,
				Monster.STEEL_DRAGON,
				Monster.SUQAH,
				Monster.TERROR_DOG,
				Monster.WARPED_TORTOISE,
				Monster.VYREWATCH,
				Monster.WATERFIEND
			},
			new Tile(0, 0), 110, 75);

	private final Tile location;
	private final Monster[] monsters;
	private final String[] names;
	private final int combatLevel;
	private final int slayerLevel;
	private final Quest quest;

	private SlayerMaster(String[] name, Monster[] monsters, Tile location, int combatLevel) {
		this(name, monsters, location, combatLevel, 0);
	}

	private SlayerMaster(String[] name, Monster[] monsters, Tile location, int combatLevel,
			int slayerLevel) {
		this(name, monsters, location, combatLevel, slayerLevel, null);
	}

	private SlayerMaster(String[] name, Monster[] monsters, Tile location, int combatLevel,
			int slayerLevel, Quest quest) {
		this.names = name;
		this.monsters = monsters;
		this.location = location;
		this.combatLevel = combatLevel;
		this.slayerLevel = slayerLevel;
		this.quest = quest;
	}

	/**
	 * Checks if we have the required combat level, slayer level and quests completed.
	 * <br/>
	 * <br/>
	 * <i>Please only use in a state where you are logged in.</i>
	 * @return <tt>True</tt> if we can use this slayer master.
	 */
	public boolean canUse() {
		return Players.getLocal().getCombatLevel() >= getCombatLevel() && 
				Skills.getLevel(Skills.SLAYER) >= slayerLevel && 
				quest != null ? Quests.isQuestCompleted(quest) : true;
	}

	public Tile getLocation() {
		return location;
	}

	public Monster[] getMonsters() {
		return monsters;
	}

	public String[] getNames() {
		return names;
	}

	public int getCombatLevel() {
		return combatLevel;
	}

	public int getSlayerLevel() {
		return slayerLevel;
	}

	public Quest getQuest() {
		return quest;
	}
}