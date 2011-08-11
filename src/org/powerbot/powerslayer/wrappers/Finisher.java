package org.powerbot.powerslayer.wrappers;

public class Finisher extends SlayerItem {
    public Finisher(int amount, String... names) {
        super(SlayerItem.COULD_BE_EQUIPPED, amount, names);
    }

    public Finisher(String... names) {
        super(names);
    }
}
