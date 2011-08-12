package org.powerbot.powerslayer.wrappers;


import java.util.Arrays;
import java.util.List;

public enum Rune {
    AIR(556),
    EARTH(557),
    WATER(555),
    FIRE(554),
    BODY(559),
    MIND(558),
    CHAOS(562),
    DEATH(560),
    COSMIC(564),
    LAW(563),
    NATURE(561),
    ASTRAL(9075),
    BLOOD(565),
    SOUL(566),
	LAVA(554, 557),
	MUD(555, 557),
	DUST(556, 557),
	STEAM(554, 555),
	MIST(555, 556),
	SMOKE(554, 556);

    private final int[] ids;

    Rune(int... ids) {
        this.ids = ids;
    }

    public int[] getItemIDs() {
        return ids;
    }

    public boolean isElemental() {
	    //TODO: FIX WARNING: Confusing primitive array argument to var-arg method ( Anyone know how to fix this?)
	    List ids =  Arrays.asList(this.getItemIDs());
        return ids.contains(AIR.getItemIDs()) || ids.contains(WATER.getItemIDs()) ||
		        ids.contains(FIRE.getItemIDs()) || ids.contains(EARTH.getItemIDs());
    }
}
