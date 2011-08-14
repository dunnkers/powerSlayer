package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.SlayerLocations;
import org.rsbot.script.methods.Calculations;
import org.rsbot.script.wrappers.Tile;

public class LocationProfile {

	private SlayerLocations[] locations;
	
	
	/*	TODO Make an algorithm that returns a tile based on:
	 * 		1. Current Location
	 * 		2. Combat level
	 * 		3. Equipment needed to go in
	 */
	public LocationProfile(SlayerLocations... locations) {
		this.locations = locations;
	}

	public Tile getNearestLocationFromTile(Tile tile) {
		Tile closest = null;
		for(SlayerLocations location : locations) {
			if (closest == null || Calculations.distanceTo(location.getTile()) < Calculations.distanceTo(closest))
				closest = location.getTile();
		}
		return closest;
	}

	public Tile getBestLocation() {
		return null;
	}

	public SlayerLocations[] getLocations() {
		return locations;
	}

}
