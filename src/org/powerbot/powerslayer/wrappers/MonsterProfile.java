package org.powerbot.powerslayer.wrappers;

import java.util.EnumSet;

import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.methods.CombatStyle.Style;

public class MonsterProfile {
	private boolean posion;
	private boolean fire;
	private CombatStyle style;
	private EnumSet<Weakness> weak;

	public static enum Weakness {
		STAB, CRUSH, SLASH, MELEE, MAGIC, RANGE, UNDEAD, DEMONIC
	}

	public MonsterProfile(CombatStyle style) {
		this(style, false);
	}

	public MonsterProfile(CombatStyle attack, EnumSet<Weakness> weak) {
		this(attack, weak, false);
	}

	public MonsterProfile(CombatStyle attack, boolean posion) {
		this(attack, null, posion);
	}

	public MonsterProfile(CombatStyle style, EnumSet<Weakness> weak,
			boolean posion) {
		this.style = style;
		this.weak = weak;
		this.fire = this.style.hasStyle(Style.DRAGONFIRE)
				|| this.style.hasStyle(Style.RANGED_DRAGONFIRE);
		this.posion = posion;
	}

	public CombatStyle getStyle() {
		return style;
	}

	public boolean dragonfire() {
		return fire;
	}

	public boolean posionous() {
		return posion;
	}

	public EnumSet<Weakness> getWeakness() {
		return weak;
	}
}
