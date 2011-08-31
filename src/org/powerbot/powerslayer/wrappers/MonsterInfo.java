package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.methods.CombatStyle.Style;

public class MonsterInfo {
    private boolean poison;
    private boolean fire;
    private CombatStyle style;
    private Weakness[] weak;

    //TODO: Fix MonsterInfo class.  Add in IDs of monsters, max hit.
    //TODO: Add WolfBane support
    public static enum Weakness {
        STAB, CRUSH, SLASH, MELEE, MAGIC, MAGIC_WATER, RANGE, UNDEAD, DEMONIC, SILVERLIGHT, DARKLIGHT, DORGESHUUN, MAGIC_FIRE, POISON, WOLFBANE, KERIS
    }

    public MonsterInfo(CombatStyle style) {
        this(style, false);
    }

    public MonsterInfo(CombatStyle attack, Weakness[] weak) {
        this(attack, weak, false);
    }

    public MonsterInfo(CombatStyle attack, boolean poison) {
        this(attack, null, poison);
    }

    public MonsterInfo(CombatStyle style, Weakness[] weak, boolean poison) {
        this.style = style;
        this.weak = weak;
        this.fire = this.style.hasStyle(Style.DRAGONFIRE) || this.style.hasStyle(Style.RANGED_DRAGONFIRE);
        this.poison = poison;
    }

    public boolean dragonFire() {
        return fire;
    }

    public CombatStyle getStyle() {
        return style;
    }

    public Weakness[] getWeakness() {
        return weak;
    }

    public boolean poisonous() {
        return poison;
    }
}
