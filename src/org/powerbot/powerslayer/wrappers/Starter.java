package org.powerbot.powerslayer.wrappers;

public class Starter extends Item {
    public Starter(int amount, String... names) {
        super(Item.COULD_BE_EQUIPPED, amount, names);
    }

    public Starter(String... names) {
        super(names);
    }
}
