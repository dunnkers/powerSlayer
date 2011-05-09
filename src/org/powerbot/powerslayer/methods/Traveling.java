package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.abstracts.ITeleport;
import org.powerbot.powerslayer.abstracts.ITeleportLocation;
import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.Banks;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.movement.TeleportItem;
import org.powerbot.powerslayer.movement.TeleportSpell;
import org.powerbot.powerslayer.wrappers.Rune;
import org.powerbot.powerslayer.wrappers.Task;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.RSInterface;
import org.rsbot.script.wrappers.RSItem;
import org.rsbot.script.wrappers.RSTile;

public class Traveling extends DMethodProvider {
	public Traveling(MethodBase methods) {
		super(methods);
	}

	public boolean travelToMaster(SlayerMaster master) {
		ITeleport t = getBestTeleport(master.getLocation());
		if (t != null)
			return castTeleport(t);
		else {
			return methods.walking.newTilePath(
					methods.web.generateNodePath(getMyPlayer().getLocation(),
							master.getLocation())).traverse();
		}
	}

	public boolean travelToMonster(Task task) {
		RSTile dest = task.getMonster().getNearest(getMyPlayer().getLocation());
		ITeleport t = getBestTeleport(dest);
		if (t != null)
			return castTeleport(t);
		else
			return methods.walking.newTilePath(
					methods.web.generateNodePath(getMyPlayer().getLocation(),
							dest)).traverse();
	}

	public RSItem getEquipmentItem(int... ids) {
		for (RSItem i : methods.equipment.getItems()) {
			for (int id : ids) {
				if (id == i.getID())
					return i;
			}
		}
		return null;
	}

	public boolean castTeleport(ITeleport t) {
		if (t instanceof TeleportSpell) {
			TeleportSpell tS = (TeleportSpell) t;
			if (methods.magic.getCurrentSpellBook() == tS.getBook())
				return methods.magic.castSpell(tS.getSpell());
		} else if (t instanceof TeleportItem) {
			TeleportItem tI = (TeleportItem) t;
			RSItem item;
			if ((item = methods.inventory.getItem(tI.getIDs())) != null
					|| (item = getEquipmentItem(tI.getIDs())) != null) {
				if (item.doAction(tI.getAction())) {
					return true;
				} else if (item.doAction("Rub")) {
					sleep(1750, 2250);
					RSInterface inter = methods.interfaces.get(tI
							.getRubInterfaceID());
					if (inter != null)
						return methods.interfaces.clickDialogueOption(inter,
								tI.getAction());
				}
			}
		}
		return false;
	}

	// The default will be the closest bank to the player
	public boolean travelToBank() {
		return travelToBank(getNearestBank());
	}

	public boolean travelToBank(Banks bank) {
		ITeleport t = getBestTeleport(bank.getRSArea().getCentralTile());
		if (t != null)
			return castTeleport(t);
		else
			return methods.walking.newTilePath(
					methods.web.generateNodePath(getMyPlayer().getLocation(),
							bank.getRSArea().getCentralTile())).traverse();
	}

	// returns null if there are no teleports that are closer
	public ITeleport getBestTeleport(RSTile dest) {
		ITeleport best = null;
		double dist = 0;
		for (ITeleport t : methods.parent.getAllTeleports()) {
			if (canCast(t)) {
				double tDist = methods.calc.distanceBetween(t.getDest(), dest);
				if (t instanceof ITeleportLocation)
					tDist += methods.calc.distanceTo(((ITeleportLocation) t)
							.getLocation());
				if (best == null || tDist < dist) {
					best = t;
					dist = tDist;
				}
			}
		}
		if (methods.calc.distanceTo(dest) > dist) // player is farthur away than
													// the
			// best teleport
			return best;
		return null;
	}

	// Makes sure the player has the required Magic level, and then
	// checks to make sure all of the required items are available
	public boolean canCast(ITeleport t) {
		if (t instanceof TeleportSpell) {
			TeleportSpell tS = (TeleportSpell) t;
			if (methods.skills.getCurrentLevel(Skills.MAGIC) < tS
					.getMagicLevel()
					|| methods.magic.getCurrentSpellBook() != tS.getBook())
				return false;
			for (Rune rune : tS.getRunes().keySet()) {
				if (methods.parent.getRuneCount(rune) < tS.getRuneCount(rune))
					return false;
			}
		} else if (t instanceof TeleportItem) {
			TeleportItem tT = (TeleportItem) t;
			return methods.inventory.containsOneOf(tT.getIDs())
					|| methods.equipment.containsOneOf(tT.getIDs());
		}
		return true;
	}

	public Banks getNearestBank() {
		/*
		 * TODO Add a method to remove all banks that a player can not
		 * reach.TODO Use the web to return a 'real' distance.
		 */
		Banks best = null;
		int bDist = Integer.MAX_VALUE;
		for (Banks b : Banks.values()) {
			int dist = methods.calc.distanceTo(b.getRSArea().getCentralTile());
			if (dist < bDist) {
				best = b;
				bDist = dist;
			}
		}
		return best;
	}

	public boolean isInBank(RSTile tile) {
		for (Banks b : Banks.values()) {
			if (b.containsTile(tile)) {
				return true;
			}
		}
		return false;
	}

	public int getArrayIndex(int[] array, int num) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				return i;
			}
		}
		return -1;
	}

	public int min(int[] a) {
		int res = Integer.MAX_VALUE;
		for (int anA : a) {
			res = Math.min(anA, res);
		}
		return res;
	}
}
