package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.rsbot.script.methods.Camera;
import org.rsbot.script.methods.tabs.Inventory;
import org.rsbot.script.methods.tabs.Equipment.Slot;
import org.rsbot.script.wrappers.Item;
import org.rsbot.script.wrappers.NPC;

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
    
	public boolean availableAtMaster() {
		return finisher.availableAtMaster();
	}
	
	public boolean canEquip() {
		return finisher.isEquipable();
	}
	
	public Slot equipSlot() {
		return finisher.equipSlot();
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getCost() {
		return finisher.getCost();
	}
	
	public int[] getIDs() {
		return finisher.getIDs();
	}
	
	public String getName() {
		return finisher.getName();
	}
	
	public SlayerEquipment getSlayerEquipment() {
		return finisher;
	}
	
	public boolean isUsable() {
		return finisher.isUsable();
	}
	
	public boolean use (NPC Monster) {
		String s = PowerSlayer.currentTask.getRequirements().getStarter().getName();
    	for (Item inventItem : Inventory.getItems()) {
    		if (s.equalsIgnoreCase(inventItem.getName())) {
    			if (Inventory.getItem(inventItem.getID()).click(true)) {
    				if (Monster != null) {
    					if (!Monster.isOnScreen()) {
    						Camera.turnTo(Monster);
    					}
    					if (Monster.isOnScreen()) {
    						return Monster.interact("Use");
    					}
    				}
    			}
    		}
    	}
    	return false;
	}
}
