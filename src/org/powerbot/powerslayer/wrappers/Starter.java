package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.rsbot.script.methods.tabs.Equipment.Slot;
import org.rsbot.script.methods.tabs.Inventory;
import org.rsbot.script.methods.ui.Camera;
import org.rsbot.script.wrappers.Item;
import org.rsbot.script.wrappers.NPC;

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
	
	public static boolean use (NPC Monster) {
		String starterName = PowerSlayer.currentTask.getRequirements().getStarter().getName();
		if (Monster.equals(null) || Monster.isDead())
			return false;
		for (int i = 0; i < 28; i++) {
			Item currItem = Inventory.getItemAt(i);
			if (currItem.equals(null))
				continue;
			if (currItem.getName().equals(starterName)) {
				currItem.click(true);
				if (!Monster.isOnScreen())
					Camera.turnTo(Monster);
				if (Monster.isOnScreen())
					return Monster.interact("Use");
				return false;
			}
		}
		return false;
	}
}
