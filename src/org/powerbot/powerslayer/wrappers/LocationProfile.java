package org.powerbot.powerslayer.wrappers;

import org.rsbot.script.methods.Calculations;
import org.rsbot.script.wrappers.Tile;

public class LocationProfile {

	private MonsterLocation[] locations;
	
	
	/*	TODO Make an algorithm that returns a MonsterLocation based on:
	 * 		1. Current Location
	 * 		2. Combat level
	 * 		3. Equipment needed to go in
	 */
	public LocationProfile(MonsterLocation... locations) {
		this.locations = locations;
	}

	public MonsterLocation getBestLocation() {
		return null;
	}

	public Tile getNearestLocationFromTile(Tile tile) {
		Tile closest = null;
		for(MonsterLocation location : locations) {
			if (closest == null || Calculations.distanceTo(location.getTile()) < Calculations.distanceTo(closest))
				closest = location.getTile();
		}
		return closest;
	}

	public MonsterLocation[] getMonsterLocations() {
		return locations;
	}

}
