package org.powerbot.powerslayer.data;

import org.rsbot.script.Script;
import org.rsbot.script.methods.Game;
import org.rsbot.script.methods.Interfaces;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.methods.tabs.Equipment;
import org.rsbot.script.wrappers.Interface;
import org.rsbot.script.wrappers.InterfaceComponent;

public class SlayerItems {
	static boolean elementalWorkshopIFinished = false, elementalWorkshopIIFinished = false, elementalWorkshopIIIFinished = false,
	elementalWorkshopIVFinished = false, pathOfGlouphrieFinished = false, smokingKillsFinished = false;
	int QUEST_INTERFACE = 190, HIDE_FINISHED_BUTTON = 12, QUEST_LIST = 18;
	int ELEMENTAL_WORKSHOP_I = 37, ELEMENTAL_WORKSHOP_II = 38,
	ELEMENTAL_WORKSHOP_III = 172, ELEMENTAL_WORKSHOP_IV = 180, PATH_OF_GLOUPHRIE = 127, SMOKING_KILLS = 138;
	int MOUSE_INTERFACE = 261, BUTTON_CHANGER = 6; 
	public static SlayerEquipment[] 
	slayerHelmets = {SlayerEquipment.Full_Slayer_Helmet_4charged5, SlayerEquipment.Full_Slayer_Helmet_4e5, SlayerEquipment.Full_Slayer_Helmet, 
		SlayerEquipment.Slayer_Helmet_4charged5, SlayerEquipment.Slayer_Helmet_4e5, SlayerEquipment.Slayer_Helmet},
	grassWeapons = {SlayerEquipment.LeafBladed_Spear, SlayerEquipment.LeafBladed_Sword, SlayerEquipment.Broad_Arrows, SlayerEquipment.BroadTipped_Bolts};
	
	public SlayerItems() {
		getQuestsFinished();
	}

