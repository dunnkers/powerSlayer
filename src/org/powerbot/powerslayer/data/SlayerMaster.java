package org.powerbot.powerslayer.data;

import org.rsbot.script.wrappers.RSTile;

public enum SlayerMaster {
    // TODO Add other slayer masters + locations
    MAZCHNA(new String[]{"Mazchna", "Achtryn"}, new RSTile(3510, 3509, 0), 20),
    TURAEL(new String[]{"Turael", "Spria"}, new RSTile(0, 0, 0), 3),
    VANNAKA(new String[]{"Vannaka"}, new RSTile(0, 0), 40),
    CHAELDAR(new String[]{"Chaeldar"}, new RSTile(0, 0), 70),
    SUMONA(new String[]{"Sumona"}, new RSTile(0, 0), 85, 35),
    DURADEL(new String[]{"Duradel", "Lapalok"}, new RSTile(0, 0), 100, 50),
    KURADEL(new String[]{"Kuradel"}, new RSTile(0, 0), 110, 75);
    private RSTile location;
    private String[] name;
    private int combatLevel;
    private int slayerLevel;

    private SlayerMaster(String[] name, RSTile location, int combatLevel) {
        this.name = name;
        this.location = location;
        this.combatLevel = combatLevel;
        this.slayerLevel = 0;
    }

    private SlayerMaster(String[] name, RSTile location, int combatLevel,
                         int slayerLevel) {
        this.name = name;
        this.location = location;
        this.combatLevel = combatLevel;
        this.slayerLevel = slayerLevel;
    }

    public SlayerMaster get(String name) {
        for (SlayerMaster master : values()) {
            for (String s : master.getNames()) {
                if (name.toLowerCase().contains(s.toLowerCase())) {
                    return master;
                }
            }
        }
        return null;
    }

    public RSTile getLocation() {
        return this.location;
    }

    public String[] getNames() {
        return this.name;
    }

    private int getSlayerLevel() {
        return this.slayerLevel;
    }

    private int getCombatLevel() {
        return this.combatLevel;
    }
}