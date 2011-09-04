package org.powerbot.powerslayer.methods;

import java.util.ArrayList;
import java.util.Arrays;


//TODO: Discuss movement/ rewriting
public class CombatStyle {

	private final ArrayList<Style> styles;
	
	//FIXME: Is this right comparing to the previous constructor? -> The maxHits can be initialized somewhere else.
	public CombatStyle(final Style... styles) {
		this.styles = new ArrayList<Style>(Arrays.asList(styles));
	}
	
	/**
	 * Checks if this CombatStyle has all the given styles.
	 * @param styles The styles.
	 * @return <tt>True</tt> if this CombatStyle contained all given styles.
	 */
	public boolean hasStyle(Style... styles) {
		if (styles == null || !(styles.length > 0)) {
			return false;
		}
		for (final Style style : styles) {
			if (!this.styles.contains(style)) {
				return false;
			}
		}
		return true;
	}

	public enum Style {
		MELEE,
		MAGIC,
		RANGE,
		DRAGONFIRE,
		RANGED_DRAGONFIRE,
		MAGICAL_MELEE,
		MAGICAL_RANGE
	}
	
	/*private final Style[] styles;
	 * private final int[] maxHits;

	public CombatStyle(final Style a, final Style... style) {
		this.style = new Style[1 + style.length];
		this.style[0] = a;
		for (int i = 0; i < style.length; i++) {
			this.style[i + 1] = style[0];
		}
		maxHits = new int[this.style.length];
		Arrays.fill(maxHits, -1);
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

	public int getMaxHit(int tier) {
		if (tier < 0) {
			return maxHits[0];
		} else if (tier >= maxHits.length) {
			return maxHits[maxHits.length - 1];
		} else {
			return maxHits[tier];
		}
	}
	
	// TODO: write setStyle method
	public boolean setStyle(Style style) {
		return false;
	}

	public boolean hasStyle(Style style) {
		for (Style s : this.styles) {
			if (s.equals(style)) {
				return true;
			}
		}
		return false;
	}*/
}