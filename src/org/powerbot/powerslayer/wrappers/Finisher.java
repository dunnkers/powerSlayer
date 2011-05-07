package org.powerbot.powerslayer.wrappers;

public class Finisher extends Item {
	public Finisher(int amount, String... names) {
		super(Item.COULD_BE_EQUIPPED, amount, names);
	}

	public Finisher(String... names) {
		super(names);
	}
}
