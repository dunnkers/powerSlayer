package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.methods.CombatStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Requirements {
    List<Item> items = new ArrayList<Item>();
    Finisher finisher;
    Starter starter;
    List<EquipmentItems> equipments = new ArrayList<EquipmentItems>();
    CombatStyle style = null;

    public Requirements(Item[] itemArray, Finisher finisher, Starter starter,
                        EquipmentItems[] equipmentArray, CombatStyle style) {
        this.items.addAll(Arrays.asList(itemArray));
        this.finisher = finisher;
        this.starter = starter;
        this.equipments.addAll(Arrays.asList(equipmentArray));
        this.style = style;
    }

    public Requirements(Item[] itemArray, Finisher finisher, Starter starter,
                        EquipmentItems[] equipmentArray) {
        this(itemArray, finisher, starter, equipmentArray, null);
    }

    public Requirements(Item[] itemArray, Finisher finisher, Starter starter) {
        this(itemArray, finisher, starter, null, null);
    }

    public Requirements(Item[] itemArray, Finisher finisher) {
        this(itemArray, finisher, null, null, null);
    }

    public Requirements(Item item, Finisher finisher) {
        this(new Item[]{item}, finisher, null, null, null);
    }

    public Requirements(Item[] itemArray, Starter starter) {
        this(itemArray, null, starter, null, null);
    }

    public Requirements(Item item, Starter starter) {
        this(new Item[]{item}, null, starter, null, null);
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

    public Requirements(Item[] itemArray) {
        this(itemArray, null, null, null, null);
    }

    public Requirements(Item item) {
        this(new Item[]{item}, null, null, null, null);
    }

    public Item[] getItems() {
        Item[] itemArray = null;
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
}