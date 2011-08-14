package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.data.SlayerItems.SlayerEquipment;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.Tile;

public enum SlayerLocations {

	Example (new Tile(0,0), new SlayerEquipment[] {}, new int[] {Skills.ATTACK, 0}, 0),
	Fremmenik_Slayer_Dungeon (new Tile (0, 0, 0), null, new int[] {Skills.SLAYER, 0}, 0),
	//Need to finish Priest in Peril
	Canifis_Slayer_Tower (new Tile(0, 0, 0), null, null, 0),
	Lumbridge_Swamp_Caves (new Tile(0, 0, 0), 
			new SlayerEquipment[] {SlayerEquipment.Bullseye_Lantern, SlayerEquipment.Rope, SlayerEquipment.Tinderbox},null, 0), 
	God_Wars_Dungeon (new Tile(0, 0, 0), null, null, 0),
	Desert_Slayer_Dungeon (new Tile(0, 0, 0), null, null, 0),
	Chaos_Tunnels (new Tile(0, 0, 0), null, null, 0),
	DorgeshKaan_South_Dungeon (new Tile(0, 0, 0), null, null, 0),
	Kuradels_Slayer_Dungeon (new Tile(0, 0, 0), null, null, 0);
	

	Tile tile = null;
	SlayerEquipment[] equipment;
	int[] neededSkills = null;
	int neededCbLevel = 0;


	SlayerLocations(Tile Tile, SlayerEquipment[] neededEquipment, int[] neededSkills, int neededCbLevel) {
		tile = Tile;
		equipment = neededEquipment;
		if(neededSkills != null) {
			if(neededSkills.length > 0) {
				if(neededSkills.length % 2 == 0) {
					this.neededSkills = neededSkills;
				} else {
					this.neededSkills = null;
				}
			}
		}
		this.neededCbLevel = neededCbLevel;
	}

	SlayerLocations(Tile tile, SlayerEquipment[] neededEquipment, int[] neededSkills) {
		this(tile, neededEquipment, neededSkills, 0);
	}

	SlayerLocations (Tile tile, SlayerEquipment[] neededEquipment) {
		this(tile, neededEquipment, null);
	}

	SlayerLocations(Tile tile) {
		this(tile, null);
	}

	public Tile getTile() {
		return tile;
	}

	public SlayerEquipment[] getEquipment() {
		return equipment;
	}

	public int[] getNeededSkills() {
		return neededSkills;
	}

	public int getNeededCbLevel() {
		return neededCbLevel;
	}
}