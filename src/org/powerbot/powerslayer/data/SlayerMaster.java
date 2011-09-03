package org.powerbot.powerslayer.data;

import org.rsbot.script.methods.Players;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.Tile;

public enum SlayerMaster {
    // TODO Add other slayer masters + locations
	
    TURAEL (new String[]{"Turael", "Spria"}, new int[] {}, new Tile(0, 0, 0), 3),
	MAZCHNA (new String[]{"Mazchna", "Achtryn"}, new int[] {}, new Tile(3510, 3509, 0), 20),
    VANNAKA (new String[]{"Vannaka"}, new int[] {}, new Tile(3146, 9914, -1), 40),
    CHAELDAR (new String[]{"Chaeldar"}, new int[] {}, new Tile(0, 0), 70),
    SUMONA (new String[]{"Sumona"}, new int[] {}, new Tile(0, 0), 85, 35),
    DURADEL (new String[]{"Duradel", "Lapalok"}, new int[] {}, new Tile(0, 0), 100, 50),
    KURADEL (new String[]{"Kuradel"}, new int[] {}, new Tile(0, 0), 110, 75);

    private Tile location;
    private String[] name;
    private int[] ids;
    private int combatLevel;
    private int slayerLevel;

    private SlayerMaster(String[] Name, int[] IDs, Tile Location, int CombatLevel) {
        this (Name, IDs, Location, CombatLevel, 0);
    }

    private SlayerMaster(String[] Name, int[] IDs, Tile Location, int CombatLevel, int SlayerLevel) {
        name = Name;
        ids = IDs;
        location = Location;
        combatLevel = CombatLevel;
        slayerLevel = SlayerLevel;
    }

    public boolean canUse() {
    	return Skills.getLevel(Skills.SLAYER) >= slayerLevel && Players.getLocal().getCombatLevel() >= combatLevel;
    }

    public int getCombatLevel() {
        return this.combatLevel;
    }

    public int getSlayerLevel() {
        return this.slayerLevel;
    }

    public int[] getIDs() {
    	return ids;
    }
    
	public Tile getLocation() {
        return this.location;
    }

    public String[] getNames() {
        return this.name;
    }

}