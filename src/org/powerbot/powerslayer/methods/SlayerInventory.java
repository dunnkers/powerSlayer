package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.wrappers.Finisher;
import org.powerbot.powerslayer.wrappers.Requirements;
import org.powerbot.powerslayer.wrappers.Starter;
import org.rsbot.script.Script;
import org.rsbot.script.methods.tabs.Inventory;
import org.rsbot.script.wrappers.Item;

public class SlayerInventory {

	public static boolean containsAllEquipment() {
        for (SlayerEquipment i : PowerSlayer.currentTask.getRequirements().getEquipment()) {
            if (!hasEnough(i)) {
                return false;
            }
        }
        return true;
    }
	
	public static boolean contains(SlayerEquipment equipment) {
		for (Item currItem: Inventory.getItems()) {
			if (currItem.getName().equalsIgnoreCase(equipment.getName()))
			   return true;
		}
		return false;
	}
	
	public static boolean contains(Finisher finisher) {
		return contains(finisher.getSlayerEquipment());
	}
	
	public static boolean contains(Starter starter) {
		return contains(starter.getSlayerEquipment());
	}
	
	public static boolean hasEnough(SlayerEquipment items) {
		return Inventory.getCount(true, items.getIDs()) >= items.getAmount();
	}

	public static boolean hasEnough(Finisher fin) {
		return hasEnough(fin.getSlayerEquipment());
	}

	public static boolean hasEnough(Starter start) {
		return hasEnough(start.getSlayerEquipment());
	}
	
	public static boolean inventReady(Requirements req) {
		for (SlayerEquipment i : req.getEquipment()) {
			if (!contains(i)) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unused")
	private static int inventSpace() {
		return 28 - Inventory.getCount();
	}
	
	public static boolean performAction(SlayerEquipment items, String action) {
		for (Item item : Inventory.getItems()) {
			if (item.getName().equalsIgnoreCase(items.getName())) {
				return item.interact(action);
			}
		}
		return false;
	}
	
	public static boolean waitForInvChange(int threshold) {
		int origCount = Inventory.getCount();
		for (int i = 0; i < ((threshold/50) + 1); i++) {
			if (origCount != Inventory.getCount())
				return true;
			Script.sleep (50);
		}
		return false;
    }
	
	public static boolean waitForInvChange(int origCount, int threshold) {
		for (int i = 0; i < ((threshold/50) + 1); i++) {
			if (origCount != Inventory.getCount())
				return true;
			Script.sleep (50);
		}
		return false;
    }
}
