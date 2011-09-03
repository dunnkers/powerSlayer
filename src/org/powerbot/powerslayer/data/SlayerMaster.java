package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.data.Quests.Quest;
import org.rsbot.script.methods.Players;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.Tile;

public enum SlayerMaster {
	// TODO Add other slayer masters + locations
	TURAEL(new String[] { "Turael", "Spria" }, new Tile(0, 0, 0), 3),
	MAZCHNA(new String[] { "Mazchna", "Achtryn" }, new Tile(3510, 3509, 0), 20, 0, Quest.PRIEST_IN_PERIL),
	VANNAKA(new String[] { "Vannaka" }, new Tile(3146, 9914, -1), 40),
	CHAELDAR(new String[] { "Chaeldar" }, new Tile(0, 0), 70, 0, Quest.LOST_CITY),
	SUMONA(new String[] { "Sumona" }, new Tile(0, 0), 85, 35, Quest.SMOKING_KILLS),
	DURADEL(new String[] { "Duradel", "Lapalok" }, new Tile(0, 0), 100, 50, Quest.SHILO_VILLAGE),
	KURADEL(new String[] { "Kuradel" }, new Tile(0, 0), 110, 75);

	private final Tile location;
	private final String[] names;
	private final int combatLevel;
	private final int slayerLevel;
	private final Quest quest;

	private SlayerMaster(String[] name, Tile location, int combatLevel) {
		this(name, location, combatLevel, 0);
	}

	private SlayerMaster(String[] name, Tile location, int combatLevel,
			int slayerLevel) {
		this(name, location, combatLevel, slayerLevel, null);
	}

	private SlayerMaster(String[] name, Tile location, int combatLevel,
			int slayerLevel, Quest quest) {
		this.names = name;
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

	public int getCombatLevel() {
		return this.combatLevel;
	}

	public Tile getLocation() {
		return this.location;
	}

	public String[] getNames() {
		return this.names;
	}

	public int getSlayerLevel() {
		return this.slayerLevel;
	}
}