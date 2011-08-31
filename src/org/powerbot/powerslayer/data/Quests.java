package org.powerbot.powerslayer.data;

import java.util.ArrayList;

import org.rsbot.script.Script;
import org.rsbot.script.methods.Game;
import org.rsbot.script.methods.ui.Interfaces;
import org.rsbot.script.wrappers.Interface;
import org.rsbot.script.wrappers.InterfaceComponent;

/**
 * All quests in RuneScape.
 * @author Dunnkers
 */
public class Quests {

	private final static int 
		QUEST_INTERFACE = 190, QUEST_LIST = 18, HIDE_FINISHED_BUTTON = 12, MOUSE_INTERFACE = 261, BUTTON_CHANGER = 6; 
	private static ArrayList<Quest> completedQuests;
	
	public enum Quest {
		COOKS_ASSISTANT ("Cook's Assistant", 1, true),
		DEMON_SLAYER ("Demon Slayer", 2, true),
		DORICS_QUEST ("Doric's Quest", 3, true),
		DRAGON_SLAYER ("Dragon Slayer", 4, true),
		ERNEST_THE_CHICKEN ("Ernest the Chicken", 5, true),
		GOBLIN_DIPLOMACY ("Goblin Diplomacy", 6, true),
		IMP_CATCHER ("Imp Catcher", 7, true),
		THE_KNIGHTS_SWORD ("The Knight's Sword", 8, true),
		PIRATES_TREASURE ("Pirate's Treasure", 9, true),
		PRINCE_ALI_RESCUE ("Prince Ali Rescue", 10, true),
		THE_RESTLESS_GHOST ("The Restless Ghost", 11, true),
		THE_PRISONER_OF_GLOUPHRIE ("The Prisoner of Glouphrie", 12),
		RUNE_MYSTERIES ("Rune Mysteries", 13, true),
		KING_OF_THE_DWARVES ("King of the Dwarves", 14),
		SHIELD_OF_ARRAV ("Shield of Arrav", 15, true),
		VAMPIRE_SLAYER ("Vampire Slayer", 16, true),
		GUNNARS_GROUND ("Gunnar's Ground", 17, true),
		ANIMAL_MAGNETISM ("Animal Magnetism", 18),
		BETWEEN_A_ROCK ("Between a Rock...", 19),
		BIG_CHOMPY_BIRD_HUNTING ("Big Chompy Bird Hunting", 20),
		BIOHAZARD ("Biohazard", 21),
		CABIN_FEVER ("Cabin Fever", 22),
		CLOCK_TOWER ("Clock Tower", 23),
		CONTACT ("Contact!", 24),
		ZOGRE_FLESH_EATERS ("Zogre Flesh Eaters", 25),
		CREATURE_OF_FENKENSTRAIN ("Creature of Fenkenstrain", 26),
		DARKNESS_OF_HALLOWVALE ("Darkness of Hallowvale", 27),
		DEATH_TO_THE_DORGESHUUN ("Death to the Dorgeshuun", 28),
		DEATH_PLATEAU ("Death Plateau", 29),
		DESERT_TREASURE ("Desert Treasure", 30),
		DEVIOUS_MINDS ("Devious Minds", 31),
		THE_DIG_SITE ("The Dig Site", 32),
		DRUIDIC_RITUAL ("Druidic Ritual", 33),
		DWARF_CANNON ("Dwarf Cannon", 34),
		EADGARS_RUSE ("Eadgar's Ruse", 35),
		EAGLES_PEAK ("Eagles' Peak", 36),
		ELEMENTAL_WORKSHOP_I ("Elemental Workshop I", 37),
		ELEMENTAL_WORKSHOP_II ("Elemental Workshop II", 38),
		ENAKHRAS_LAMENT ("Enakhra's Lament", 39),
		ENLIGHTENED_JOURNEY ("Enlightened Journey", 40),
		THE_EYES_OF_GLOUPHRIE ("The Eyes of Glouphrie", 41),
		FAIRY_TALE_I_GROWING_PAINS ("Fairy Tale I - Growing Pains", 42),
		FAIRY_TALE_II_CURE_A_QUEEN ("Fairy Tale II - Cure a Queen", 43),
		FAMILY_CREST ("Family Crest", 44),
		THE_FEUD ("The Feud", 45),
		FIGHT_ARENA ("Fight Arena", 46),
		FISHING_CONTEST ("Fishing Contest", 47),
		FORGETTABLE_TALE ("Forgettable Tale...", 48),
		THE_FREMENNIK_TRIALS ("The Fremennik Trials", 49),
		WATERFALL_QUEST ("Waterfall Quest", 50),
		GARDEN_OF_TRANQUILLITY ("Garden of Tranquillity", 51),
		GERTRUDES_CAT ("Gertrude's Cat", 52),
		GHOSTS_AHOY ("Ghosts Ahoy", 53),
		THE_GIANT_DWARF ("The Giant Dwarf", 54),
		THE_GOLEM ("The Golem", 55),
		THE_GRAND_TREE ("The Grand Tree", 56),
		THE_HAND_IN_THE_SAND ("The Hand in the Sand", 57),
		HAUNTED_MINE ("Haunted Mine", 58),
		HAZEEL_CULT ("Hazeel Cult", 59),
		HEROES_QUEST ("Heroes' Quest", 60),
		HOLY_GRAIL ("Holy Grail", 61),
		HORROR_FROM_THE_DEEP ("Horror from the Deep", 62),
		ICTHLARINS_LITTLE_HELPER ("Icthlarin's Little Helper", 63),
		IN_AID_OF_THE_MYREQUE ("In Aid of the Myreque", 64),
		IN_SEARCH_OF_THE_MYREQUE ("In Search of the Myreque", 65),
		JUNGLE_POTION ("Jungle Potion", 66),
		LEGENDS_QUEST ("Legends' Quest", 67),
		LOST_CITY ("Lost City", 68),
		THE_LOST_TRIBE ("The Lost Tribe", 69),
		LUNAR_DIPLOMACY ("Lunar Diplomacy", 70),
		MAKING_HISTORY ("Making History", 71),
		MERLINS_CRYSTAL ("Merlin's Crystal", 72),
		MONKEY_MADNESS ("Monkey Madness", 73),
		MONKS_FRIEND ("Monk's Friend", 74),
		MOUNTAIN_DAUGHTER ("Mountain Daughter", 75),
		MOURNINGS_ENDS_PART_I ("Mourning's Ends Part I", 76),
		MOURNINGS_ENDS_PART_II ("Mourning's Ends Part II", 77),
		MURDER_MYSTERY ("Murder Mystery", 78),
		MY_ARMS_BIG_ADVENTURE ("My Arm's Big Adventure", 79),
		NATURE_SPIRIT ("Nature Spirit", 80),
		OBSERVATORY_QUEST ("Observatory Quest", 81),
		ONE_SMALL_FAVOUR ("One Small Favour", 82),
		PLAGUE_CITY ("Plague City", 83),
		PRIEST_IN_PERIL ("Priest in Peril", 84),
		RAG_AND_BONE_MAN ("Rag and Bone Man", 85),
		RATCATCHERS ("Ratcatchers", 86),
		RECIPE_FOR_DISASTER ("Recipe for Disaster", 87),
		RECRUITMENT_DRIVE ("Recruitment Drive", 88),
		REGICIDE ("Regicide", 89),
		ROVING_ELVES ("Roving Elves", 90),
		ROYAL_TROUBLE ("Royal Trouble", 91),
		RUM_DEAL ("Rum Deal", 92),
		SCORPION_CATCHER ("Scorpion Catcher", 93),
		SEA_SLUG ("Sea Slug", 94),
		THE_SLUG_MENACE ("The Slug Menace", 95),
		SHADES_OF_MORTTON ("Shades of Mort'ton", 96),
		SHADOW_OF_THE_STORM ("Shadow of the Storm", 97),
		SHEEP_HERDER ("Sheep Herder", 98),
		SHILO_VILLAGE ("Shilo Village", 99),
		A_SOULS_BANE ("A Soul's Bane", 100),
		SPIRITS_OF_THE_ELID ("Spirits of the Elid", 101),
		SWAN_SONG ("Swan Song", 102),
		TAI_BWO_WANNAI_TRIO ("Tai Bwo Wannai Trio", 103),
		A_TAIL_OF_TWO_CATS ("A Tail of Two Cats", 104),
		TEARS_OF_GUTHIX ("Tears of Guthix", 105),
		TEMPLE_OF_IKOV ("Temple of Ikov", 106),
		THRONE_OF_MISCELLANIA ("Throne of Miscellania", 107),
		THE_TOURIST_TRAP ("The Tourist Trap", 108),
		WITCHS_HOUSE ("Witch's House", 109),
		TREE_GNOME_VILLAGE ("Tree Gnome Village", 110),
		TRIBAL_TOTEM ("Tribal Totem", 111),
		TROLL_ROMANCE ("Troll Romance", 112),
		TROLL_STRONGHOLD ("Troll Stronghold", 113),
		UNDERGROUND_PASS ("Underground Pass", 114),
		WANTED ("Wanted!", 115),
		WATCHTOWER ("Watchtower", 116),
		COLD_WAR ("Cold War", 117),
		THE_FREMENNIK_ISLES ("The Fremennik Isles", 118),
		TOWER_OF_LIFE ("Tower of Life", 119),
		THE_GREAT_BRAIN_ROBBERY ("The Great Brain Robbery", 120),
		WHAT_LIES_BELOW ("What Lies Below", 121),
		OLAFS_QUEST ("Olaf's Quest", 122),
		ANOTHER_SLICE_OF_HAM ("Another Slice of H.A.M.", 123),
		DREAM_MENTOR ("Dream Mentor", 124),
		GRIM_TALES ("Grim Tales", 125),
		KINGS_RANSOM ("King's Ransom", 126),
		THE_PATH_OF_GLOUPHRIE ("The Path of Glouphrie", 127),
		BACK_TO_MY_ROOTS ("Back to my Roots", 128),
		LAND_OF_THE_GOBLINS ("Land of the Goblins", 129),
		DEALING_WITH_SCABARAS ("Dealing with Scabaras", 130),
		WOLF_WHISTLE ("Wolf Whistle", 131),
		AS_A_FIRST_RESORT ("As a First Resort", 132),
		CATAPULT_CONSTRUCTION ("Catapult Construction", 133),
		KENNITHS_CONCERNS ("Kennith's Concerns", 134),
		LEGACY_OF_SEERGAZE ("Legacy of Seergaze", 135),
		PERILS_OF_ICE_MOUNTAIN ("Perils of Ice Mountain", 136),
		TOKTZKETDILL ("TokTz-Ket-Dill", 137),
		SMOKING_KILLS ("Smoking Kills", 138),
		ROCKING_OUT ("Rocking Out", 139),
		SPIRIT_OF_SUMMER ("Spirit of Summer", 140),
		MEETING_HISTORY ("Meeting History", 141),
		ALL_FIRED_UP ("All Fired Up", 142),
		SUMMERS_END ("Summer's End", 143),
		DEFENDER_OF_VARROCK ("Defender of Varrock", 144),
		WHILE_GUTHIX_SLEEPS ("While Guthix Sleeps", 145),
		IN_PYRE_NEED ("In Pyre Need", 146),
		UNSTABLE_FOUNDATIONS ("Unstable Foundations", 147, true),
		MYTHS_OF_THE_WHITE_LANDS ("Myths of the White Lands", 148, true),
		GLORIOUS_MEMORIES ("Glorious Memories", 149),
		THE_TALE_OF_THE_MUSPAH ("The Tale of the Muspah", 150),
		HUNT_FOR_RED_RAKTUBER ("Hunt for Red Raktuber", 151),
		THE_CHOSEN_COMMANDER ("The Chosen Commander", 152),
		SWEPT_AWAY ("Swept Away", 153, true),
		FUR_N_SEEK ("Fur 'n' Seek", 154),
		MISSING_MY_MUMMY ("Missing My Mummy", 155),
		THE_CURSE_OF_ARRAV ("The Curse of Arrav", 156),
		THE_TEMPLE_AT_SENNTISTEN ("The Temple at Senntisten", 157),
		FAIRY_TALE_III_ORKS_RIFT ("Fairy Tale III - Orks Rift", 158),
		BLACK_KNIGHTS_FORTRESS ("Black Knights' Fortress", 159, true),
		FORGIVENESS_OF_A_CHAOS_DWARF ("Forgiveness of a Chaos Dwarf", 160),
		WITHIN_THE_LIGHT ("Within the Light", 161),
		NOMADS_REQUIEM ("Nomad's Requiem", 162),
		BLOOD_RUNS_DEEP ("Blood Runs Deep", 163),
		RUNE_MECHANICS ("Rune Mechanics", 165),
		BUYERS_AND_CELLARS ("Buyers and Cellars", 167),
		LOVE_STORY ("Love Story", 168),
		THE_BLOOD_PACT ("The Blood Pact", 170, true),
		QUIET_BEFORE_THE_SWARM ("Quiet Before the Swarm", 171),
		ELEMENTAL_WORKSHOP_III ("Elemental Workshop III", 172),
		A_VOID_DANCE ("A Void Dance", 173),
		THE_VOID_STARES_BACK ("The Void Stares Back", 174),
		DO_NO_EVIL ("Do No Evil", 179),
		ELEMENTAL_WORKSHOP_IV ("Elemental Workshop IV", 180),
		A_CLOCKWORK_SYRINGE ("A Clockwork Syringe", 181),
		DEADLIEST_CATCH ("Deadliest Catch", 182),
		SALT_IN_THE_WOUND ("Salt in the Wound", 183);


