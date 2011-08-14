package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.methods.CombatStyle.Style;

public class MonsterProfile {
    private boolean poison;
    private boolean fire;
    private CombatStyle style;
    private Weakness[] weak;

    //TODO: Fix MonsterProfile class.  Add in IDs of monsters, max hit.
    
    public static enum Weakness {
        STAB, CRUSH, SLASH, MELEE, MAGIC, MAGIC_WATER, RANGE, UNDEAD, DEMONIC, SILVERLIGHT, DARKLIGHT, DORGESHUUN, MAGIC_FIRE
    }

    public MonsterProfile(CombatStyle style) {
        this(style, false);
    }

    public MonsterProfile(CombatStyle attack, Weakness[] weak) {
        this(attack, weak, false);
    }

    public MonsterProfile(CombatStyle attack, boolean poison) {
        this(attack, null, poison);
    }

    public MonsterProfile(CombatStyle style, Weakness[] weak,
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

    public boolean dragonFire() {
        return fire;
    }

    public boolean poisonous() {
        return poison;
    }

    public Weakness[] getWeakness() {
        return weak;
    }
}
