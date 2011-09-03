package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.Monsters.Monster;
import org.powerbot.powerslayer.data.Monsters.MonsterGroup;
import org.powerbot.powerslayer.data.SlayerMaster;

public class Task {
    private Monster monster;
	private MonsterGroup monsterGroup;
	private int amount;
	private SlayerMaster master;

    public Task(Monster monster, int amount, SlayerMaster master) {
        this.monster = monster;
	    this.monsterGroup = MonsterGroup.NULL;
	    this.amount = amount;
	    this.master = master;
    }

	public Task(MonsterGroup monsterGroup, int amount, SlayerMaster master) {
		this.monster = monsterGroup.getBestMonster();
		this.monsterGroup = monsterGroup;
		this.amount = amount;
		this.master = master;
	}

    
    public int getAmount() {
    	return amount;
    }
    
    public SlayerMaster getMaster() {
    	return master;
    }

    public Monster getMonster() {
        return monster;
    }

    public Requirements getRequirements() {
        return monster.getRequirements();
    }
}