package org.powerbot.powerslayer.data;

import org.rsbot.script.methods.Players;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.Tile;

public enum SlayerMaster {
	// TODO Add other slayer masters + locations
	TURAEL(new String[] { "Turael", "Spria" }, new Tile(0, 0, 0), 3),
	MAZCHNA(
			new String[] { "Mazchna", "Achtryn" }, new Tile(3510, 3509, 0), 20),
	VANNAKA(
			new String[] { "Vannaka" }, new Tile(3146, 9914, -1), 40),
	CHAELDAR(
			new String[] { "Chaeldar" }, new Tile(0, 0), 70),
	SUMONA(
			new String[] { "Sumona" }, new Tile(0, 0), 85, 35),
	DURADEL(
			new String[] { "Duradel", "Lapalok" }, new Tile(0, 0), 100, 50),
	KURADEL(
			new String[] { "Kuradel" }, new Tile(0, 0), 110, 75);

	private final Tile location;
	private final String[] names;
	private final int combatLevel;
	private final int slayerLevel;

	private SlayerMaster(String[] name, Tile location, int combatLevel) {
		this(name, location, combatLevel, 0);
	}

	private SlayerMaster(String[] name, Tile location, int combatLevel,
			int slayerLevel) {
		this.names = name;
		this.location = location;
		this.combatLevel = combatLevel;
		this.slayerLevel = slayerLevel;
	}

	public boolean canUse() {
		return Players.getLocal().getCombatLevel() >= getCombatLevel() && Skills.getLevel(Skills.SLAYER) >= slayerLevel;
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