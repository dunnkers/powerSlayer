class CombatStyle {
	public Style style;

	public CombatStyle(Style style) {
		this.style = style;
	}

	public static enum Style {
		MELEE, MAGIC, RANGE
	}
}