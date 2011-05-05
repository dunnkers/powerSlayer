package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.Monsters;

public class Task {
    private Monsters monster;

    private Task(Monsters monster) {
        this.monster = monster;
    }

    public Requirements getRequirements() {
        return monster.getRequirements();
    }

    public Monsters getMonster() {
        return monster;
    }

    public void setMonster(Monsters monster) {
        this.monster = monster;
    }
}