package org.powerbot.powerslayer.data;

import org.rsbot.script.Script;
import org.rsbot.script.methods.Equipment;
import org.rsbot.script.methods.Game;
import org.rsbot.script.methods.Interfaces;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.Interface;
import org.rsbot.script.wrappers.InterfaceComponent;

public class SlayerItems {
	static SlayerEquipment[] slayerEquipment = slayerEquipmentArray();
	static boolean elementalWorkshopIFinished = false, elementalWorkshopIIFinished = false, elementalWorkshopIIIFinished = false,
		elementalWorkshopIVFinished = false, pathOfGlouphrieFinished = false, smokingKillsFinished = false;
	int QUEST_INTERFACE = 190, HIDE_FINISHED_BUTTON = 12, QUEST_LIST = 18;
	int ELEMENTAL_WORKSHOP_I = 37, ELEMENTAL_WORKSHOP_II = 38,
		ELEMENTAL_WORKSHOP_III = 172, ELEMENTAL_WORKSHOP_IV = 180, PATH_OF_GLOUPHRIE = 127, SMOKING_KILLS = 138;
	int MOUSE_INTERFACE = 261, BUTTON_CHANGER = 6; 
	public static SlayerEquipment[] slayerHelmets = {SlayerEquipment.Full_Slayer_Helmet4charged5, SlayerEquipment.Full_Slayer_Helmet4e5, SlayerEquipment.Full_Slayer_Helmet, 
			SlayerEquipment.Slayer_Helmet_4charged5, SlayerEquipment.Slayer_Helmet_4e5, SlayerEquipment.Slayer_Helmet};
	
	public SlayerItems() {
		slayerEquipment = slayerEquipmentArray();
		getQuestsFinished();
	}
	
