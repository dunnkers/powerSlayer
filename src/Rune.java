public enum Rune {
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
