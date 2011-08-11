package org.powerbot.powerslayer.abstracts;

import org.rsbot.script.wrappers.Tile;

public interface ITeleportLocation extends ITeleport {
    public abstract Tile getLocation();
}
