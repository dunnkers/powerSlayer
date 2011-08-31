package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.data.Quests.Quest;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.methods.tabs.Equipment;

public class SlayerItems {

	public static SlayerEquipment[] 
	slayerHelmets = {
		SlayerEquipment.Full_Slayer_Helmet_4charged5, SlayerEquipment.Full_Slayer_Helmet_4e5, SlayerEquipment.Full_Slayer_Helmet, 
		SlayerEquipment.Slayer_Helmet_4charged5, SlayerEquipment.Slayer_Helmet_4e5, SlayerEquipment.Slayer_Helmet
	},
	grassWeapons = {
		SlayerEquipment.LeafBladed_Spear, SlayerEquipment.LeafBladed_Sword, SlayerEquipment.Broad_Arrows, SlayerEquipment.BroadTipped_Bolts
	};

	//TODO: Add in Chaos Shield, Gadderhammer, Keris, Balmung, and Cosmic Shield
	//TODO: Add in 2-handed Item support & Optional support
	public static enum SlayerEquipment {
		AntiDragon_Shield (Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 0}, new int[] {1540, 1541, 8282, 16933, 16934}),
		Bag_Of_Salt (10, null, new int[] {Skills.SLAYER, 1}, new int[] {4161}),
		Body_Shield (Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 33}, new int[] {18691, 18692}, Quest.ELEMENTAL_WORKSHOP_III),
		BroadTipped_Bolts (Equipment.Slot.AMMO, new int[] {Skills.SLAYER, 55, Skills.RANGE, 50}, new int[] {13280}),
		Broad_Arrows (90, Equipment.Slot.AMMO, new int[] {Skills.SLAYER, 55, Skills.RANGE, 50}, new int[] {4150, 4160, 4172, 4173, 4174, 4175}),
		Bullseye_Lantern (null, new int[] {Skills.FIREMAKING, 49}, new int[] {4544, 4545, 4546, 4547, 4548, 4549, 4550}),
		Crystal_Chime (null, new int[] {Skills.SLAYER, 1}, new int[] {11749}, Quest.THE_PATH_OF_GLOUPHRIE),
		Dragonfire_Shield (Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 75}, new int[] {11283, 11284, 11285}),
		Earmuffs (200, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 15}, new int[] {4166, 4167}),
		Elemental_Shield (Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 1}, new int[] {2890, 2891}, Quest.ELEMENTAL_WORKSHOP_I),
		Enchanted_Gem (1, null, new int[] {Skills.SLAYER, 1}, new int[] {4155}),
		Face_Mask (200, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 10}, new int[] {4164, 4165}),
		Ferocious_Ring (Equipment.Slot.RING, new int[] {Skills.SLAYER, 1}, new int[] {15398, 15399, 15400, 15401, 15402}),
		Fishing_Explosive (60, null, new int[] {Skills.SLAYER, 1}, new int[] {6660, 6664}),
		Full_Slayer_Helmet (Equipment.Slot.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20}, new int[] {15492}, Quest.SMOKING_KILLS),
		Full_Slayer_Helmet_4charged5 (Equipment.Slot.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20, Skills.SUMMONING, 20}, new int[] {15497}, Quest.SMOKING_KILLS),
		Full_Slayer_Helmet_4e5 (Equipment.Slot.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20}, new int[] {15496}, Quest.SMOKING_KILLS),
		Fungicide (10, null, new int[] {Skills.SLAYER, 1}, new int[] {7432}),
		Fungicide_Spray (300, null, new int[] {Skills.SLAYER, 57}, new int[] {7421, 7422, 7423, 7424, 7425, 7426, 7427, 7428, 7429, 7430, 7431}),
		Holy_Symbol (Equipment.Slot.NECK, new int[] {Skills.SLAYER, 1}, new int[] {1718, 1719, 4682}),
		Ice_Cooler (1, null, new int[] {Skills.SLAYER, 1}, new int[] {6696}),
		Insulated_Boots (200, Equipment.Slot.FEET, new int[] {Skills.SLAYER, 37}, new int[] {7159, 7161}),
		LeafBladed_Spear (31000, Equipment.Slot.WEAPON /*+ Equipment.Slot.SHIELD*/, new int[] {Skills.SLAYER, 55, Skills.ATTACK, 50}, new int[] {4158, 4159}),
		LeafBladed_Sword (Equipment.Slot.WEAPON, new int[] {Skills.SLAYER, 55, Skills.ATTACK, 50}, new int[] {13290, 13291}),
		Lit_Bug_Lantern (200, Equipment.Slot.SHIELD, new int[] {Skills.SLAYER, 33}, new int[] {7052, 7053}),
		Masked_Earmuffs (Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 1}, new int[] {13277}, Quest.SMOKING_KILLS),
		Mind_Shield (Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 1}, new int[] {9731, 9732}, Quest.ELEMENTAL_WORKSHOP_II),
		Mirror_Shield (5000, Equipment.Slot.SHIELD, new int[] {Skills.SLAYER, 15, Skills.DEFENSE, 20}, new int[] {4156, 4157}),
		Nosepeg (200, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 60}, new int[] {4168, 4169}),
		Rock_Hammer (500, null, new int[] {Skills.SLAYER, 1}, new int[] {4162, 4163}),
		Rope (null, new int[] {Skills.SLAYER, 1}, new int[] {954}),
		Seers_Headband (null, new int[] {Skills.SLAYER, 1}, new int[] {14631, 14662, 14663}),
		Slayer_Bell (150, null, new int[] {Skills.SLAYER, 30}, new int[] {10952, 10953}),
		Slayer_Gloves (200, Equipment.Slot.HANDS, new int[] {Skills.SLAYER, 17}, new int[] {6708, 6720}),
		Slayer_Helmet (Equipment.Slot.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {13263}, Quest.SMOKING_KILLS),
		Slayer_Helmet_4charged5 (Equipment.Slot.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {14637}, Quest.SMOKING_KILLS),
		Slayer_Helmet_4e5 (Equipment.Slot.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {14636}, Quest.SMOKING_KILLS),
		Slayer_Staff (21000, Equipment.Slot.WEAPON, new int[] {Skills.SLAYER, 55, Skills.MAGIC, 50}, new int[] {4170, 4171}),
		Spiked_Helmet (Equipment.Slot.HELMET, new int[] {Skills.DEFENSE, 5}, new int[] {13105, 13106, 13168}),
		Spiny_Helmet (650, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 1, Skills.DEFENSE, 5}, new int[] {4551, 4552}),
		Super_Fishing_Explosive (null, new int[] {Skills.SLAYER, 32}, new int[] {12633}),
		Tinderbox (null, new int[] {Skills.SLAYER, 1}, new int[] {590}),
		Unlit_Bug_Lantern (200, Equipment.Slot.SHIELD, new int[] {Skills.SLAYER, 33}, new int[] {7051}),
		Water_Skin (null, new int[] {Skills.SLAYER, 1}, new int[] {1823, 1825, 1827, 1829, 1831}),
		Witchwood_Icon (900, Equipment.Slot.NECK, new int[] {Skills.SLAYER, 58}, new int[] {8923});

		private final int price;
		private final Equipment.Slot slot;
		private final int [] requirements;
		private final int[] itemIDs;
		private final int amount = 1;
		private final Quest[] quests;

		SlayerEquipment (Equipment.Slot slot, int[] skillRequirements, int[] itemIDs, Quest... quests) {
			this(-1, slot, skillRequirements, itemIDs, quests);
		}

		SlayerEquipment (int price, Equipment.Slot slot, int[] skillRequirements, int[] itemIDs, Quest... quests) {
			this.price = price;
			this.slot = slot;
			this.requirements = skillRequirements;
			this.itemIDs = itemIDs;
			this.quests = quests;
		}

		public boolean availableAtMaster() {
			return price != -1;
		}

		public Equipment.Slot equipSlot() {
			return slot;
		}

		public int getAmount() {
			return amount;
		}

		public int getCost() {
			return price;
		}

		public int[] getIDs() {
			return itemIDs;
		}

		public String getName() {
			String name = this.name().replaceAll("_", " ").replaceAll("4", "(").replaceAll("5", ")");
			StringBuilder output = new StringBuilder();
			boolean upperCase = true;
			boolean lastUpperCase;
			for (char currChar: name.toCharArray()) {
				lastUpperCase = upperCase;
				upperCase = Character.isUpperCase(currChar);
				if (upperCase && !lastUpperCase) 
					output.append("-");
				output.append(currChar);
			}
			return output.toString();
		}

		public boolean isEquipable() {
			return slot != null && isUsable();
		}

		public boolean isUsable() {
			int length = requirements.length;
			if (length % 2 != 0) {
				return false;
			}
			for (int i = 0; i < length; i += 2) {
				if (Skills.getLevel(requirements[i]) < requirements[i + 1])
					return false;
			}
			return Quests.isQuestCompleted(quests);
		}
	}

	//TODO: Update to cover Earmuffs and shit
	private static SlayerEquipment[] checkGroups(SlayerEquipment currEquip) {
		// TODO Auto-generated method stub
		String equipment = currEquip.getName();
		if (equipment.contains("Helmet"))
			return slayerHelmets;
		if (equipment.contains("Broad") || equipment.contains("Grass"))
			return grassWeapons;
		return new SlayerEquipment[] {get(equipment)};
	}

	
	public static SlayerEquipment get(int itemID) {
		for (SlayerEquipment currEquip: getAll()) {
			for (int currInt: currEquip.getIDs()) {
				if (currInt == itemID)
					return currEquip;
			}
		}
		return null;
	}

	public static SlayerEquipment get(String itemName) {
		for (SlayerEquipment currEquip: getAll()) {
			if (itemName.equalsIgnoreCase(currEquip.getName()))
				return currEquip;
		}
		return null;
	}

	public static SlayerEquipment[] getAll() {
		return SlayerEquipment.values();
	}

	public static SlayerEquipment[] getAllValid(int itemID) {
		for (SlayerEquipment currEquip: getAll()) {
			for (int currInt: currEquip.getIDs())
				if (currInt == itemID) 
					return checkGroups(currEquip);
		}
		return null;
	}

	public static SlayerEquipment[] getAllValid(String itemName) {
		for (SlayerEquipment currEquip: getAll()) {
			if (currEquip.getName().equals(itemName)) 
				return checkGroups(currEquip);
		}
		return null;
	}

}
