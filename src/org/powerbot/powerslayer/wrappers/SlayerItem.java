package org.powerbot.powerslayer.wrappers;

public class SlayerItem {
    private String[] names;
    private int amount;
    private int type;

    public final static int NOT_EQUIPPED = 1;
    public final static int COULD_BE_EQUIPPED = 2;
    public final static int NEEDS_TO_BE_EQUIPPED = 3;

    public SlayerItem(int type, int amount, String... names) {
        this.names = names;
        this.amount = amount;
        this.type = type;
    }

    public SlayerItem(String... names) {
        this(COULD_BE_EQUIPPED, 1, names);
    }

    public SlayerItem(int type, String... name) {
        this(type, 1, name);
    }

    public int getAmount() {
        return this.amount;
    }

    public int getType() {
        return this.type;
    }

    public String[] getNames() {
        return this.names;
    }
}