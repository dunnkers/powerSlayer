package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.Monsters;

public class Task {
    private Monsters monster;

    private Task(Monsters monster) {
        this.monster = monster;
    }

    public Requirements getRequirements() {
	    //TODO: Convert over to both locationProfile and monster requirements
        return monster.getRequirements();
    }

    public Monsters getMonster() {
        return monster;
    }
}