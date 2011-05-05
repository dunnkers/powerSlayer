package org.powerbot.powerslayer.wrappers;

public class Item {
    private String[] names;
    private int amount;
    private int type;

    public final static int NOT_EQUIPED = 1;
    public final static int COULD_BE_EQUIPED = 2;
    public final static int NEEDS_TO_BE_EQUIPED = 3;

    public Item(int type, String[] names, int amount) {
        this.names = names;
        this.amount = amount;
        this.type = type;
    }

    public Item(String[] names) {
        this(1, names, 1);
    }

    public Item(String name) {
        this(1, new String[]{name}, 1);
    }

    public Item(int type, String name) {
        this(type, new String[]{name}, 1);
    }

    public Item(int type, String[] name) {
        this(type, name, 1);
    }

    public Item(String name, int amount) {
        this(1, new String[]{name}, amount);
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