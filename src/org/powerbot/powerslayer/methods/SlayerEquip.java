package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.rsbot.script.methods.tabs.Equipment;

public class SlayerEquip {
	public static boolean contains(SlayerEquipment equip) {
		return equip == null || Equipment.getItem(equip.equipSlot()).getName().equalsIgnoreCase(equip.getName());
	}
}
