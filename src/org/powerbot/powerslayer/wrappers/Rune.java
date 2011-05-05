package org.powerbot.powerslayer.wrappers;

/**
 * Created by IntelliJ IDEA.
 * User: Taylor
 * Date: 5/5/11
 * Time: 6:03 PM
 * Package: org.powerbot.powerslayer.wrappers;
 */
public enum Rune
{
    AIR,
    EARTH,
    WATER,
    FIRE,
    BODY,
    MIND,
    CHAOS,
    DEATH,
    COSMIC,
    LAW,
    NATURE,
    ASTRAL,
    BLOOD,
    SOUL;
    // Combo runes aren't mentioned as they would be included in the id list for
    // each rune.
    private final int[] ids;

    Rune(int... ids) {
        this.ids = ids;
    }

    public int[] getItemIDs() {
        return ids;
    }

    public boolean isElemental() {
        return this == AIR || this == WATER || this == FIRE || this == EARTH;
    }
}
