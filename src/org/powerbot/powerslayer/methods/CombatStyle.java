package org.powerbot.powerslayer.methods;

public class CombatStyle
{
    private Style[] style;

    public CombatStyle(Style a, Style... style) {
        this.style = new Style[1 + style.length];
        this.style[0] = a;
        for (int i = 0; i < style.length; i++)
            this.style[i + 1] = style[0];
    }

    public Style getStyle(int tier) {
        if (tier < 0)
            return style[0];
        else if (tier >= style.length)
            return style[style.length - 1];
        else
            return style[tier];
    }

    public Style getStyle() {
        return getStyle(0);
    }

    public static enum Style
    {
        MELEE, MAGIC, RANGE
    }
}