import org.rsbot.script.wrappers.RSTile;

enum SlayerMaster {
    // TODO Add other slayer masters + locations
    MAZCHNA("Mazchna", new RSTile(3510, 3509, 0), 20),
    TURAEL("Turael", new RSTile(0, 0, 0), 3);
    private RSTile location;
    private String name;
    private int combatLevel;
    private int slayerLevel;

    private SlayerMaster(String name, RSTile location, int combatLevel) {
        this.name = name;
        this.location = location;
        this.combatLevel = combatLevel;
        this.slayerLevel = 0;
    }

    private SlayerMaster(String name, RSTile location, int combatLevel,
                         int slayerLevel) {
        this.name = name;
        this.location = location;
        this.combatLevel = combatLevel;
        this.slayerLevel = slayerLevel;
    }

    public SlayerMaster get(String name) {
        for (SlayerMaster master : values()) {
            if (name.toLowerCase().contains(master.getName().toLowerCase())) {
                return master;
            }
        }
        return null;
    }

    public RSTile getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    private int getSlayerLevel() {
        return this.slayerLevel;
    }

    private int getCombatLevel() {
        return this.combatLevel;
    }
}