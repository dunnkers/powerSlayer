package org.powerbot.powerslayer.wrappers;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.rsbot.script.wrappers.Tile;

public class LocationProfile {
	
	Tile playerLocation;
	Tile chosenLocation;
	Tile[] tiles;
	int combatLevel;
	SlayerEquipment requiredEquipment;
	SlayerMaster master;
	
	
	/*	TODO Make an algorithm that returns a tile based on:
	 * 		1. Current Location
	 * 		2. Combat level
	 * 		3. Equipment needed to go in
	 * 		4. Current Slayer Master
	 * 		
	 * 	TODO Add in other effects of area
	 * 		1. Extra equipment
	 * 		2. Any more you can come up with
	 */
	LocationProfile (Tile... Tiles) {
		
	}

}