	//TODO: Add in Chaos Shield, Gadderhammer, Keris, Balmung, and Cosmic Shield
	//TODO: Add in 2-handed Item support & Optional support
	public static enum SlayerEquipment {
		AntiDragon_Shield (-1, Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 0}, new int[] {1540, 1541, 8282, 16933, 16934}),
		Bag_Of_Salt (10, null, new int[] {Skills.SLAYER, 1}, new int[] {4161}),
		Body_Shield (-1, Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 33}, new int[] {18691, 18692}),
		BroadTipped_Bolts (-1, Equipment.Slot.AMMO, new int[] {Skills.SLAYER, 55, Skills.RANGE, 50}, new int[] {13280}),
		Broad_Arrows (90, Equipment.Slot.AMMO, new int[] {Skills.SLAYER, 55, Skills.RANGE, 50}, new int[] {4150, 4160, 4172, 4173, 4174, 4175}),
		Bullseye_Lantern (-1, null, new int[] {Skills.FIREMAKING, 49}, new int[] {4544, 4545, 4546, 4547, 4548, 4549, 4550}),
		Crystal_Chime (-1, null, new int[] {Skills.SLAYER, 1}, new int[] {11749}),
		Dragonfire_Shield (-1, Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 75}, new int[] {11283, 11284, 11285}),
		Earmuffs (200, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 15}, new int[] {4166, 4167}),
		Elemental_Shield (-1, Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 1}, new int[] {2890, 2891}),
		Enchanted_Gem (1, null, new int[] {Skills.SLAYER, 1}, new int[] {4155}),
		Face_Mask (200, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 10}, new int[] {4164, 4165}),
		Ferocious_Ring (-1, Equipment.Slot.RING, new int[] {Skills.SLAYER, 1}, new int[] {15398, 15399, 15400, 15401, 15402}),
		Fishing_Explosive (60, null, new int[] {Skills.SLAYER, 1}, new int[] {6660, 6664}),
		Full_Slayer_Helmet (-1, Equipment.Slot.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20}, new int[] {15492}),
		Full_Slayer_Helmet_4charged5 (-1, Equipment.Slot.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20, Skills.SUMMONING, 20}, new int[] {15497}),
		Full_Slayer_Helmet_4e5 (-1, Equipment.Slot.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20}, new int[] {15496}),
		Fungicide (10, null, new int[] {Skills.SLAYER, 1}, new int[] {7432}),
		Fungicide_Spray (300, null, new int[] {Skills.SLAYER, 57}, new int[] {7421, 7422, 7423, 7424, 7425, 7426, 7427, 7428, 7429, 7430, 7431}),
		Holy_Symbol (-1, Equipment.Slot.NECK, new int[] {Skills.SLAYER, 1}, new int[] {1718, 1719, 4682}),
		Ice_Cooler (1, null, new int[] {Skills.SLAYER, 1}, new int[] {6696}),
		Insulated_Boots (200, Equipment.Slot.FEET, new int[] {Skills.SLAYER, 37}, new int[] {7159, 7161}),
		LeafBladed_Spear (31000, Equipment.Slot.WEAPON /*+ Equipment.Slot.SHIELD*/, new int[] {Skills.SLAYER, 55, Skills.ATTACK, 50}, new int[] {4158, 4159}),
		LeafBladed_Sword (-1, Equipment.Slot.WEAPON, new int[] {Skills.SLAYER, 55, Skills.ATTACK, 50}, new int[] {13290, 13291}),
		Lit_Bug_Lantern (200, Equipment.Slot.SHIELD, new int[] {Skills.SLAYER, 33}, new int[] {7052, 7053}),
		Masked_Earmuffs (-1, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 1}, new int[] {13277}),
		Mind_Shield (-1, Equipment.Slot.SHIELD, new int[] {Skills.DEFENSE, 1}, new int[] {9731, 9732}),
		Mirror_Shield (5000, Equipment.Slot.SHIELD, new int[] {Skills.SLAYER, 15, Skills.DEFENSE, 20}, new int[] {4156, 4157}),
		Nosepeg (200, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 60}, new int[] {4168, 4169}),
		Rock_Hammer (500, null, new int[] {Skills.SLAYER, 1}, new int[] {4162, 4163}),
		Rope (-1, null, new int[] {Skills.SLAYER, 1}, new int[] {954}),
		Seers_Headband (-1, null, new int[] {Skills.SLAYER, 1}, new int[] {14631, 14662, 14663}),
		Slayer_Bell (150, null, new int[] {Skills.SLAYER, 30}, new int[] {10952, 10953}),
		Slayer_Gloves (200, Equipment.Slot.HANDS, new int[] {Skills.SLAYER, 17}, new int[] {6708, 6720}),
		Slayer_Helmet (-1, Equipment.Slot.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {13263}),
		Slayer_Helmet_4charged5 (-1, Equipment.Slot.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {14637}),
		Slayer_Helmet_4e5 (-1, Equipment.Slot.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {14636}),
		Slayer_Staff (21000, Equipment.Slot.WEAPON, new int[] {Skills.SLAYER, 55, Skills.MAGIC, 50}, new int[] {4170, 4171}),
		Spiked_Helmet (-1, Equipment.Slot.HELMET, new int[] {Skills.DEFENSE, 5}, new int[] {13105, 13106, 13168}),
		Spiny_Helmet (650, Equipment.Slot.HELMET, new int[] {Skills.SLAYER, 1, Skills.DEFENSE, 5}, new int[] {4551, 4552}),
		Super_Fishing_Explosive (-1, null, new int[] {Skills.SLAYER, 32}, new int[] {12633}),
		Tinderbox (-1, null, new int[] {Skills.SLAYER, 1}, new int[] {590}),
		Unlit_Bug_Lantern (200, Equipment.Slot.SHIELD, new int[] {Skills.SLAYER, 33}, new int[] {7051}),
		Water_Skin (-1, null, new int[] {Skills.SLAYER, 1}, new int[] {1823, 1825, 1827, 1829, 1831}),
		Witchwood_Icon (900, Equipment.Slot.NECK, new int[] {Skills.SLAYER, 58}, new int[] {8923});

		int itemCost = -1;
		Equipment.Slot slot = null;
		int [] requirements = {-1};
		int[] IDs;
		int amount = 1;


		SlayerEquipment (int Cost, Equipment.Slot Slot, int[] Requirements, int[] IDList) {
			itemCost = Cost;
			requirements = Requirements;
			slot = Slot;
			IDs = IDList;
		}

		SlayerEquipment (SlayerEquipment equipmentEnum) {
			if (equipmentEnum != null) {
				itemCost = equipmentEnum.itemCost;
				requirements = equipmentEnum.requirements;
				slot = equipmentEnum.slot;
				IDs = equipmentEnum.IDs;
			}
		}

		SlayerEquipment (SlayerEquipment equipmentEnum, int Amount) {
			if (equipmentEnum != null) {
				itemCost = equipmentEnum.itemCost;
				requirements = equipmentEnum.requirements;
				slot = equipmentEnum.slot;
				IDs = equipmentEnum.IDs;
				amount = Amount;
			}
		}

		SlayerEquipment (int itemID) {
			this(get(itemID));
		}

		SlayerEquipment (String itemName) {
			this(get(itemName));
		}


		public boolean availableAtMaster() {
			return itemCost != -1;
		}

		public Equipment.Slot equipSlot() {
			return slot;
		}

		public int getAmount() {
			return amount;
		}

		public int getCost() {
			return itemCost;
		}


		public int[] getIDs() {
			return IDs;
		}

		public String getName() {
			String enumString = this.toString();
			StringBuilder t = new StringBuilder();
			boolean upperCase = true;
			boolean lastUpperCase;
			for (char currChar: enumString.toCharArray()) {
				lastUpperCase = upperCase;
				if (currChar == '_') {
					t.append (" ");
					upperCase = false;
					continue;
				}
				if (currChar == '4') {
					t.append ("(");
					upperCase = false;
					continue;
				}
				if (currChar == '5') {
					t.append (")");
					upperCase = false;
					continue;
				}
				upperCase = Character.isUpperCase(currChar);
				if (upperCase && upperCase != lastUpperCase) 
					t.append("-");
				t.append(currChar);
			}
			return t.toString();
		}

		public boolean isEquipable() {
			return isUsable() && slot != null;
		}

		public boolean isUsable() {
			int length = requirements.length;
			if (length % 2 != 0)
				return false;
			SlayerEquipment current = this;
			if (current.equals(Crystal_Chime))
				return pathOfGlouphrieFinished;
			if (current.equals(Elemental_Shield))
				return elementalWorkshopIFinished;
			if (current.equals(Masked_Earmuffs) || current.getName().contains("Slayer Helmet")) {
				if (!smokingKillsFinished)
					return false;
			} else if (current.equals(Mind_Shield)) {
				return false;
			} else if (current.equals(Body_Shield)) {
				if (!elementalWorkshopIIFinished) 
					return false;
			}
			for (int i = 0; i < length; i += 2) {
				if (Skills.getLevel(requirements[i]) < requirements[i + 1])
					return false;
			}
			return true;
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

	private void checkMouseButtons() {
		Interface mouse = Interfaces.get(MOUSE_INTERFACE);
		InterfaceComponent mouseButtons;
		if (mouse != null) {
			mouseButtons = mouse.getComponent(BUTTON_CHANGER);
			if (mouseButtons.getTextureID() == 762) 
				return;
		}
		for (int i = 0; i < 6; i++) {
			Game.openTab(Game.Tabs.OPTIONS);
			Script.sleep (600);
			if (!Game.isLoggedIn())  
				return;
			if (Game.getCurrentTab().equals(Game.Tabs.OPTIONS))
				break;
			if (i == 5) 
				return;
		}
		mouse = Interfaces.get(MOUSE_INTERFACE);
		if (mouse != null) {
			mouseButtons = mouse.getComponent(BUTTON_CHANGER);
			if (mouseButtons.getTextureID() != 762) {
				for (int i = 0; i < 5; i++) {
					mouseButtons.click();
					Script.sleep (1000);
					if (!Game.isLoggedIn())  
						return;
					if (Interfaces.get(QUEST_INTERFACE).getComponent(HIDE_FINISHED_BUTTON).getTextureID() == 699)
						break;
				}
			}
		}
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

	private void getQuestsFinished() {
		checkMouseButtons();
		Interface quests = Interfaces.get(QUEST_INTERFACE);
		InterfaceComponent hideButton, questList;
		if (quests != null) {
			hideButton = quests.getComponent(HIDE_FINISHED_BUTTON);
			if (hideButton.getTextureID() == 699) {
				questList = quests.getComponent(QUEST_LIST);
				elementalWorkshopIFinished = questList.getComponent(ELEMENTAL_WORKSHOP_I).getRelativeX() == 0;
				elementalWorkshopIIFinished = questList.getComponent(ELEMENTAL_WORKSHOP_II).getRelativeX() == 0;
				elementalWorkshopIIIFinished = questList.getComponent(ELEMENTAL_WORKSHOP_III).getRelativeX() == 0;
				elementalWorkshopIVFinished = questList.getComponent(ELEMENTAL_WORKSHOP_IV).getRelativeX() == 0;
				pathOfGlouphrieFinished = questList.getComponent(PATH_OF_GLOUPHRIE).getRelativeX() == 0;
				smokingKillsFinished = questList.getComponent(SMOKING_KILLS).getRelativeX() == 0;
				return;
			}
		}
		for (int i = 0; i < 6; i++) {
			Game.openTab(Game.Tabs.QUESTS);
			Script.sleep (600);
			if (!Game.isLoggedIn())  
				return;
			if (Game.getCurrentTab().equals(Game.Tabs.QUESTS))
				break;
			if (i == 5) 
				return;
		}
		quests = Interfaces.get(QUEST_INTERFACE);
		if (quests != null) {
			hideButton = quests.getComponent(HIDE_FINISHED_BUTTON);
			if (hideButton.getTextureID() != 699) {
				for (int i = 0; i < 5; i++) {
					hideButton.click();
					Script.sleep (1000);
					if (!Game.isLoggedIn())  
						return;
					if (Interfaces.get(QUEST_INTERFACE).getComponent(HIDE_FINISHED_BUTTON).getTextureID() == 699)
						break;
				}
			}
			if (Interfaces.get(QUEST_INTERFACE).getComponent(HIDE_FINISHED_BUTTON).getTextureID() == 699) {
				questList = Interfaces.get(QUEST_INTERFACE).getComponent(QUEST_LIST);
				elementalWorkshopIFinished = questList.getComponent(ELEMENTAL_WORKSHOP_I).getRelativeX() == 0;
				elementalWorkshopIIFinished = questList.getComponent(ELEMENTAL_WORKSHOP_II).getRelativeX() == 0;
				elementalWorkshopIIIFinished = questList.getComponent(ELEMENTAL_WORKSHOP_III).getRelativeX() == 0;
				elementalWorkshopIVFinished = questList.getComponent(ELEMENTAL_WORKSHOP_IV).getRelativeX() == 0;
				pathOfGlouphrieFinished = questList.getComponent(PATH_OF_GLOUPHRIE).getRelativeX() == 0;
				smokingKillsFinished = questList.getComponent(SMOKING_KILLS).getRelativeX() == 0;
			}
		}
	}
}
