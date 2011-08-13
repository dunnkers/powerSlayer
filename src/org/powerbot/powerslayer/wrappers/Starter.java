package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;

public class Starter extends SlayerItem {
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
    
    public int amount() {
		return amount;
	}
	
	public boolean availableAtMaster() {
		return starter.availableAtMaster();
	}
	
	public int cost() {
		return starter.cost();
	}
	
	public boolean equipable() {
		return starter.equipable();
	}
	
	public int equipSlot() {
		return starter.equipSlot();
	}
	
	public int[] iDs() {
		return starter.iDs();
	}
	
	public String name() {
		return starter.getName();
	}
	
	public boolean usable() {
		return starter.usable();
	}
}
