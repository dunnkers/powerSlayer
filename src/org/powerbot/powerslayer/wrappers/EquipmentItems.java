package org.powerbot.powerslayer.wrappers;

public class EquipmentItems
{
    private String[] names;
    private int slot;

    public EquipmentItems(String[] names, int slot) {
        this.names = names;
        this.slot = slot;
    }

    public EquipmentItems(String name, int slot) {
        this(new String[]{name}, slot);
    }

    public String[] getNames() {
        return this.names;
    }

    public int getSlot() {
        return this.slot;
    }
}