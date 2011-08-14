package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.methods.CombatStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Requirements {
    List<SlayerEquipment> items = new ArrayList<SlayerEquipment>();
    Finisher finisher;
    Starter starter;
    CombatStyle style = null;


    boolean lightsource = false;

    public Requirements(SlayerEquipment[] itemArray, Finisher finisher, Starter starter,
    		CombatStyle style, boolean lightsource) {
        this.items.addAll(Arrays.asList(itemArray));
        this.finisher = finisher;
        this.starter = starter;
        this.style = style;
    }

    public Requirements(SlayerEquipment[] itemArray, Finisher finisher, Starter starter,
    		CombatStyle style) {
        this.items.addAll(Arrays.asList(itemArray));
        this.finisher = finisher;
        this.starter = starter;
        this.style = style;
    }

    public Requirements (SlayerEquipment[] itemArray, Finisher finisher, Starter starter,
                        boolean lightsource) {
        this(itemArray, finisher, starter, null, lightsource);
    }

    public Requirements(SlayerEquipment[] itemArray, boolean lightsource) {
        this(itemArray, null, null, null, lightsource);
    }

    public Requirements(SlayerEquipment[] itemArray, Finisher finisher) {
        this(itemArray, finisher, null, null);
    }

    public Requirements(SlayerEquipment[] itemArray, Starter starter) {
        this(itemArray, null, starter, null);
    }

    public Requirements(CombatStyle style) {
        this(null, null, null, style);
    }

    public Requirements(SlayerEquipment[] itemArray) {
        this(itemArray, null, null, null);
    }

    public Requirements(SlayerEquipment[] slayerEquipments, CombatStyle combatStyle) {
		this (slayerEquipments, null, null, combatStyle);
	}

	public Requirements(boolean b) {
		this (null, null, null, b);
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
}