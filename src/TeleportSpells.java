import org.rsbot.script.wrappers.RSTile;

enum TeleportSpell {
	// TODO link these to a teleporting method.
	LUMBRIDGE(TeleportType.HOME_SPELL, new RSTile(0, 0, 0)), VARROCK_SPELL_1(
			TeleportType.VARROCK_SPELL, new RSTile(0, 0, 0), new Item[] {
					new Item(Item.NEEDS_TO_BE_EQUIPED, new String[] {
							"Fire staff", "Lava staff" }),
					new Item("Law rune"), new Item("Air runes", 3) }, 25), VARROCK_SPELL_3(
			TeleportType.VARROCK_SPELL, new RSTile(0, 0, 0), new Item[] {
					new Item(Item.NEEDS_TO_BE_EQUIPED, "Fire rune"),
					new Item("Law rune"), new Item("Air staff") }, 25), VARROCK_TAB(
			TeleportType.TAB, new RSTile(0, 0, 0), new Item[] { new Item(
					"Varrock teleport") }), ROD_DUEL_AREA(TeleportType.OTHER,
			new RSTile(0, 0, 0), new Item(Item.COULD_BE_EQUIPED,
					"Ring of dueling"));
	private Item[] items;
	private RSTile loc;
	private int magicLevel;
	private TeleportType type;

	private TeleportSpell(TeleportType type, RSTile loc, Item[] items,
			int magicLevel) {
		this.type = type;
		this.loc = loc;
		this.items = items;
		this.magicLevel = magicLevel;
	}

	private TeleportSpell(TeleportType type, RSTile loc, Item[] items) {
		this(type, loc, items, 1);
	}

	private TeleportSpell(TeleportType type, RSTile loc, Item item,
			int magicLevel) {
		this(type, loc, new Item[] { item }, magicLevel);
	}

	private TeleportSpell(TeleportType type, RSTile loc, Item item) {
		this(type, loc, new Item[] { item }, 1);
	}

	private TeleportSpell(TeleportType type, RSTile loc) {
		this(type, loc, (Item) null, 1);
	}

	public RSTile getLocation() {
		return this.loc;
	}

	public Item[] getItems() {
		return this.items;
	}

	public TeleportType getType() {
		return type;
	}
}