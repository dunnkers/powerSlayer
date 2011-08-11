package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.methods.CombatStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Requirements {
    List<SlayerItem> items = new ArrayList<SlayerItem>();
    Finisher finisher;
    Starter starter;
    List<EquipmentItems> equipments = new ArrayList<EquipmentItems>();
    CombatStyle style = null;
    boolean lightsource = false;

    public Requirements(SlayerItem[] itemArray, Finisher finisher, Starter starter,
                        EquipmentItems[] equipmentArray, CombatStyle style,
                        boolean lightsource) {
        this.items.addAll(Arrays.asList(itemArray));
        this.finisher = finisher;
        this.starter = starter;
        this.equipments.addAll(Arrays.asList(equipmentArray));
        this.style = style;
    }

    public Requirements(SlayerItem[] itemArray, Finisher finisher, Starter starter,
                        EquipmentItems[] equipmentArray, CombatStyle style) {
        this.items.addAll(Arrays.asList(itemArray));
        this.finisher = finisher;
        this.starter = starter;
        this.equipments.addAll(Arrays.asList(equipmentArray));
        this.style = style;
    }

    public Requirements(SlayerItem[] itemArray, Finisher finisher, Starter starter,
                        EquipmentItems[] equipmentArray, boolean lightsource) {
        this(itemArray, finisher, starter, equipmentArray, null, lightsource);
    }

    public Requirements(SlayerItem[] itemArray, Finisher finisher, Starter starter,
                        boolean lightsource) {
        this(itemArray, finisher, starter, null, null, lightsource);
    }

    public Requirements(SlayerItem[] itemArray, Finisher finisher, boolean lightsource) {
        this(itemArray, finisher, null, null, null, lightsource);
    }

    public Requirements(SlayerItem item, Finisher finisher, boolean lightsource) {
        this(new SlayerItem[]{item}, finisher, null, null, null, lightsource);
    }

    public Requirements(SlayerItem[] itemArray, Starter starter, boolean lightsource) {
        this(itemArray, null, starter, null, null, lightsource);
    }

    public Requirements(SlayerItem item, Starter starter, boolean lightsource) {
        this(new SlayerItem[]{item}, null, starter, null, null, lightsource);
    }

    public Requirements(CombatStyle style, boolean lightsource) {
        this(null, null, null, null, style, lightsource);
    }

    public Requirements(EquipmentItems[] equipmentArray, CombatStyle style,
                        boolean lightsource) {
        this(null, null, null, equipmentArray, style, lightsource);
    }

    public Requirements(EquipmentItems[] equipmentArray, boolean lightsource) {
        this(null, null, null, equipmentArray, null, lightsource);
    }

    public Requirements(EquipmentItems equipment, boolean lightsource) {
        this(null, null, null, new EquipmentItems[]{equipment}, null,
                lightsource);
    }

    public Requirements(boolean lightsource) {
        this(null, null, null, null, null, lightsource);
    }

    public Requirements(SlayerItem[] itemArray, boolean lightsource) {
        this(itemArray, null, null, null, null, lightsource);
    }

    public Requirements(SlayerItem item, boolean lightsource) {
        this(new SlayerItem[]{item}, null, null, null, null, lightsource);
    }

    public Requirements(SlayerItem[] itemArray, Finisher finisher, Starter starter,
                        EquipmentItems[] equipmentArray) {
        this(itemArray, finisher, starter, equipmentArray, null);
    }

    public Requirements(SlayerItem[] itemArray, Finisher finisher, Starter starter) {
        this(itemArray, finisher, starter, null, null);
    }

    public Requirements(SlayerItem[] itemArray, Finisher finisher) {
        this(itemArray, finisher, null, null, null);
    }

    public Requirements(SlayerItem item, Finisher finisher) {
        this(new SlayerItem[]{item}, finisher, null, null, null);
    }

    public Requirements(SlayerItem[] itemArray, Starter starter) {
        this(itemArray, null, starter, null, null);
    }

    public Requirements(SlayerItem item, Starter starter) {
        this(new SlayerItem[]{item}, null, starter, null, null);
    }

    public Requirements(CombatStyle style) {
        this(null, null, null, null, style);
    }

    public Requirements(EquipmentItems[] equipmentArray, CombatStyle style) {
        this(null, null, null, equipmentArray, style);
    }

    public Requirements(EquipmentItems[] equipmentArray) {
        this(null, null, null, equipmentArray, null);
    }

    public Requirements(EquipmentItems equipment) {
        this(null, null, null, new EquipmentItems[]{equipment}, null);
    }

    public Requirements(SlayerItem[] itemArray) {
        this(itemArray, null, null, null, null);
    }

    public Requirements(SlayerItem item) {
        this(new SlayerItem[]{item}, null, null, null, null);
    }

    public SlayerItem[] getItems() {
        SlayerItem[] itemArray = null;
        this.items.toArray(itemArray);
        return itemArray;
    }

    public Finisher getFinisher() {
        return this.finisher;
    }

    public Starter getStarter() {
        return this.starter;
    }

    public EquipmentItems[] getEquipment() {
        EquipmentItems[] equipmentArray = null;
        this.equipments.toArray(equipmentArray);
        return equipmentArray;
    }

    public CombatStyle getCombatStyle() {
        return this.style;
    }

    public boolean needsLightsource() {
        return lightsource;
    }
}