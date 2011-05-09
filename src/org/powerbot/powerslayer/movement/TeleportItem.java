package org.powerbot.powerslayer.movement;

import org.powerbot.powerslayer.abstracts.ITeleport;
import org.rsbot.script.wrappers.RSTile;

public enum TeleportItem implements ITeleport {
	ECTOPHIAL(new RSTile(3658, 3522), "Empty", 4251),
	LUMBRIDGE_TAB(new RSTile(3221, 3220), 8008),
	ARDOUGENE_TAB(new RSTile(2661, 3303), 8011),
	CAMELOT_TAB(new RSTile(2757, 3478), 8010),
	VARROCK_TAB(new RSTile(3212, 3429), 8007),
	TAVERLEY_TAB(new RSTile(2893, 3465), 18110),
	RIMMINGTON_TAB(new RSTile(2956, 3224), 18809),
	RELLEKA_TAB(new RSTile(2670, 3652), 18812),
	BRIMHAVEN_TAB(new RSTile(2759, 3179), 18813),
	NARDAH_SCROLL(new RSTile(3421, 2918), "Read", 19475),
	LUMBER_YARD_SCROLL(new RSTile(3308, 3492), "Read", 19480),
	MISCELLANIA_SCROLL(new RSTile(2513, 3858), "Read", 19477),
	LLETYA_CRYSTAL(new RSTile(2328, 3172), "Activate", "Lletya", 6102, 6100, 6101);
	private final int[] itemIDs;
	private final RSTile dest;
	private final String[] action;
	private final int rubInterfaceID;

	private TeleportItem(RSTile dest, int... itemIDs) {
		this.dest = dest;
		this.itemIDs = itemIDs;
		this.action = new String[] { "Break" };
		this.rubInterfaceID = -1;
	}

	private TeleportItem(RSTile dest, String action, int... itemIDs) {
		this.dest = dest;
		this.itemIDs = itemIDs;
		this.action = new String[] { action };
		this.rubInterfaceID = -1;
	}

	private TeleportItem(RSTile dest, int rubInterfaceID, String action,
			int... itemIDs) {
		this.dest = dest;
		this.itemIDs = itemIDs;
		this.action = new String[] { action };
		this.rubInterfaceID = rubInterfaceID;
	}

	private TeleportItem(RSTile dest, String action1, String action2,
			int... itemIDs) {
		this.dest = dest;
		this.itemIDs = itemIDs;
		this.action = new String[] { action1, action2 };
		this.rubInterfaceID = -1;
	}

	public int getRubInterfaceID() {
		return rubInterfaceID;
	}

	public String[] getAction() {
		return action;
	}

	public int[] getIDs() {
		return itemIDs;
	}

	@Override
	public RSTile getDest() {
		return dest;
	}
}
