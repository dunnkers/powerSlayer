package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.methods.CombatStyle.Style;

import java.util.EnumSet;

public class MonsterProfile {
    private boolean poison;
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

    public MonsterProfile(CombatStyle attack, boolean poison) {
        this(attack, null, poison);
    }

    public MonsterProfile(CombatStyle style, EnumSet<Weakness> weak,
                          boolean poison) {
        this.style = style;
        this.weak = weak;
        this.fire = this.style.hasStyle(Style.DRAGONFIRE)
                || this.style.hasStyle(Style.RANGED_DRAGONFIRE);
        this.poison = poison;
    }

    public CombatStyle getStyle() {
        return style;
    }

    public boolean dragonfire() {
        return fire;
    }

    public boolean poisonous() {
        return poison;
    }

    public EnumSet<Weakness> getWeakness() {
        return weak;
    }
}
