package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.Monster;
import org.powerbot.powerslayer.data.SlayerMaster;

public class Task {
    private Monster monster;
	private int amount;
	private SlayerMaster master;

    public Task(Monster monster, int amount, SlayerMaster master) {
        this.monster = monster;
	    this.amount = amount;
	    this.master = master;
    }

    public Requirements getRequirements() {
	    //TODO: Convert over to both locationProfile and monster requirements
        return monster.getRequirements();
    }

    public Monster getMonster() {
        return monster;
    }
}