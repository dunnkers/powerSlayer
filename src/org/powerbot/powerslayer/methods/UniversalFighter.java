package org.powerbot.powerslayer.methods;

import java.util.LinkedList;

import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.RSItem;

public class UniversalFighter extends DMethodProvider {

	public UniversalFighter(MethodBase methods) {
		super(methods);
	}

	private class Potion {
		// TODO add options to include pots and which pots
		private int[] ids;
		private int[] boostedSkills;
		private int amount;

		private Potion(int[] ids, int[] boostedSkills) {
			this.ids = ids;
			this.boostedSkills = boostedSkills;
		}

		private Potion(int[] ids, int boostedSkill) {
			this(ids, new int[boostedSkill]);
		}

		private int getAmount() {
			return methods.inventory.getCount(true, ids);
		}
	}

	private class PotionMethods {
		private final int[] VIAL = new int[] { 229 };

		private LinkedList<Potion> getPotions() {
			LinkedList<Potion> potions = new LinkedList<Potion>();
			potions.add(new Potion(new int[] { 3040, 3042, 3044, 3046, 11513,
					11515, 13520, 13521, 13522, 13523 }, Skills.MAGIC));
			// Magic pots
			potions.add(new Potion(new int[] { 2434, 139, 141, 143, 11465,
					11467 }, Skills.PRAYER));
			// Prayer pots
			potions.add(new Potion(new int[] { 2444, 169, 171, 173, 11509,
					11511, 13524, 13525, 15326, 15327 }, Skills.RANGE));
			// Range pots
			potions.add(new Potion(new int[] { 9739, 9741, 9743, 9745, 11445,
					11447 }, new int[] { Skills.ATTACK, Skills.STRENGTH }));
			// Combat pots
			potions.add(new Potion(new int[] { 2428, 121, 123, 125, 2436, 145,
					147, 149, 11429, 11431, 11429, 11431, 11429, 11431, 11469,
					11471, 15308, 15309, 15310, 15311 }, Skills.ATTACK));
			// Attack pots
			potions.add(new Potion(new int[] { 113, 115, 117, 119, 2440, 157,
					159, 161, 11443, 11441, 11485, 11487, 15312, 15313, 15314,
					15315 }, Skills.STRENGTH));
			// Strength pots
			potions.add(new Potion(new int[] { 2432, 133, 135, 137, 2442, 163,
					165, 167, 11457, 11459, 11497, 11499, 15316, 15317, 15318,
					15319 }, Skills.DEFENSE));
			// Defense pots
			potions.add(new Potion(new int[] { 15332, 15333, 15334, 15335 },
					new int[] { Skills.STRENGTH, Skills.ATTACK, Skills.DEFENSE,
							Skills.MAGIC, Skills.RANGE }));
			// Overloads
			return potions;
		}

		private Potion needToPot() {
			for (Potion p : getPotions()) {
				// Check that the pot is needed.
				if (p.getAmount() > 1 && areSkillsBoosted(p.boostedSkills)) {
					return p;
				}
			}
			return null;
		}

		public boolean usePotions() {
			Potion pot = needToPot();
			if (pot != null) {
				RSItem item = methods.inventory.getItem(pot.ids);
				if (item != null) {
					return item.doClick(true);
				}
			}
			return false;
		}

		private boolean areSkillsBoosted(int[] skillsArray) {
			for (int skill : skillsArray) {
				if (methods.skills.getCurrentLevel(skill) <= methods.skills
						.getRealLevel(skill)) {
					return true;
				}
			}
			return false;
		}
	}
}