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
			
			},
			new Tile(2930, 3535), 3),
	MAZCHNA(new String[] { "Mazchna", "Achtryn" },
			new Monster[] {
			
			},
			new Tile(3510, 3509), 20, 0, Quest.PRIEST_IN_PERIL),
	VANNAKA(new String[] { "Vannaka" },
			new Monster[] {
			
			},
			new Tile(3146, 9914, -1), 40),
	CHAELDAR(new String[] { "Chaeldar" },
			new Monster[] {
			
			},
			new Tile(0, 0), 70, 0, Quest.LOST_CITY),
	SUMONA(new String[] { "Sumona" },
			new Monster[] {
			
			},
			new Tile(3358, 2994), 85, 35, Quest.SMOKING_KILLS),
	DURADEL(new String[] { "Duradel", "Lapalok" },
			new Monster[] {
			
			},
			new Tile(2869, 2982, 1), 100, 50, Quest.SHILO_VILLAGE),
	KURADEL(new String[] { "Kuradel" },
			new Monster[] {
			
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