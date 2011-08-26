package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.wrappers.Finisher;
import org.powerbot.powerslayer.wrappers.Starter;
import org.rsbot.script.methods.ui.Bank;
import org.rsbot.script.wrappers.Item;

public class SlayerBank {

	public static boolean isInBank(SlayerEquipment equipment) {
		for (Item item : Bank.getItems()) {
			if (item.getName().equalsIgnoreCase(equipment.getName())) {
				return true;
			}
		}
		return false;
	}

	public static boolean isInBank(Finisher fin) {
		return isInBank(fin.getSlayerEquipment());
	}

	public static boolean isInBank(Starter start) {
		return isInBank(start.getSlayerEquipment());
	}
}
