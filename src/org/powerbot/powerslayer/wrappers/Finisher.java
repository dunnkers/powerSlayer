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
    
    public int getAmount() {
		return amount;
	}
	
	public boolean availableAtMaster() {
		return finisher.availableAtMaster();
	}
	
	public int getCost() {
		return finisher.getCost();
	}
	
	public boolean isEquipable() {
		return finisher.isEquipable();
	}
	
	public int equipSlot() {
		return finisher.equipSlot();
	}
	
	public int[] getIDs() {
		return finisher.getIDs();
	}
	
	public String getName() {
		return finisher.getName();
	}
	
	public boolean isUsable() {
		return finisher.isUsable();
	}
}
