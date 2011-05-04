import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Requirements {
    List<Item> items = new ArrayList<Item>();
    Finisher finisher;
    Starter starter;
    List<Equipment> equipments = new ArrayList<Equipment>();
    CombatStyle style = null;

    public Requirements(Item[] itemArray, Finisher finisher, Starter starter,
                        Equipment[] equipmentArray, CombatStyle style) {
        this.items.addAll(Arrays.asList(itemArray));
        this.finisher = finisher;
        this.starter = starter;
        this.equipments.addAll(Arrays.asList(equipmentArray));
        this.style = style;
    }

    public Requirements(Item[] itemArray, Finisher finisher, Starter starter,
                        Equipment[] equipmentArray) {
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

    public Requirements(Equipment[] equipmentArray, CombatStyle style) {
        this(null, null, null, equipmentArray, style);
    }

    public Requirements(Equipment[] equipmentArray) {
        this(null, null, null, equipmentArray, null);
    }

    public Requirements(Equipment equipment) {
        this(null, null, null, new Equipment[]{equipment}, null);
    }

    public Requirements(Item[] itemArray) {
        this(itemArray, null, null, null, null);
    }

    public Requirements(Item item) {
        this(new Item[]{item}, null, null, null, null);
    }

    Item[] getItems() {
        Item[] itemArray = null;
        this.items.toArray(itemArray);
        return itemArray;
    }

    Finisher getFinisher() {
        return this.finisher;
    }

    Starter getStarter() {
        return this.starter;
    }

    Equipment[] getEquipment() {
        Equipment[] equipmentArray = null;
        this.equipments.toArray(equipmentArray);
        return equipmentArray;
    }

    CombatStyle getCombatStyle() {
        return this.style;
    }
}