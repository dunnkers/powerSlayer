package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.methods.CombatStyle.Style;
import org.powerbot.powerslayer.wrappers.*;
import org.powerbot.powerslayer.wrappers.MonsterInfo.Weakness;
import org.rsbot.script.wrappers.Tile;

public class Monsters {

	public enum Monster {
		// 	TODO Add Loots?
		//	TODO: Add in Slayer levels for monsters that are part of a group
		ABBERANT_SPECTRE
			("Aberrant Spectre", new Requirements(new SlayerEquipment[] {SlayerEquipment.Nosepeg, SlayerEquipment.Slayer_Helmet}),
			new MonsterInfo(new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.UNDEAD}), new MonsterLocation(null, new Tile (3418, 3549, 1))),
		ABYSSAL_DEMON
			("Abyssal Demon", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SILVERLIGHT, Weakness.DARKLIGHT}),
			new MonsterLocation (null, new Tile(3418, 3567, 2))),
		AQUANITE
			("Aquanite", new MonsterInfo(new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.STAB, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(2715, 9973))),
		ANKOU
			("Ankou", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD, Weakness.STAB, Weakness.RANGE, Weakness.MAGIC}),
			new MonsterLocation (null, new Tile(2326, 5199))),
		ASYN_SHADE
			("Asyn shade", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BANSHEE
			("Banshee", new Requirements(new SlayerEquipment[] {SlayerEquipment.Earmuffs, SlayerEquipment.Masked_Earmuffs, SlayerEquipment.Slayer_Helmet}),
			new MonsterInfo(new CombatStyle (Style.MAGICAL_MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(3441, 3546))),
		BASILISK
			("Basilisk", new Requirements(new SlayerEquipment[] {SlayerEquipment.Mirror_Shield}),
			new MonsterInfo(new CombatStyle(Style.MELEE)), new MonsterLocation (null, new Tile(2742, 10010))),
		BAT
			("Bat", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BEAR
			("Black bear", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BIRD
			("Chicken", new MonsterInfo(new CombatStyle (Style.MELEE), null), new MonsterLocation (null, new Tile(0, 0, 0))),
		BLACK_DEMON
			("Black demon", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BLACK_DRAGON
			("Black dragon", new Requirements (new SlayerEquipment[] {SlayerEquipment.AntiDragon_Shield}),
			new MonsterInfo(new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BLOODVELD
			("Bloodveld", new MonsterInfo(new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.SLASH, Weakness.RANGE, Weakness.SILVERLIGHT, Weakness.DARKLIGHT}),
			new MonsterLocation (null, new Tile(3420, 3564, 1))),
		BLUE_DRAGON
			("Blue dragon", new MonsterInfo(new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BRINE_RAT
			("Brine rat", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BRONZE_DRAGON
			("Bronze dragon", new MonsterInfo(new CombatStyle(Style.MELEE,Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.MAGIC, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CATABLEPON
			("Catablepon", new MonsterInfo(new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.CRUSH, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(2153, 5253)), new MonsterLocation (null, new Tile(2161, 5282)),
			new MonsterLocation (null, new Tile(2166, 5303)), new MonsterLocation (null, new Tile(2122, 5299))),
		CAVE_BUG
			("Cave bug", new Requirements(true), new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CAVE_CRAWLER
			("Cave crawler", null, new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH, Weakness.DORGESHUUN}, true),
			new MonsterLocation (null, new Tile(2787, 9997, 0))),
		CAVE_HORROR
			("Cave horror", new Requirements(new SlayerEquipment[] {SlayerEquipment.Witchwood_Icon}, true),
			new MonsterInfo(new CombatStyle (Style.MELEE, Style.MAGICAL_MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CAVE_SLIME
			("Cave slime", null, new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}, true),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		COCKATRICE
			("Cockatrice", new Requirements(new SlayerEquipment[] {SlayerEquipment.Mirror_Shield}),
			new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(2790, 10035))),
		CORPSE_SPIDER
			("Corpse spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		COW
			("Cow", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CRAWLING_HAND
			("Crawling hand", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(3422, 3546))),
		CROCODILE
			("Crocodile", new Requirements(new SlayerEquipment[] {SlayerEquipment.Water_Skin, SlayerEquipment.Ice_Cooler},  new Finisher(SlayerEquipment.Rock_Hammer)),
			new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CRYPT_SPIDER
			("Crypt spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Multiple locations with different Weaknesses based on location & level
		DAGANNOTH
			("Dagannoth", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_GUARDIAN
			("Dagannoth guardian", new MonsterInfo(new CombatStyle (Style.MELEE, Style.RANGE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_PRIME
			("Dagannoth prime", new MonsterInfo(new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_REX
			("Dagannoth rex", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.MAGIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_SPAWN
			("Dagannoth spawn", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_SUPREME
			("Dagannoth spawn", new MonsterInfo(new CombatStyle (Style.RANGE), new Weakness[] {Weakness.SLASH, Weakness.MAGIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DARK_BEAST
			("Dark beast", new MonsterInfo(new CombatStyle (Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		// TODO Moruner Armour...
		DEADLY_RED_SPIDER
			("Deadly red spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DESERT_LIZARD
			("Desert lizard", new Requirements(new SlayerEquipment[] {SlayerEquipment.Water_Skin}), new MonsterInfo(new CombatStyle (Style.MELEE) , new Weakness[] {Weakness.MAGIC}),
			new MonsterLocation (null, new Tile (0, 0, 0))),
		DESERT_WOLF
			("Desert wolf", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DIRE_WOLF
			("Dire wolf", new MonsterInfo(new CombatStyle(Style.MELEE), null), new MonsterLocation (null, new Tile(0, 0, 0))),
		DUST_DEVIL
			("Dust devil", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Helmet, SlayerEquipment.Face_Mask}),
			new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0,0))),
		DWARF
			("Dwarf", new MonsterInfo(new CombatStyle (Style.MELEE)), new MonsterLocation (null, new Tile(0, 0, 0))),
		EARTH_WARRIOR
			("Earth warrior", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ELF_WARRIOR
			("Elf warrior", new MonsterInfo(new CombatStyle (Style.MELEE, Style.RANGE), new Weakness[] {Weakness.STAB, Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FENRIS_WOLF
			("Fenris wolf", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FEVER_SPIDER
			("Fever spider", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Gloves}),
			new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FIRE_GIANTS
			("Fire giants", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.MAGIC_WATER}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FIYR_SHADE
			("Fiyr shade", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FLESH_CRAWLERS
			("Flesh crawlers", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GARGOYLE
			("Gargoyle", new Requirements(new SlayerEquipment[] {SlayerEquipment.Rock_Hammer}, new Finisher(SlayerEquipment.Rock_Hammer)),
			new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(3441, 3544, 2))),
		GHOST
			("Ghost", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD, Weakness.MAGIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GHOUL
			("Ghoul", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GIANT_CRYPT_SPIDER
			("Giant crypt spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GIANT_SPIDER
			("Giant spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GOBLIN
			("Goblin", new MonsterInfo(new CombatStyle (Style.MELEE), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GORAK
			("Gorak", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GREATER_DEMON
			("Greater demon", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GREEN_DRAGON
			("Green dragon", null, new MonsterInfo(new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.MAGIC, Weakness.RANGE, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GUARD_DOG
			("Guard dog", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		HARPIE_BUG_SWARM
			("Harpie Bug Swarm", new Requirements(new SlayerEquipment[] {SlayerEquipment.Lit_Bug_Lantern}),
			new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		HELLHOUND
			("Hellhound", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB, Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		HILL_GIANT
			("Hill giant", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICEFIEND
			("Icefiend", new MonsterInfo(new CombatStyle (Style.MELEE, Style.MAGIC, Style.RANGE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_GIANT
			("Ice giant", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_TROLL
			(new String[] {"Ice troll male", "Ice troll grunt"}, new MonsterInfo(new CombatStyle(Style.MELEE), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_TROLL_FEMALE
			("Ice troll female", new MonsterInfo(new CombatStyle(Style.RANGE), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_TROLL_KING
			("Ice troll female", new MonsterInfo(new CombatStyle(Style.RANGE, Style.MAGIC, Style.MELEE), new Weakness[] {Weakness.POISON, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_TROLL_RUNT
			("Ice troll runt", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC_WATER}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_WARRIOR
			("Ice warrior", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.MAGIC_FIRE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_WOLF
			("Ice wolf", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC_FIRE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		INFERNAL_MAGE
			("Infernal mage", new MonsterInfo(new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.SLASH, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(3439, 3564, 1))),
		IRON_DRAGON
			("Iron dragon", null, new MonsterInfo(new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.MAGIC_FIRE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_SPIDER
			("Ice spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH, Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		JACKAL
			("Jackal", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		JELLY
			("Jelly", null, new MonsterInfo(new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.SLASH, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(2704, 10027))),
		JUNGLE_HORROR
			("Jungle horror", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		JUNGLE_SPIDER
			("Jungle spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		JUNGLE_WOLF
			("Jungle wolf", new MonsterInfo(new CombatStyle(Style.MELEE), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Add in Keris support
		KALPHITE_GUARDIAN
			("Kalphite guardian", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.KERIS}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KALPHITE_QUEEN
			("Kalphite queen", new MonsterInfo(new CombatStyle (Style.MELEE, Style.MAGIC, Style.RANGE), new Weakness[] {Weakness.CRUSH, Weakness.KERIS}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KALPHITE_SOLDIER
			("Kalphite soldier", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.KERIS}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KALPHITE_WORKER
			("Kalphite worker", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.KERIS}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KILLERWATT
			("Killerwatt", new Requirements(new SlayerEquipment[] {SlayerEquipment.Insulated_Boots}),
			new MonsterInfo(new CombatStyle (Style.MAGICAL_MELEE, Style.RANGE), new Weakness[] {Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KURASK
			("Kurask", new Requirements(new SlayerEquipment[] {SlayerEquipment.LeafBladed_Spear, SlayerEquipment.LeafBladed_Sword}),
			new MonsterInfo(new CombatStyle(Style.MELEE)),
			new MonsterLocation (null, new Tile(2705, 9999))),
		LESSER_DEMON
			("Lesser demon", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		LOAR_SHADE
			("Loar shade", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		LOCUST_LANCER
			("Locust lancer", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		LOCUST_RANGER
			("Locust ranger", new MonsterInfo(new CombatStyle(Style.RANGE), new Weakness[] {Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Weakness changes depending on level, need to add Keris for Ranger and Rider
		LOCUST_RIDER
			("Locust rider", new MonsterInfo(new CombatStyle(Style.MELEE, Style.RANGE), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MITHRIL_DRAGON
			("Mithril dragon", new MonsterInfo(new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE, Style.RANGE, Style.MAGIC), new Weakness[] {Weakness.MAGIC, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MINOTAUR
			("Minotaur", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MOGRE
			("Mogre", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		// TODO get requirements
		MOLANISK
			("Molanisk", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Bell}, new Starter(SlayerEquipment.Slayer_Bell)),
			new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MONKEY
			("Monkey", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MONKEY_ARCHER
			("Monkey archer", new MonsterInfo(new CombatStyle(Style.RANGE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MONKEY_GUARD
			("Monkey guard", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MONKEY_ZOMBIE
			("Monkey zombie", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MOSS_GIANT
			("Moss giant", new MonsterInfo(new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MOUNTAIN_TROLL
			("Mountain troll", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH, Weakness.POISON}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MUTATED_ZYGOMITE
			("Mutated zygomite", new Requirements(new SlayerEquipment[] {SlayerEquipment.Fungicide_Spray}, new Finisher(SlayerEquipment.Fungicide_Spray)),
			new MonsterInfo(new CombatStyle(Style.MAGICAL_MELEE, Style.MAGICAL_RANGE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		NECHRYAEL
			("Nechryael", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.DEMONIC}),
			new MonsterLocation (null, new Tile(3441, 3567, 2))),
		// TODO Needs nosepeg for walking past spectres...
		OGRE
			("Ogre", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		OTHERWORLDLY_BEINGS
			("Otherworldly beings", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		PHRIN_SHADE
			("Phrin shade", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		POISON_SPIDER
			("Poison spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.MAGIC_FIRE}, true),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		PYREFIEND
			("Pyrefiend", new MonsterInfo(new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.MAGIC_WATER, Weakness.DARKLIGHT, Weakness.SILVERLIGHT, Weakness.STAB}),
			new MonsterLocation (null, new Tile(2761, 10008))),
		RIYL_SHADE
			("Riyl shade", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ROCK_SLUG
			("Rock slug", new Requirements(new SlayerEquipment[] {SlayerEquipment.Bag_Of_Salt}, new Finisher(SlayerEquipment.Bag_Of_Salt)),
			new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(2798, 10019, 0))),
		SCABARAS_LANCER
			("Scabaras lancer", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SCABARAS_MAGE
			("Scabaras mage", new MonsterInfo(new CombatStyle(Style.MAGIC), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SCABARAS_RANGER
			("Scabaras ranger", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SCARAB_MAGE
			("Scarab mage", new Requirements (new SlayerEquipment[] {SlayerEquipment.Tinderbox}),
			new MonsterInfo(new CombatStyle(Style.MAGIC), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SCORPION
			("Scorpion", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SEA_SNAKE_HATCHLING
			("Sea snake hatchling", null, new MonsterInfo(new CombatStyle(Style.MELEE), true),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SEA_SNAKE_YOUNG
			("Sea snake young", null, new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB} ,true),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SHADE
			("Shade", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(2361, 5213))),
		SHADOW_SPIDER
			("Shadow spider", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SHADOW_WARRIOR
			("Shadow warrior", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SKELETAL_WYVERN
			("Skeletal wyvern", new Requirements(new SlayerEquipment[] {SlayerEquipment.Elemental_Shield, SlayerEquipment.Mind_Shield, SlayerEquipment.Body_Shield, SlayerEquipment.Dragonfire_Shield}),
			new MonsterInfo(new CombatStyle(Style.MELEE, Style.RANGE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SKELETON
			("Skeleton", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//TODO: Add in Missing My Mummy as Quest Req
		SMALL_SCARAB
			("Small scarab", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SPIDER
			("Spider", new MonsterInfo(new CombatStyle (Style.MELEE), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SPIRITUAL_MAGES
			("Spiritual mage", new MonsterInfo(new CombatStyle(Style.MAGIC), new Weakness[] {Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SPIRITUAL_RANGER
			("Spiritual ranger", new MonsterInfo(new CombatStyle(Style.RANGE), new Weakness[] {Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SPIRITUAL_WARRIOR
			("Spiritual warrior", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		STEEL_DRAGON
			("Steel dragon", null, new MonsterInfo(new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SUQAH
			("Suquh", new MonsterInfo(new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Range weakness applies only to lvl 110 Terror Dogs
		TERROR_DOG
			("Terror dog", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		TROLL_GENERAL
			("Troll general", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		TUROTH
			("Turoth", new Requirements(new SlayerEquipment[] {SlayerEquipment.LeafBladed_Spear, SlayerEquipment.LeafBladed_Sword}),
			new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}),
			new MonsterLocation (null, new Tile(2720, 10008))),
		VAMPIRE
			("Vampire", new Requirements(new SlayerEquipment[] {SlayerEquipment.Holy_Symbol}),
			new MonsterInfo(new CombatStyle(Style.MELEE), null),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WALL_BEAST
			("Wall beast", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Helmet, SlayerEquipment.Spiny_Helmet}),
			new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WARPED_TERRORBIRD
			("Warped terrorbird", new Requirements(new SlayerEquipment[] {SlayerEquipment.Crystal_Chime}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//TODO weakness depends on head appendage: probably different IDs
		WARPED_TORTOISE
			("Warped tortoise", new Requirements(new SlayerEquipment[] {SlayerEquipment.Crystal_Chime}),
			new MonsterInfo(new CombatStyle(Style.MELEE, Style.RANGE), new Weakness[] {Weakness.SLASH, Weakness.STAB, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WATERFIEND
			("Waterfiend", new MonsterInfo(new CombatStyle(Style.MAGIC, Style.MAGICAL_RANGE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WEREWOLF
			(new String[]{"Werewolf", "Lev", "Svetlana", "Eduard", "Irina", "Boris"},
			new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.WOLFBANE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WILD_DOG
			("Wild dog", new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Weakness depends on level... maybe ID different?
		WOLF
			(new String[]{"White wolf", "Wolf", "Big Wolf"}, new MonsterInfo(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ZOMBIE
			("Zombie", new MonsterInfo(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH, Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0)));

		private String[] names;
		private Requirements Requirements;
		private LocationProfile locationProfile;
		private MonsterInfo info = null;

		Monster(String[] names, Requirements Requirements, MonsterLocation... MonsterLocations) {
			this (names, Requirements, null, MonsterLocations);
		}

		Monster(String[] names, Requirements Requirements, MonsterInfo info, MonsterLocation... monsterLocations) {
			this.names = names;
			this.locationProfile = new LocationProfile(monsterLocations);
			this.Requirements = Requirements;
			this.info = info;
		}


		Monster(String[] names, MonsterInfo info, MonsterLocation... monsterLocations) {
			this (names, null, info, monsterLocations);
		}

		Monster(String name, Requirements Requirements, MonsterLocation... monsterLocations) {
			this(new String[]{name}, Requirements, null, monsterLocations);
		}

		Monster(String name, Requirements Requirements, MonsterInfo info, MonsterLocation... monsterLocations) {
			this(new String[]{name}, Requirements, info, monsterLocations);
		}

		Monster(String name, MonsterInfo info, MonsterLocation... monsterLocations) {
			this(new String[]{name}, null, info, monsterLocations);
		}

		public MonsterInfo getInfo() {
			return info;
		}

		public LocationProfile getLocationProfile() {
			return locationProfile;
		}

		public Requirements getRequirements() {
			return Requirements;
		}

		public boolean isPoisonous() {
			return info != null && info.poisonous();
		}

		public boolean needsAntiFire() {
			return info != null && info.dragonFire();
		}

		public CombatStyle getStyle() {
			return info != null ? info.getStyle() : new CombatStyle(
					Style.MELEE);
		}

		public String[] getNames() {
			return this.names;
		}
	}

	public enum MonsterGroup {
		DAGANNOTH (Monster.DAGANNOTH, Monster.DAGANNOTH_GUARDIAN, Monster.DAGANNOTH_PRIME, Monster.DAGANNOTH_REX,
		Monster.DAGANNOTH_SPAWN, Monster.DAGANNOTH_SUPREME),

		DOGS (Monster.DESERT_WOLF, Monster.DIRE_WOLF, Monster.FENRIS_WOLF, Monster.GUARD_DOG, Monster.HELLHOUND,
			Monster.ICE_WOLF, Monster.JACKAL, Monster.JUNGLE_WOLF, Monster.TERROR_DOG, Monster.WILD_DOG, Monster.WOLF),

		KALPHITES (Monster.KALPHITE_GUARDIAN, Monster.KALPHITE_QUEEN, Monster.KALPHITE_SOLDIER, Monster.KALPHITE_WORKER),

		MONKEYS (Monster.MONKEY, Monster.MONKEY_ARCHER, Monster.MONKEY_GUARD, Monster.MONKEY_ZOMBIE),

		SCABARITES (Monster.LOCUST_LANCER, Monster.LOCUST_RANGER, Monster.LOCUST_RIDER, Monster.SCABARAS_LANCER,
			Monster.SCABARAS_MAGE, Monster.SCABARAS_RANGER, Monster.SCARAB_MAGE, Monster.SMALL_SCARAB),

		SEA_SNAKES (Monster.SEA_SNAKE_HATCHLING, Monster.SEA_SNAKE_YOUNG),

		SHADES (Monster.ASYN_SHADE, Monster.FIYR_SHADE, Monster.LOAR_SHADE,
			Monster.PHRIN_SHADE, Monster.RIYL_SHADE, Monster.SHADE),

		SPIDERS (Monster.SPIDER, Monster.CRYPT_SPIDER, Monster.DEADLY_RED_SPIDER,
			Monster.FEVER_SPIDER, Monster.GIANT_CRYPT_SPIDER, Monster.GIANT_SPIDER, Monster.POISON_SPIDER, Monster.SHADOW_SPIDER),

		TROLLS (Monster.ICE_TROLL, Monster.ICE_TROLL_FEMALE, Monster.ICE_TROLL_KING,
			Monster.ICE_TROLL_RUNT, Monster.MOUNTAIN_TROLL, Monster.TROLL_GENERAL),

		WOLVES (Monster.DESERT_WOLF, Monster.DIRE_WOLF, Monster.FENRIS_WOLF, Monster.ICE_WOLF,
			Monster.JUNGLE_WOLF, Monster.WOLF);

		Monster[] monsters;

		MonsterGroup(Monster... monsters) {
			this.monsters = monsters;
		}

		public Monster[] getMonsters() {
			return this.monsters;
		}

		public String toString() {
			return name().replace("_", " ");
		}

		//TODO: Write getBestMonster Method for Monster Groups
		public Monster getBestMonster() {
			return null;
		}

	}


}