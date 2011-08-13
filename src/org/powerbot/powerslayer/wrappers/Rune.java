package org.powerbot.powerslayer.wrappers;

public enum Rune {
    AIR (556),
    EARTH (557),
    WATER (555),
    FIRE (554),
    BODY (559),
    MIND (558),
    CHAOS (562),
    DEATH (560),
    COSMIC (564),
    LAW (563),
    NATURE (561),
    ASTRAL (9075),
    BLOOD (565),
    SOUL (566),
	LAVA (554, 557),
	MUD (555, 557),
	DUST (556, 557),
	STEAM (554, 555),
	MIST (555, 556),
	SMOKE (554, 556);

    private final int[] ids;

    Rune(int... IDs) {
        ids = IDs;
    }

    public int[] getItemIDs() {
        return ids;
    }

    public boolean isElemental() {
    	return this.equals(AIR) || this.equals(EARTH) || this.equals(FIRE) || this.equals(WATER);
    }
}