		private final String name;
		private final int component;
		private final boolean free;

		Quest(final String name, final int component) {
			this(name, component, false);
		}

		Quest(final String name, final int component, final boolean free) {
			this.name = name;
			this.component = component;
			this.free = free;
		}

		public String getName() {
			return name;
		}

		public int getComponentID() {
			return component;
		}

		public boolean isFree() {
			return free;
		}
	}
	
	/**
	 * @author Daniel987600
	 * @return mouse set to 2-button
	 */
	private static boolean checkMouseButtons() {
		Interface mouse = Interfaces.get(MOUSE_INTERFACE);
		InterfaceComponent mouseButtons;
		if (mouse != null) {
			mouseButtons = mouse.getComponent(BUTTON_CHANGER);
			if (mouseButtons.getTextureID() == 762) 
				return true;
		}
		for (int i = 0; i < 6; i++) {
			Game.openTab(Game.Tabs.OPTIONS);
			Script.sleep (600);
			if (!Game.isLoggedIn())  
				return false;
			if (Game.getCurrentTab().equals(Game.Tabs.OPTIONS))
				break;
			if (i == 5) 
				return false;
		}
		mouse = Interfaces.get(MOUSE_INTERFACE);
		if (mouse != null) {
			mouseButtons = mouse.getComponent(BUTTON_CHANGER);
			if (mouseButtons.getTextureID() != 762) {
				for (int i = 0; i < 5; i++) {
					mouseButtons.click();
					Script.sleep (1000);
					if (!Game.isLoggedIn())  
						return false;
					if (Interfaces.get(QUEST_INTERFACE).getComponent(HIDE_FINISHED_BUTTON).getTextureID() == 699)
						break;
					if (i == 4)
						return false;
				}
			}
		}
		return true;
	}


