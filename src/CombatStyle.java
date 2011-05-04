class CombatStyle {
    private Style style;

    private CombatStyle(Style style) {
        this.style = style;
    }

    private static enum Style {
        MELEE,
        MAGIC,
        RANGE
    }
}