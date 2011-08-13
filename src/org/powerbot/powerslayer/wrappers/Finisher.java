package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;

public class Finisher {
	//TODO: Add methods :D
	SlayerEquipment finisher;
	int amount = 1;
	
    public Finisher(SlayerEquipment equipment, int Amount) {
        finisher = equipment;
        amount = Amount;
    }

    public Finisher(SlayerEquipment equipment) {
        this (equipment, 1);
    }
    
    public int amount() {
		return amount;
	}
	
	public boolean availableAtMaster() {
		return finisher.availableAtMaster();
	}
	
	public int cost() {
		return finisher.cost();
	}
	
	public boolean equipable() {
		return finisher.equipable();
	}
	
	public int equipSlot() {
		return finisher.equipSlot();
	}
	
	public int[] iDs() {
		return finisher.iDs();
	}
	
	public String name() {
		return finisher.getName();
	}
	
	public boolean usable() {
		return finisher.usable();
	}
}
