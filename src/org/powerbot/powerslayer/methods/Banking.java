package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.wrappers.Finisher;
import org.powerbot.powerslayer.wrappers.Starter;
import org.rsbot.script.methods.ui.Bank;
import org.rsbot.script.wrappers.Item;

public class Banking {

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
	
	public static boolean withdraw (SlayerEquipment equipment) {
		for (Item currItem: Bank.getItems()) {
			if (currItem.getName().equals(equipment.getName()))
				return Bank.withdraw(currItem.getID(), equipment.getAmount());
		}
		return false;
	}
	
	public static boolean withdraw (Starter start) {
		return withdraw(start.getSlayerEquipment());
	}
	
	public static boolean withdraw (Finisher finish) {
		return withdraw(finish.getSlayerEquipment());
	}
}
