package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.rsbot.script.methods.tabs.Equipment.Slot;
import org.rsbot.script.methods.tabs.Inventory;
import org.rsbot.script.methods.ui.Camera;
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
	
	public static boolean use (NPC Monster) {
		String starterName = PowerSlayer.currentTask.getRequirements().getFinisher().getName();
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