	/**
	 * Gets the current completed quests.
	 * 
	 * @author Dunnkers
	 * @return An ArrayList of the completed quests.
	 */
	//FIXME: Need to put this in permanent memory
	public static ArrayList<Quest> getCompletedQuests() {
		if (completedQuests != null && completedQuests.size() > 0) {
			return completedQuests;
		}
		if (!checkMouseButtons() || !setUpQuests())
			return null;
		InterfaceComponent questInterface = Interfaces.getComponent(QUEST_INTERFACE, QUEST_LIST);
		//TODO: Change this check to check against # of components
		if (questInterface.getComponents().length == 0) 
			return null;
		Quest[] quests = Quest.values();
		ArrayList<Quest> completedQuestsTemporary = new ArrayList<Quest>();
		for (Quest currQuest: quests) {
			if (currQuest == null)
				continue;
			InterfaceComponent questIComp = questInterface.getComponent(currQuest.getComponentID());
			if (questIComp.getRelativeX() == 0) 
				completedQuestsTemporary.add(currQuest);
		}
		if (!completedQuestsTemporary.isEmpty()) 
			completedQuests = completedQuestsTemporary;
		return completedQuestsTemporary.isEmpty() ? null : completedQuestsTemporary;
	}
	
	/**
	 * @author Daniel987600
	 * @return Quest Interface Open & Finished Quests filtered
	 */
	private static boolean setUpQuests() {
		InterfaceComponent questInterface = null;
		int i = 0;
		while (questInterface == null) {
			if (!Game.getCurrentTab().equals(Game.Tabs.QUESTS)) {
				if (Game.openTab(Game.Tabs.QUESTS)) {
					Script.sleep(Script.random(Script.random(250, 500), 500));
				}
			}
			i++;
			if (i > 3) 
				return false;
		}
		InterfaceComponent hideButton = questInterface.getComponent(HIDE_FINISHED_BUTTON);
		if (hideButton.getTextureID() != 699) {
			for (int y = 0; y < 5; y++) {
				hideButton.click();
				Script.sleep (1000);
				if (!Game.isLoggedIn())
					return false;
				if (Interfaces.get(QUEST_INTERFACE).getComponent(HIDE_FINISHED_BUTTON).getTextureID() == 699)
					break;
			}
		}
		return Game.getCurrentTab().equals(Game.Tabs.QUESTS) && Interfaces.getComponent(HIDE_FINISHED_BUTTON).getTextureID() == 699;
	}
	
	/**
	 * Checks if the given quests are completed.
	 * @author Dunnkers
	 * @param quests The quests you'd like to check.
	 * @return <tt>True</tt> if the given quests are completed.
	 */
	public static boolean isQuestCompleted(Quest... quests) {
		if (quests == null || !(quests.length > 0)) {
			return false;
		}
		ArrayList<Quest> completedQuests = Quests.getCompletedQuests();
		if (completedQuests == null) {
			return false;
		}
		for (Quest quest : quests) {
			if (!completedQuests.contains(quest)) {
				return false;
			}
		}
		return true;
	}
}