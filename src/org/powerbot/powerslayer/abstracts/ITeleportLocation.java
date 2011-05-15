package org.powerbot.powerslayer.abstracts;

import org.rsbot.script.wrappers.RSTile;

public interface ITeleportLocation extends ITeleport {
    public abstract RSTile getLocation();
}
