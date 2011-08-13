package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.methods.CombatStyle;
import org.rsbot.script.wrappers.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Requirements {
	//TODO: Shouldn't lightsource be put with locations?
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

    public Requirements(SlayerEquipment[] itemArray, Finisher finisher, boolean lightsource) {
        this(itemArray, finisher, null, null, lightsource);
    }

    public Requirements(SlayerEquipment item, Finisher finisher, boolean lightsource) {
        this(new SlayerEquipment[]{item}, finisher, null, null, lightsource);
    }

    public Requirements(SlayerEquipment[] itemArray, Starter starter, boolean lightsource) {
        this(itemArray, null, starter, null, lightsource);
    }

    public Requirements(SlayerEquipment item, Starter starter, boolean lightsource) {
        this(new SlayerEquipment[]{item}, null, starter, null, lightsource);
    }

    public Requirements(CombatStyle style, boolean lightsource) {
        this(null, null, null, style, lightsource);
    }

    public Requirements(SlayerEquipment[] itemArray, boolean lightsource) {
        this(itemArray, null, null, null, lightsource);
    }

    public Requirements(SlayerEquipment item, boolean lightsource) {
        this(new SlayerEquipment[]{item}, null, null, null, lightsource);
    }

    public Requirements(SlayerEquipment[] itemArray, Finisher finisher, Starter starter) {
        this(itemArray, finisher, starter, null);
    }

    public Requirements(SlayerEquipment[] itemArray, Finisher finisher) {
        this(itemArray, finisher, null, null);
    }

    public Requirements(SlayerEquipment item, Finisher finisher) {
        this(new SlayerEquipment[]{item}, finisher, null, null);
    }

    public Requirements(SlayerEquipment[] itemArray, Starter starter) {
        this(itemArray, null, starter, null);
    }

    public Requirements(SlayerEquipment item, Starter starter) {
        this(new SlayerEquipment[]{item}, null, starter, null);
    }

    public Requirements(CombatStyle style) {
        this(null, null, null, style);
    }

    public Requirements(SlayerEquipment[] itemArray) {
        this(itemArray, null, null, null);
    }

    public Requirements(SlayerEquipment item) {
        this(new SlayerEquipment[]{item}, null, null, null);
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