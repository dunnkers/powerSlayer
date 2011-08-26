package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.wrappers.Finisher;
import org.powerbot.powerslayer.wrappers.Requirements;
import org.powerbot.powerslayer.wrappers.Starter;
import org.rsbot.script.methods.tabs.Inventory;
import org.rsbot.script.wrappers.Item;

public class SlayerInventory {

	public static boolean contains(SlayerEquipment equipment) {
		for (Item currItem: Inventory.getItems()) {
			if (currItem.getName().equalsIgnoreCase(equipment.getName()));
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
	private int inventSpace() {
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
}
