package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.wrappers.Requirements;
import org.rsbot.script.methods.tabs.Equipment;
import org.rsbot.script.methods.tabs.Inventory;
import org.rsbot.script.wrappers.Item;

public class SlayerEquip {

	
	public static boolean equip(SlayerEquipment equip) {
		if (!equip.isEquipable())
			return false;
		for (Item item : Inventory.getItems()) {
			if (item.getName().equalsIgnoreCase(equip.getName())) {
				return Equipment.equip(item.getID());
			}
		}
		return false;
	}

	public static boolean isFullyEquipped(Requirements req) {
		for (SlayerEquipment currEquipment : req.getEquipment()) {
			if (!isEquipped(currEquipment)) {
				if (SlayerInventory.hasEnough(currEquipment)) {
					for (SlayerEquipment r : req.getEquipment()) {
						if (getReplacingItem(currEquipment).getName().equals(r.getName())) {
							return false;
						}

					}
					equip(currEquipment);
					if (!isEquipped(currEquipment)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	

	public static boolean isEquipped(SlayerEquipment item) {
		return Equipment.getItem(item.equipSlot()).getName().equals(item.getName());
	}
	
	public static Item getReplacingItem(SlayerEquipment item) {
		return Equipment.getItem(item.equipSlot());
	}

	
}