	//TODO: Add in Chaos Shield and Cosmic Shield
	public static enum SlayerEquipment {
		AntiDragon_Shield (-1, Equipment.SHIELD, new int[] {Skills.DEFENSE, 0}, new int[] {1540, 1541, 8282, 16933, 16934}),
		Bag_Of_Salt (10, -1, new int[] {Skills.SLAYER, 1}, new int[] {4161}),
		Body_Shield (-1, Equipment.SHIELD, new int[] {Skills.DEFENSE, 33}, new int[] {18691, 18692}),
		BroadTipped_Bolts (-1, 38, new int[] {Skills.SLAYER, 55, Skills.RANGE, 50}, new int[] {13280}),
		Broad_Arrows (90, Equipment.AMMO, new int[] {Skills.SLAYER, 55, Skills.RANGE, 50}, new int[] {4150, 4160, 4172, 4173, 4174, 4175}),
		Bullseye_Lantern (-1, -1, new int[] {Skills.FIREMAKING, 49}, new int[] {4544, 4545, 4546, 4547, 4548, 4549, 4550}),
		Crystal_Chime (-1, -1, new int[] {Skills.SLAYER, 1}, new int[] {11749}),
		Dragonfire_Shield (-1, Equipment.SHIELD, new int[] {Skills.DEFENSE, 75}, new int[] {11283, 11284, 11285}),
		Earmuffs (200, Equipment.HELMET, new int[] {Skills.SLAYER, 15}, new int[] {4166, 4167}),
		Elemental_Shield (-1, Equipment.SHIELD, new int[] {Skills.DEFENSE, 1}, new int[] {2890, 2891}),
		Enchanted_Gem (1, -1, new int[] {Skills.SLAYER, 1}, new int[] {4155}),
		Face_Mask (200, Equipment.HELMET, new int[] {Skills.SLAYER, 10}, new int[] {4164, 4165}),
		Ferocious_Ring (-1, Equipment.RING, new int[] {Skills.SLAYER, 1}, new int[] {15398, 15399, 15400, 15401, 15402}),
		Fishing_Explosive (60, -1, new int[] {Skills.SLAYER, 1}, new int[] {6660, 6664}),
		Full_Slayer_Helmet (-1, Equipment.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20}, new int[] {15492}),
		Full_Slayer_Helmet4charged5 (-1, Equipment.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20, Skills.SUMMONING, 20}, new int[] {15497}),
		Full_Slayer_Helmet4e5 (-1, Equipment.HELMET, new int[] {Skills.DEFENSE, 10, Skills.STRENGTH, 20, Skills.MAGIC, 20, Skills.RANGE, 20}, new int[] {15496}),
		Fungicide (10, -1, new int[] {Skills.SLAYER, 1}, new int[] {7432}),
		Fungicide_Spray (300, -1, new int[] {Skills.SLAYER, 57}, new int[] {7421, 7422, 7423, 7424, 7425, 7426, 7427, 7428, 7429, 7430, 7431}),
		Holy_Symbol (-1, Equipment.NECK, new int[] {Skills.SLAYER, 1}, new int[] {1718, 1719, 4682}),
		Ice_Cooler (1, -1 ,new int[] {Skills.SLAYER, 1}, new int[] {6696}),
		Insulated_Boots (200, Equipment.FEET, new int[] {Skills.SLAYER, 37}, new int[] {7159, 7161}),
		LeafBladed_Spear (31000, Equipment.WEAPON /*+ Equipment.SHIELD*/, new int[] {Skills.SLAYER, 55, Skills.ATTACK, 50}, new int[] {4158, 4159}),
		LeafBladed_Sword (-1, Equipment.WEAPON, new int[] {Skills.SLAYER, 55, Skills.ATTACK, 50}, new int[] {13290, 13291}),
		Lit_Bug_Lantern (200, Equipment.SHIELD, new int[] {Skills.SLAYER, 33}, new int[] {7052, 7053}),
		Masked_Earmuffs (-1, Equipment.HELMET, new int[] {Skills.SLAYER, 1}, new int[] {13277}),
		Mind_Shield (-1, Equipment.SHIELD, new int[] {Skills.DEFENSE, 1}, new int[] {9731, 9732}),
		Mirror_Shield (5000, Equipment.SHIELD, new int[] {Skills.SLAYER, 15, Skills.DEFENSE, 20}, new int[] {4156, 4157}),
		Nosepeg (200, Equipment.HELMET, new int[] {Skills.SLAYER, 60}, new int[] {4168, 4169}),
		Rock_Hammer (500, -1, new int[] {Skills.SLAYER, 1}, new int[] {4162, 4163}),
		Rope (-1, -1, new int[] {Skills.SLAYER, 1}, new int[] {954}),
		Seers_Headband (-1, -1, new int[] {Skills.SLAYER, 1}, new int[] {14631, 14662, 14663}),
		Slayer_Bell (150, -1, new int[] {Skills.SLAYER, 30}, new int[] {10952, 10953}),
		Slayer_Gloves (200, Equipment.HANDS, new int[] {Skills.SLAYER, 17}, new int[] {6708, 6720}),
		Slayer_Helmet (-1, Equipment.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {13263}),
		Slayer_Helmet_4charged5 (-1, Equipment.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {14637}),
		Slayer_Helmet_4e5 (-1, Equipment.HELMET, new int[] {Skills.SUMMONING, 20, Skills.DEFENSE, 10}, new int[] {14636}),
		Slayer_Staff (21000, Equipment.WEAPON, new int[] {Skills.SLAYER, 55, Skills.MAGIC, 50}, new int[] {4170, 4171}),
		Spiked_Helmet (-1, Equipment.HELMET, new int[] {Skills.DEFENSE, 5}, new int[] {13105, 13106, 13168}),
		Spiny_Helmet (650, Equipment.HELMET, new int[] {Skills.SLAYER, 1, Skills.DEFENSE, 5}, new int[] {4551, 4552}),
		Super_Fishing_Explosive (-1, -1, new int[] {Skills.SLAYER, 32}, new int[] {12633}),
		Tinderbox (-1, -1, new int[] {Skills.SLAYER, 1}, new int[] {590}),
		Unlit_Bug_Lantern (200, Equipment.SHIELD, new int[] {Skills.SLAYER, 33}, new int[] {7051}),
		Water_Skin (-1, -1, new int[] {Skills.SLAYER, 1}, new int[] {1823, 1825, 1827, 1829, 1831}),
		Witchwood_Icon (900, Equipment.NECK, new int[] {Skills.SLAYER, 58}, new int[] {8923});
		
		int itemCost = -1;
		int equipSlot = -1;
		int [] requirements = {-1};
		int[] IDs;
		int amount = 1;
		
		
		SlayerEquipment (int Cost, int equipmentSlot, int[] Requirements, int[] IDList) {
			itemCost = Cost;
			requirements = Requirements;
			equipSlot = equipmentSlot;
			IDs = IDList;
		}
		
		SlayerEquipment (SlayerEquipment equipmentEnum) {
			if (equipmentEnum != null) {
				itemCost = equipmentEnum.itemCost;
				requirements = equipmentEnum.requirements;
				equipSlot = equipmentEnum.equipSlot;
				IDs = equipmentEnum.IDs;
			}
		}
		
		SlayerEquipment (SlayerEquipment equipmentEnum, int Amount) {
			if (equipmentEnum != null) {
				itemCost = equipmentEnum.itemCost;
				requirements = equipmentEnum.requirements;
				equipSlot = equipmentEnum.equipSlot;
				IDs = equipmentEnum.IDs;
				amount = Amount;
			}
		}
		
		SlayerEquipment (int itemID) {
			this(getSlayerEquipment(itemID));
		}
		
		SlayerEquipment (String itemName) {
			this(getSlayerEquipment(itemName));
		}
		
		public int getAmount() {
			return amount;
		}
		
		public boolean availableAtMaster() {
			return itemCost != -1;
		}
		
		public int getCost() {
			return itemCost;
		}
		
		public boolean isEquipable() {
			return isUsable() && equipSlot != -1;
		}
		
		public int equipSlot() {
			return equipSlot;
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
			Game.openTab(Game.Tab.QUESTS);
			Script.sleep (600);
			if (!Game.isLoggedIn())  
				return;
			if (Game.getTab().equals(Game.Tab.QUESTS))
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

	private void checkMouseButtons() {
		Interface mouse = Interfaces.get(MOUSE_INTERFACE);
		InterfaceComponent mouseButtons;
		if (mouse != null) {
			mouseButtons = mouse.getComponent(BUTTON_CHANGER);
			if (mouseButtons.getTextureID() == 762) 
				return;
		}
		for (int i = 0; i < 6; i++) {
			Game.openTab(Game.Tab.OPTIONS);
			Script.sleep (600);
			if (!Game.isLoggedIn())  
				return;
			if (Game.getTab().equals(Game.Tab.OPTIONS))
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

	static SlayerEquipment getSlayerEquipment (int itemID) {
		for (SlayerEquipment currEquip: slayerEquipment) {
			for (int currInt: currEquip.getIDs()) {
				if (currInt == itemID)
					return currEquip;
			}
		}
		return null;
	}
	
	static SlayerEquipment getSlayerEquipment (String itemName) {
		for (SlayerEquipment currEquip: slayerEquipment) {
			if (itemName.equalsIgnoreCase(currEquip.getName()))
				return currEquip;
		}
		return null;
	}
	
	static SlayerEquipment[] slayerEquipmentArray() {
		return new SlayerEquipment[] { SlayerEquipment.AntiDragon_Shield,
				SlayerEquipment.Bag_Of_Salt, SlayerEquipment.Body_Shield,
				SlayerEquipment.BroadTipped_Bolts,SlayerEquipment.Broad_Arrows, 
				SlayerEquipment.Crystal_Chime, SlayerEquipment.Dragonfire_Shield,
				SlayerEquipment.Earmuffs, SlayerEquipment.Elemental_Shield,
				SlayerEquipment.Enchanted_Gem, SlayerEquipment.Face_Mask,
				SlayerEquipment.Ferocious_Ring, SlayerEquipment.Fishing_Explosive,
				SlayerEquipment.Full_Slayer_Helmet, SlayerEquipment.Full_Slayer_Helmet4charged5,
				SlayerEquipment.Full_Slayer_Helmet4e5, SlayerEquipment.Fungicide,
				SlayerEquipment.Fungicide_Spray, SlayerEquipment.Ice_Cooler,
				SlayerEquipment.Insulated_Boots, SlayerEquipment.LeafBladed_Spear,
				SlayerEquipment.LeafBladed_Sword, SlayerEquipment.Lit_Bug_Lantern,
				SlayerEquipment.Masked_Earmuffs, SlayerEquipment.Mind_Shield,
				SlayerEquipment.Mirror_Shield, SlayerEquipment.Nosepeg,
				SlayerEquipment.Rock_Hammer, SlayerEquipment.Slayer_Bell,
				SlayerEquipment.Slayer_Gloves, SlayerEquipment.Slayer_Helmet,
				SlayerEquipment.Slayer_Helmet_4charged5, SlayerEquipment.Slayer_Helmet_4e5,
				SlayerEquipment.Slayer_Staff, SlayerEquipment.Spiked_Helmet,
				SlayerEquipment.Spiny_Helmet, SlayerEquipment.Super_Fishing_Explosive,
				SlayerEquipment.Unlit_Bug_Lantern, SlayerEquipment.Witchwood_Icon };
	}
}
