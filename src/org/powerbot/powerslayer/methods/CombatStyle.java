package org.powerbot.powerslayer.methods;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CombatStyle {
    private Style[] style;
    private int[] maxHits;

    public CombatStyle(Style a, Style... style) {
        this.style = new Style[1 + style.length];
        this.style[0] = a;
        for (int i = 0; i < style.length; i++)
            this.style[i + 1] = style[0];
        maxHits = new int[this.style.length];
        Arrays.fill(maxHits, -1);
    }

    public CombatStyle(Object... objects) {
        Map<Style, Integer> styles = new HashMap<Style, Integer>();
        for (int i = 0; i < objects.length; i++) {
            if (i > 0 && objects[i] instanceof Integer
                    && objects[i - 1] instanceof Style) {
                styles.put((Style) objects[i - 1], (Integer) objects[i]);
            } else if (objects[i] instanceof Style) {
                styles.put((Style) objects[i], -1);
            }
        }
        this.style = new Style[styles.size()];
        this.maxHits = new int[styles.size()];
        Set<Style> keys = styles.keySet();
        int i = 0;
        for (Style s : keys) {
            this.style[i] = s;
            maxHits[i] = styles.get(s);
            i++;
        }
    }

    public Style getStyle(int tier) {
        if (tier < 0)
            return style[0];
        else if (tier >= style.length)
            return style[style.length - 1];
        else
            return style[tier];
    }

    public int getMaxHit(int tier) {
        if (tier < 0)
            return maxHits[0];
        else if (tier >= maxHits.length)
            return maxHits[maxHits.length - 1];
        else
            return maxHits[tier];
    }

    public boolean hasStyle(Style style) {
        for (Style s : this.style)
            if (s.equals(style))
                return true;
        return false;
    }

    public Style getStyle() {
        return getStyle(0);
    }

    public static enum Style {
        MELEE, MAGIC, RANGE, DRAGONFIRE, RANGED_DRAGONFIRE, MAGICAL_MELEE, MAGICAL_RANGE
    }
}