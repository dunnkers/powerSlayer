package org.powerbot.powerslayer.wrappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.powerbot.powerslayer.data.Quests;
import org.powerbot.powerslayer.data.Quests.Quest;
import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.methods.CombatStyle;
import org.powerbot.powerslayer.methods.SlayerEquip;
import org.powerbot.powerslayer.methods.SlayerInventory;
import org.rsbot.script.methods.tabs.Equipment;

public class Requirements {
    List<SlayerEquipment> items = new ArrayList<SlayerEquipment>();
	List<Quest> quests = new ArrayList<Quest>();
    Finisher finisher;
    Starter starter;
    CombatStyle style = null;
    boolean lightsource = false;

	//TODO: Do we really need all these constructors?
    public Requirements(SlayerEquipment[] itemArray, Quest[] questArray, Finisher finisher, Starter starter,
                        CombatStyle style, boolean lightsource) {
        this.items.addAll(Arrays.asList(itemArray));
	    this.quests.addAll(Arrays.asList(questArray));
        this.finisher = finisher;
        this.starter = starter;
        this.style = style;
    }

    public Requirements(SlayerEquipment[] itemArray, Finisher finisher, Starter starter, CombatStyle style) {
        this.items.addAll(Arrays.asList(itemArray));
        this.finisher = finisher;
        this.starter = starter;
        this.style = style;
    }

    public Requirements (SlayerEquipment[] itemArray, Finisher finisher, Starter starter, boolean lightsource) {
        this(itemArray, null, finisher, starter, null, lightsource);
    }

    public Requirements(SlayerEquipment[] itemArray, boolean lightsource) {
        this(itemArray, null, null, null, null, lightsource);
    }

    public Requirements(SlayerEquipment[] itemArray, Finisher finisher) {
        this(itemArray, finisher, null, null);
    }

    public Requirements(SlayerEquipment[] itemArray, Starter starter) {
        this(itemArray, null, starter, null);
    }

    public Requirements(SlayerEquipment[] itemArray) {
        this(itemArray, null, null, null);
    }

	public Requirements(boolean b) {
		this (null, null, null, b);
	}

	public Requirements(Quest... quests) {
		this(null, quests, null, null, null, false);
	}

	public SlayerEquipment[] getEquipment() {
        SlayerEquipment[] itemArray = null;
        this.items.toArray(itemArray);
        return itemArray;
    }

    public Finisher getFinisher() {
        return this.finisher;
    }

    public Starter getStarter() {
        return this.starter;
    }

    public CombatStyle getCombatStyle() {
        return this.style;
    }

    public boolean needsLightsource() {
        return lightsource;
    }

	private boolean hasEquipment() {
    	if (items.size() == 0)
    		return true;
    	for (SlayerEquipment currEquip : items) {
    		if (!SlayerInventory.contains(currEquip) && !contains(currEquip))
    			return false;
    	}
    	return true;
    }

    private boolean hasFinisher() {
	    return finisher == null || SlayerInventory.hasEnough(finisher);
    }

    private boolean hasStarter() {
	    return starter == null || SlayerInventory.hasEnough(starter);
    }

	private boolean finishedQuests() {
		return quests.size() == 0 || Quests.isQuestCompleted(quests.toArray(new Quest[quests.size()]));
	}

	public boolean isSatisfied() {
		return hasEquipment() && hasFinisher() && hasStarter() && finishedQuests();
	}
	
	private boolean contains(SlayerEquipment equip) {
		return equip == null || Equipment.getItem(equip.equipSlot()).getName().equalsIgnoreCase(equip.getName());
	}
}