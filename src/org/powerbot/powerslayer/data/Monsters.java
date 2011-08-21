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

public class Monsters {
	
	public enum Monster {
		// 	TODO Convert Locations to MonsterLocations and fix code on top of the framework
		// 	TODO Add Loots?
		//	TODO: Add in Slayer levels for monsters that are part of a group
		ABBERANT_SPECTRE
			("Aberrant Spectre", new Requirements(new SlayerEquipment[] {SlayerEquipment.Nosepeg, SlayerEquipment.Slayer_Helmet}),
			new MonsterProfile (new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.UNDEAD}), new MonsterLocation(null, new Tile (3418, 3549, 1))),
		ABYSSAL_DEMON
			("Abyssal Demon", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SILVERLIGHT, Weakness.DARKLIGHT}), 
			new MonsterLocation (null, new Tile(3418, 3567, 2))),
		AQUANITE
			("Aquanite", new MonsterProfile (new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.STAB, Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(2715, 9973))),
		ANKOU
			("Ankou", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD, Weakness.STAB, Weakness.RANGE, Weakness.MAGIC}), 
			new MonsterLocation (null, new Tile(2326, 5199))),
		ASYN_SHADE
			("Asyn shade", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BANSHEE
			("Banshee", new Requirements(new SlayerEquipment[] {SlayerEquipment.Earmuffs, SlayerEquipment.Masked_Earmuffs, SlayerEquipment.Slayer_Helmet}), 
			new MonsterProfile (new CombatStyle (Style.MAGICAL_MELEE), new Weakness[] {Weakness.UNDEAD}),  
			new MonsterLocation (null, new Tile(3441, 3546))), 
		BASILISK
			("Basilisk", new Requirements(new SlayerEquipment[] {SlayerEquipment.Mirror_Shield}),
			new MonsterProfile (new CombatStyle(Style.MELEE)), new MonsterLocation (null, new Tile(2742, 10010))),
		BAT
			("Bat", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BEAR
			("Black bear", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BIRD
			("Chicken", new MonsterProfile (new CombatStyle (Style.MELEE), null), new MonsterLocation (null, new Tile(0, 0, 0))),
		BLACK_DEMON
			("Black demon", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BLACK_DRAGON
			("Black dragon", new Requirements (new SlayerEquipment[] {SlayerEquipment.AntiDragon_Shield}),
			new MonsterProfile (new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BLOODVELD
			("Bloodveld", new MonsterProfile(new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.SLASH, Weakness.RANGE, Weakness.SILVERLIGHT, Weakness.DARKLIGHT}), 
			new MonsterLocation (null, new Tile(3420, 3564, 1))),
		BLUE_DRAGON
			("Blue dragon", new MonsterProfile (new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BRINE_RAT
			("Brine rat", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		BRONZE_DRAGON
			("Bronze dragon", new MonsterProfile(new CombatStyle(Style.MELEE,Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.MAGIC, Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CATABLEPON
			("Catablepon", new MonsterProfile (new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.CRUSH, Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(2153, 5253)), new MonsterLocation (null, new Tile(2161, 5282)), 
			new MonsterLocation (null, new Tile(2166, 5303)), new MonsterLocation (null, new Tile(2122, 5299))),
		CAVE_BUG
			("Cave bug", new Requirements(true), new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CAVE_CRAWLER
			("Cave crawler", null, new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH, Weakness.DORGESHUUN}, true), 
			new MonsterLocation (null, new Tile(2787, 9997, 0))),
		CAVE_HORROR
			("Cave horror", new Requirements(new SlayerEquipment[] {SlayerEquipment.Witchwood_Icon}, true), 
			new MonsterProfile(new CombatStyle (Style.MELEE, Style.MAGICAL_MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CAVE_SLIME
			("Cave slime", null, new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}, true), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		COCKATRICE
			("Cockatrice", new Requirements(new SlayerEquipment[] {SlayerEquipment.Mirror_Shield}), 
			new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(2790, 10035))),
		CORPSE_SPIDER
			("Corpse spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		COW
			("Cow", new MonsterProfile(new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CRAWLING_HAND
			("Crawling hand", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD}), 
			new MonsterLocation (null, new Tile(3422, 3546))),
		CROCODILE
			("Crocodile", new Requirements(new SlayerEquipment[] {SlayerEquipment.Water_Skin, SlayerEquipment.Ice_Cooler},  new Finisher(SlayerEquipment.Rock_Hammer)), 
			new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		CRYPT_SPIDER
			("Crypt spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Multiple locations with different Weaknesses based on location & level
		DAGANNOTH
			("Dagannoth", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_GUARDIAN
			("Dagannoth guardian", new MonsterProfile (new CombatStyle (Style.MELEE, Style.RANGE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_PRIME
			("Dagannoth prime", new MonsterProfile (new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_REX
			("Dagannoth rex", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.MAGIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_SPAWN
			("Dagannoth spawn", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MELEE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DAGANNOTH_SUPREME
			("Dagannoth spawn", new MonsterProfile (new CombatStyle (Style.RANGE), new Weakness[] {Weakness.SLASH, Weakness.MAGIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DARK_BEAST
			("Dark beast", new MonsterProfile (new CombatStyle (Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		// TODO Moruner Armour...
		DEADLY_RED_SPIDER
			("Deadly red spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH, Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DESERT_LIZARD
			("Desert lizard", new Requirements(new SlayerEquipment[] {SlayerEquipment.Water_Skin}), new MonsterProfile (new CombatStyle (Style.MELEE) , new Weakness[] {Weakness.MAGIC}),
			new MonsterLocation (null, new Tile (0, 0, 0))),
		DESERT_WOLF
			("Desert wolf", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		DIRE_WOLF
			("Dire wolf", new MonsterProfile (new CombatStyle(Style.MELEE), null), new MonsterLocation (null, new Tile(0, 0, 0))),
		DUST_DEVIL
			("Dust devil", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Helmet, SlayerEquipment.Face_Mask}), 
			new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0,0))),
		DWARF
			("Dwarf", new MonsterProfile (new CombatStyle (Style.MELEE)), new MonsterLocation (null, new Tile(0, 0, 0))),
		EARTH_WARRIOR
			("Earth warrior", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ELF_WARRIOR
			("Elf warrior", new MonsterProfile (new CombatStyle (Style.MELEE, Style.RANGE), new Weakness[] {Weakness.STAB, Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FENRIS_WOLF
			("Fenris wolf", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FEVER_SPIDER
			("Fever spider", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Gloves}), 
			new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FIRE_GIANTS
			("Fire giants", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.MAGIC_WATER}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FIYR_SHADE
			("Fiyr shade", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		FLESH_CRAWLERS
			("Flesh crawlers", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.MELEE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GARGOYLE
			("Gargoyle", new Requirements(new SlayerEquipment[] {SlayerEquipment.Rock_Hammer}, new Finisher(SlayerEquipment.Rock_Hammer)), 
			new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(3441, 3544, 2))),
		GHOST
			("Ghost", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.UNDEAD, Weakness.MAGIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GHOUL
			("Ghoul", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MELEE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GIANT_CRYPT_SPIDER
			("Giant crypt spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GIANT_SPIDER
			("Giant spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.SLASH, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GOBLIN
			("Goblin", new MonsterProfile (new CombatStyle (Style.MELEE), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GORAK
			("Gorak", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GREATER_DEMON
			("Greater demon", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GREEN_DRAGON
			("Green dragon", null, new MonsterProfile (new CombatStyle(Style.MELEE, Style.DRAGONFIRE), new Weakness[] {Weakness.MAGIC, Weakness.RANGE, Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		GUARD_DOG
			("Guard dog", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		HARPIE_BUG_SWARM
			("Harpie Bug Swarm", new Requirements(new SlayerEquipment[] {SlayerEquipment.Lit_Bug_Lantern}), 
			new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		HELLHOUND
			("Hellhound", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB, Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		HILL_GIANT
			("Hill giant", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICEFIEND
			("Icefiend", new MonsterProfile (new CombatStyle (Style.MELEE, Style.MAGIC, Style.RANGE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_GIANT
			("Ice giant", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH, Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_TROLL
			(new String[] {"Ice troll male", "Ice troll grunt"}, new MonsterProfile(new CombatStyle(Style.MELEE), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_TROLL_FEMALE
			("Ice troll female", new MonsterProfile(new CombatStyle(Style.RANGE), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_TROLL_KING
			("Ice troll female", new MonsterProfile(new CombatStyle(Style.RANGE, Style.MAGIC, Style.MELEE), new Weakness[] {Weakness.POISON, Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_TROLL_RUNT
			("Ice troll runt", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC_WATER}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_WARRIOR
			("Ice warrior", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.MAGIC_FIRE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_WOLF
			("Ice wolf", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC_FIRE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		INFERNAL_MAGE
			("Infernal mage", new MonsterProfile (new CombatStyle (Style.MAGIC), new Weakness[] {Weakness.SLASH, Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(3439, 3564, 1))),
		IRON_DRAGON
			("Iron dragon", null, new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.STAB, Weakness.MAGIC_FIRE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ICE_SPIDER
			("Ice spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH, Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		JACKAL
			("Jackal", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		JELLY
			("Jelly", null, new MonsterProfile(new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.SLASH, Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(2704, 10027))),
		JUNGLE_HORROR
			("Jungle horror", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		JUNGLE_SPIDER
			("Jungle spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		JUNGLE_WOLF
			("Jungle wolf", new MonsterProfile (new CombatStyle(Style.MELEE), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Add in Keris support
		KALPHITE_GUARDIAN
			("Kalphite guardian", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KALPHITE_QUEEN
			("Kalphite queen", new MonsterProfile (new CombatStyle (Style.MELEE, Style.MAGIC, Style.RANGE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KALPHITE_SOLDIER
			("Kalphite soldier", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KALPHITE_WORKER
			("Kalphite worker", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KILLERWATT
			("Killerwatt", new Requirements(new SlayerEquipment[] {SlayerEquipment.Insulated_Boots}), 
			new MonsterProfile (new CombatStyle (Style.MAGICAL_MELEE, Style.RANGE), new Weakness[] {Weakness.MELEE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		KURASK
			("Kurask", new Requirements(new SlayerEquipment[] {SlayerEquipment.LeafBladed_Spear, SlayerEquipment.LeafBladed_Sword}),
			new MonsterProfile (new CombatStyle(Style.MELEE)), 
			new MonsterLocation (null, new Tile(2705, 9999))),
		LESSER_DEMON
			("Lesser demon", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.DEMONIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		LOAR_SHADE
			("Loar shade", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		LOCUST_LANCER
			("Locust lancer", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MELEE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		LOCUST_RANGER
			("Locust ranger", new MonsterProfile(new CombatStyle(Style.RANGE), new Weakness[] {Weakness.MELEE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Weakness changes depending on level, need to add Keris for Ranger and Rider
		LOCUST_RIDER
			("Locust rider", new MonsterProfile(new CombatStyle(Style.MELEE, Style.RANGE), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MITHRIL_DRAGON
			("Mithril dragon", new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE, Style.RANGE, Style.MAGIC), new Weakness[] {Weakness.MAGIC, Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MINOTAUR
			("Minotaur", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MOGRE
			("Mogre", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		// TODO get requirements
		MOLANISK
			("Molanisk", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Bell}, new Starter(SlayerEquipment.Slayer_Bell)), 
			new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MONKEY
			("Monkey", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MONKEY_ARCHER
			("Monkey archer", new MonsterProfile(new CombatStyle(Style.RANGE), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MONKEY_GUARD
			("Monkey guard", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MONKEY_ZOMBIE
			("Monkey zombie", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MOSS_GIANT
			("Moss giant", new MonsterProfile (new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MOUNTAIN_TROLL
			("Mountain troll", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH, Weakness.POISON}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		MUTATED_ZYGOMITE
			("Mutated zygomite", new Requirements(new SlayerEquipment[] {SlayerEquipment.Fungicide_Spray}, new Finisher(SlayerEquipment.Fungicide_Spray)), 
			new MonsterProfile (new CombatStyle(Style.MAGICAL_MELEE, Style.MAGICAL_RANGE), new Weakness[] {Weakness.SLASH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		NECHRYAEL
			("Nechryael", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.DEMONIC}), 
			new MonsterLocation (null, new Tile(3441, 3567, 2))),
		// TODO Needs nosepeg for walking past spectres...
		OGRE
			("Ogre", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		OTHERWORLDLY_BEINGS
			("Otherworldly beings", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		PHRIN_SHADE
			("Phrin shade", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		POISON_SPIDER
			("Poison spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.MAGIC_FIRE}, true),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		PYREFIEND
			("Pyrefiend", new MonsterProfile (new CombatStyle(Style.MAGICAL_MELEE), new Weakness[] {Weakness.MAGIC_WATER, Weakness.DARKLIGHT, Weakness.SILVERLIGHT, Weakness.STAB}), 
			new MonsterLocation (null, new Tile(2761, 10008))),
		RIYL_SHADE
			("Riyl shade", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ROCK_SLUG
			("Rock slug", new Requirements(new SlayerEquipment[] {SlayerEquipment.Bag_Of_Salt}, new Finisher(SlayerEquipment.Bag_Of_Salt)), 
			new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(2798, 10019, 0))),
		SCABARAS_LANCER
			("Scabaras lancer", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SCABARAS_MAGE
			("Scabaras mage", new MonsterProfile(new CombatStyle(Style.MAGIC), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SCABARAS_RANGER
			("Scabaras ranger", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MELEE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SCARAB_MAGE
			("Scarab mage", new Requirements (new SlayerEquipment[] {SlayerEquipment.Tinderbox}), 
			new MonsterProfile(new CombatStyle(Style.MAGIC), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SCORPION
			("Scorpion", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.CRUSH}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SEA_SNAKE_HATCHLING
			("Sea snake hatchling", null, new MonsterProfile(new CombatStyle(Style.MELEE), true),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SEA_SNAKE_YOUNG
			("Sea snake young", null, new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.STAB} ,true),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SHADE
			("Shade", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.RANGE, Weakness.UNDEAD}), 
			new MonsterLocation (null, new Tile(2361, 5213))),
		SHADOW_SPIDER
			("Shadow spider", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SHADOW_WARRIOR
			("Shadow warrior", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SKELETAL_WYVERN
			("Skeletal wyvern", new Requirements(new SlayerEquipment[] {SlayerEquipment.Elemental_Shield, SlayerEquipment.Mind_Shield, SlayerEquipment.Body_Shield, SlayerEquipment.Dragonfire_Shield}),
			new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SKELETON
			("Skeleton", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH, Weakness.UNDEAD}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//TODO: Add in Missing My Mummy as Quest Req
		SMALL_SCARAB
			("Small scarab", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SPIDER
			("Spider", new MonsterProfile (new CombatStyle (Style.MELEE), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SPIRITUAL_MAGES
			("Spiritual mage", new MonsterProfile (new CombatStyle(Style.MAGIC), new Weakness[] {Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SPIRITUAL_RANGER
			("Spiritual ranger", new MonsterProfile (new CombatStyle(Style.RANGE), new Weakness[] {Weakness.MELEE}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SPIRITUAL_WARRIOR
			("Spiritual warrior", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		STEEL_DRAGON
			("Steel dragon", null, new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGED_DRAGONFIRE), new Weakness[] {Weakness.MAGIC_FIRE, Weakness.CRUSH, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		SUQAH
			("Suquh", new MonsterProfile (new CombatStyle(Style.MELEE, Style.MAGIC), new Weakness[] {Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Range weakness applies only to lvl 110 Terror Dogs
		TERROR_DOG
			("Terror dog", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.RANGE}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		TROLL_GENERAL
			("Troll general", new MonsterProfile(new CombatStyle(Style.MELEE), new Weakness[] {Weakness.MAGIC, Weakness.STAB}),
			new MonsterLocation (null, new Tile(0, 0, 0))),
		TUROTH
			("Turoth", new Requirements(new SlayerEquipment[] {SlayerEquipment.LeafBladed_Spear, SlayerEquipment.LeafBladed_Sword}), 
			new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.RANGE}), 
			new MonsterLocation (null, new Tile(2720, 10008))),
		VAMPIRE
			("Vampire", new Requirements(new SlayerEquipment[] {SlayerEquipment.Holy_Symbol}), 
			new MonsterProfile (new CombatStyle(Style.MELEE), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WALL_BEAST 
			("Wall beast", new Requirements(new SlayerEquipment[] {SlayerEquipment.Slayer_Helmet, SlayerEquipment.Spiny_Helmet}), 
			new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WARPED_TERRORBIRD 
			("Warped terrorbird", new Requirements(new SlayerEquipment[] {SlayerEquipment.Crystal_Chime}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//TODO weakness depends on head appendage: probably different IDs
		WARPED_TORTOISE
			("Warped tortoise", new Requirements(new SlayerEquipment[] {SlayerEquipment.Crystal_Chime}), 
			new MonsterProfile (new CombatStyle(Style.MELEE, Style.RANGE), new Weakness[] {Weakness.SLASH, Weakness.STAB, Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WATERFIEND
			("Waterfiend", new MonsterProfile (new CombatStyle(Style.MAGIC, Style.MAGICAL_RANGE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//TODO Add wolfbane weapon method
		WEREWOLF
			(new String[]{"Werewolf", "Lev", "Svetlana", "Eduard", "Irina", "Boris"}, 
			new MonsterProfile (new CombatStyle(Style.MELEE), null), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		WILD_DOG
			("Wild dog", new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.CRUSH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		//FIXME: Weakness depends on level... maybe ID different?
		WOLF
			(new String[]{"White wolf", "Wolf", "Big Wolf"}, new MonsterProfile (new CombatStyle (Style.MELEE), new Weakness[] {Weakness.STAB, Weakness.SLASH}), 
			new MonsterLocation (null, new Tile(0, 0, 0))),
		ZOMBIE
			("Zombie", new MonsterProfile (new CombatStyle(Style.MELEE), new Weakness[] {Weakness.SLASH, Weakness.UNDEAD}), 
			new MonsterLocation (null, new Tile(0, 0, 0)));

		private String[] names;
		private Requirements Requirements;
		private MonsterLocation[] monsterLocations;
		private MonsterProfile profile = null;

		Monster(String[] names, Requirements Requirements, MonsterLocation... MonsterLocations) {
			this (names, Requirements, null, MonsterLocations);
		}

		Monster(String[] names, Requirements Requirements, MonsterProfile prof, MonsterLocation... MonsterLocations) {
			this.names = names;
			monsterLocations = MonsterLocations;
			this.Requirements = Requirements;
			this.profile = prof;
		}


		Monster(String[] names, MonsterProfile prof, MonsterLocation... MonsterLocations) {
			this (names, null, prof, MonsterLocations);
		}

		Monster(String name, Requirements Requirements, MonsterLocation... MonsterLocations) {
			this(new String[]{name}, Requirements, null, MonsterLocations);
		}

		Monster(String name, Requirements Requirements, MonsterProfile prof, MonsterLocation... MonsterLocations) {
			this(new String[]{name}, Requirements, prof, MonsterLocations);
		}

		Monster(String name, MonsterProfile prof, MonsterLocation... MonsterLocations) {
			this(new String[]{name}, null, prof, MonsterLocations);
		}

		public MonsterProfile getProfile() {
			return profile;
		}

		public MonsterLocation[] getLocation() {
			return monsterLocations;
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
	private static final Monster[] 
	DAGANNOTH = {Monster.DAGANNOTH, Monster.DAGANNOTH_GUARDIAN, Monster.DAGANNOTH_PRIME, Monster.DAGANNOTH_REX, 
		Monster.DAGANNOTH_SPAWN, Monster.DAGANNOTH_SUPREME},
	DOGS = {Monster.DESERT_WOLF, Monster.DIRE_WOLF, Monster.FENRIS_WOLF, Monster.GUARD_DOG, Monster.HELLHOUND, 
		Monster.ICE_WOLF, Monster.JACKAL, Monster.JUNGLE_WOLF, Monster.TERROR_DOG, Monster.WILD_DOG, Monster.WOLF},
	KALPHITES = {Monster.KALPHITE_GUARDIAN, Monster.KALPHITE_QUEEN, Monster.KALPHITE_SOLDIER, Monster.KALPHITE_WORKER},
	MONKEYS = {Monster.MONKEY, Monster.MONKEY_ARCHER, Monster.MONKEY_GUARD, Monster.MONKEY_ZOMBIE},
	SCABARITES = {Monster.LOCUST_LANCER, Monster.LOCUST_RANGER, Monster.LOCUST_RIDER, Monster.SCABARAS_LANCER, 
		Monster.SCABARAS_MAGE, Monster.SCABARAS_RANGER, Monster.SCARAB_MAGE, Monster.SMALL_SCARAB},
	SEA_SNAKES = {Monster.SEA_SNAKE_HATCHLING, Monster.SEA_SNAKE_YOUNG},
	SHADES = {Monster.ASYN_SHADE, Monster.FIYR_SHADE, Monster.LOAR_SHADE, 
		Monster.PHRIN_SHADE, Monster.RIYL_SHADE, Monster.SHADE},
	SPIDERS = {Monster.SPIDER, Monster.CRYPT_SPIDER, Monster.DEADLY_RED_SPIDER, 
		Monster.FEVER_SPIDER, Monster.GIANT_CRYPT_SPIDER, Monster.GIANT_SPIDER, Monster.POISON_SPIDER, Monster.SHADOW_SPIDER},
	TROLLS = {Monster.ICE_TROLL, Monster.ICE_TROLL_FEMALE, Monster.ICE_TROLL_KING, 
		Monster.ICE_TROLL_RUNT, Monster.MOUNTAIN_TROLL, Monster.TROLL_GENERAL},
	WOLVES = {Monster.DESERT_WOLF, Monster.DIRE_WOLF, Monster.FENRIS_WOLF, Monster.ICE_WOLF, 
		Monster.JUNGLE_WOLF, Monster.WOLF};
	
	public Monster[] getDagannothList() {
		return DAGANNOTH;
	}
	
	public Monster[] getDogList() {
		return DOGS;
	}
	
	public Monster[] getKalphiteList() {
		return KALPHITES;
	}
	
	public Monster[] getMonkeyList() {
		return MONKEYS;
	}
	
	public Monster[] getScabariteList() {
		return SCABARITES;
	}
	
	public Monster[] getSeaSnakeList() {
		return SEA_SNAKES;
	}
	
	public Monster[] getShadeList() {
		return SHADES;
	}
	
	public Monster[] getSpiderList() {
		return SPIDERS;
	}
	
	public Monster[] getTrollList() {
		return TROLLS;
	}
	
	public Monster[] getWolfList() {
		return WOLVES;
	}
}