package org.powerbot.powerslayer.methods;


//TODO: Discuss movement/ rewriting
public class CombatStyle {

	private final Style[] style;
	//private final int[] maxHits;

	public CombatStyle(final Style a, final Style... style) {
		this.style = new Style[1 + style.length];
		this.style[0] = a;
		for (int i = 0; i < style.length; i++) {
			this.style[i + 1] = style[0];
		}
		//maxHits = new int[this.style.length];
		//Arrays.fill(maxHits, -1);
	}

	public Style getStyle() {
		return getStyle(0);
	}

	public Style getStyle(int tier) {
		if (tier <= 0) {
			return style[0];
		} else if (tier >= style.length) {
			return style[style.length - 1];
		} else {
			return style[tier];
		}
	}

	/*public int getMaxHit(int tier) {
		if (tier < 0) {
			return maxHits[0];
		} else if (tier >= maxHits.length) {
			return maxHits[maxHits.length - 1];
		} else {
			return maxHits[tier];
		}
	}*/

	public boolean hasStyle(Style style) {
		for (Style s : this.style) {
			if (s.equals(style)) {
				return true;
			}
		}
		return false;
	}

	// TODO: write setStyle method
	public boolean setStyle(Style style) {
		return false;
	}

	public enum Style {
		MELEE, MAGIC, RANGE, DRAGONFIRE, RANGED_DRAGONFIRE, MAGICAL_MELEE, MAGICAL_RANGE
	}
}