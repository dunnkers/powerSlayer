package org.powerbot.powerslayer.movement;

import org.powerbot.powerslayer.abstracts.ITeleport;
import org.rsbot.script.wrappers.RSTile;

public enum FairyRing implements ITeleport {
	MAIN_HUB(new RSTile(0, 0, 0), "", 0);
	private final RSTile location;
	private final String code;
	private final int ringID;

	private FairyRing(RSTile loc, String code, int ringID) {
		this.code = code;
		this.location = loc;
		this.ringID = ringID;
	}

	@Override
	public RSTile getDest() {
		return location;
	}

	public String getCode() {
		return code;
	}

	public int getID() {
		return ringID;
	}
}
