package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.MonsterLocations;
import org.rsbot.script.methods.Calculations;
import org.rsbot.script.wrappers.Tile;

public class LocationProfile {

	private MonsterLocations[] locations;
	
	
	/*	TODO Make an algorithm that returns a tile based on:
	 * 		1. Current Location
	 * 		2. Combat level
	 * 		3. Equipment needed to go in
	 */
	public LocationProfile(MonsterLocations... locations) {
		this.locations = locations;
	}

	public Tile getNearestLocationFromTile(Tile tile) {
		Tile closest = null;
		for(MonsterLocations location : locations) {
			if (closest == null || Calculations.distanceTo(location.getTile()) < Calculations.distanceTo(closest))
				closest = location.getTile();
		}
		return closest;
	}

	public Tile getBestLocation() {
		return null;
	}

	public MonsterLocations[] getLocations() {
		return locations;
	}

}
