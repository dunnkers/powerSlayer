package org.powerbot.powerslayer.abstracts;

import org.rsbot.script.wrappers.RSTile;

public interface ITeleportLocation {
	public abstract RSTile getLocation();

	public abstract RSTile getDestination();
}
