package org.powerbot.powerslayer.data;

import org.powerbot.powerslayer.wrappers.Requirements;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.Tile;

public enum MonsterLocations {

	Example(new Tile(0,0), new Requirements(null, null, null, null), new int[] {Skills.ATTACK, 0}, 0);

	Tile tile = null;
	Requirements requirements = null;
	int[] neededSkills = null;
	int neededCbLevel = 0;


	MonsterLocations(Tile tile, Requirements requirements, int[] neededSkills, int neededCbLevel) {
		this.tile = tile;
		this.requirements = requirements;
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

	MonsterLocations(Tile tile, Requirements requirements, int[] neededSkills) {
		this(tile, requirements, neededSkills, 0);
	}

	MonsterLocations (Tile tile, Requirements requirements) {
		this(tile, requirements, null);
	}

	MonsterLocations(Tile tile) {
		this(tile, null);
	}

	public Tile getTile() {
		return tile;
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public int[] getNeededSkills() {
		return neededSkills;
	}

	public int getNeededCbLevel() {
		return neededCbLevel;
	}
}