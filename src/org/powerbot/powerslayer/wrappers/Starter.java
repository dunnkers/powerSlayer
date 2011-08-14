package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;

public class Starter {
	//TODO: Add methods
	String[] itemNames;
	SlayerEquipment starter;
	int amount = 1;
	
	
    public Starter (SlayerEquipment equipment, int Amount) {
    	starter = equipment;
    	amount = Amount;
    }

    public Starter(SlayerEquipment equipment) {
        this (equipment, 1);
    }
    
    public String[] getNames() {
    	return itemNames;
    }
    
    public int getAmount() {
		return amount;
	}
	
	public boolean availableAtMaster() {
		return starter.availableAtMaster();
	}
	
	public int getCost() {
		return starter.getCost();
	}
	
	public boolean isEquipable() {
		return starter.isEquipable();
	}
	
	public int equipSlot() {
		return starter.equipSlot();
	}
	
	public int[] getIDs() {
		return starter.getIDs();
	}
	
	public String getName() {
		return starter.getName();
	}
	
	public boolean isUsable() {
		return starter.isUsable();
	}
}
