package org.powerbot.powerslayer.movement;

import org.powerbot.powerslayer.abstracts.ITeleportLocation;
import org.rsbot.script.wrappers.RSTile;

public enum FairyRing implements ITeleportLocation {
	MAIN_HUB("", new RSTile(0, 0));
	private final String code;
	private final RSTile loc;

	private FairyRing(String code, RSTile loc) {
		this.loc = loc;
		this.code = code;
	}

	@Override
	public RSTile getDest() {
		return loc;
	}

	public String getCode() {
		return code;
	}

	@Override
	public RSTile getLocation() {
		return loc;
	}
}
