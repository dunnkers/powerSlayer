package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.rsbot.script.methods.tabs.Equipment.Slot;

public class Starter {
	//TODO: Add methods
	SlayerEquipment starter;
	int amount = 1;
	
	
    public Starter (SlayerEquipment equipment, int Amount) {
    	starter = equipment;
    	amount = Amount;
    }

    public Starter(SlayerEquipment equipment) {
        this (equipment, 1);
    }
	
	public boolean availableAtMaster() {
		return starter.availableAtMaster();
	}
	
	public boolean canEquip() {
		return starter.isEquipable();
	}
	
	public Slot equipSlot() {
		return starter.equipSlot();
	}
    
    public int getAmount() {
		return amount;
	}
	
	public int getCost() {
		return starter.getCost();
	}
	
	public int[] getIDs() {
		return starter.getIDs();
	}
	
	public String getName() {
		return starter.getName();
	}
    
    public SlayerEquipment getSlayerEquipment() {
    	return starter;
    }
	
	public boolean isUsable() {
		return starter.isUsable();
	}
}
