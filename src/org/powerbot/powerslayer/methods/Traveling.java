package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.abstracts.ITeleport;
import org.powerbot.powerslayer.abstracts.ITeleportLocation;
import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.Banks;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.movement.FairyRing;
import org.powerbot.powerslayer.movement.TeleportItem;
import org.powerbot.powerslayer.movement.TeleportSpell;
import org.powerbot.powerslayer.wrappers.Rune;
import org.powerbot.powerslayer.wrappers.Task;
import org.rsbot.script.methods.Objects;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.RSComponent;
import org.rsbot.script.wrappers.RSInterface;
import org.rsbot.script.wrappers.RSItem;
import org.rsbot.script.wrappers.RSObject;
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
				if (id == i.getID()) {
					return i;
				}
			}
		}
		return null;
	}

	public boolean castTeleport(ITeleport t) {
		if (t instanceof TeleportSpell) {
			TeleportSpell tS = (TeleportSpell) t;
			if (methods.magic.getCurrentSpellBook() == tS.getBook()) {
				return methods.magic.castSpell(tS.getSpell());
			}
		} else if (t instanceof TeleportItem) {
			TeleportItem tI = (TeleportItem) t;
			RSItem item;
			if ((item = methods.inventory.getItem(tI.getIDs())) != null
					|| (item = getEquipmentItem(tI.getIDs())) != null) {
				for (String opt : tI.getAction()) {
					if (item.doAction(opt)) {
						return true;
					}
				}
				if (item.doAction("Rub")) {
					sleep(1750, 2250);
					RSInterface inter = methods.interfaces.get(tI
							.getRubInterfaceID());
					if (inter != null) {
						for (String opt : tI.getAction()) {
							if (methods.interfaces.clickDialogueOption(inter,
									opt)) {
								return true;
							}
						}
					}
				}
			}
		} else if (t instanceof FairyRing) {
			FairyRing tF = (FairyRing) t;
			FairyRing best = null;
			double bDist = -1;
			for (FairyRing f : FairyRing.values()) {
				double dist = methods.calc.distanceTo(f.getLocation());
				if (bDist == -1 || dist < bDist) {
					best = f;
					bDist = dist;
				}
			}
			if (best == tF) {
				return true;
			} else if (best == FairyRing.MAIN_HUB) {
				RSObject obj;
				RSInterface spinners = methods.interfaces.get(734);
				if (spinners != null && spinners.isValid()) {
					RSComponent[] spinClockwise = new RSComponent[] {
							spinners.getComponent(23),
							spinners.getComponent(25),
							spinners.getComponent(27) };
					RSComponent[] spinAntiClockwise = new RSComponent[] {
							spinners.getComponent(24),
							spinners.getComponent(26),
							spinners.getComponent(28) };
					int[] currentChars = new int[] {
							spinners.getComponent(2).getXRotation() / 512,
							spinners.getComponent(7).getXRotation() / 512,
							spinners.getComponent(12).getXRotation() / 512 };
					int[] correctChars = new int[3];
					for (int i = 0; i < 3; i++) {
						char chr = tF.getCode().toLowerCase().charAt(i);
						if (chr == 'a' || chr == 'i' || chr == 'p')
							correctChars[i] = 0;
						else if (chr == 'b' || chr == 'j' || chr == 'q')
							correctChars[i] = 1;
						else if (chr == 'c' || chr == 'k' || chr == 'r')
							correctChars[i] = 2;
						else
							correctChars[i] = 3;
					}
					int i = 0;
					while (i < 3) {
						if (currentChars[i] != correctChars[i]) {
							int curr = currentChars[i];
							int corr = correctChars[i];
							if (corr == curr + 1) {
								if (spinAntiClockwise[i].doClick())
									sleep(10000);
							} else {
								if (spinClockwise[i].doClick())
									sleep(10000);
							}
						} else {
							i++;
						}
					}
					// TODO hit enter & testing
				} else {
					return (obj = methods.objects.getTopAt(
							FairyRing.MAIN_HUB.getLocation(),
							Objects.TYPE_FLOOR_DECORATION)) != null
							&& obj.doAction("Use");
				}
			} else {
				if (!methods.calc.tileOnScreen(best.getLocation())) {
					return methods.walking.newTilePath(
							methods.web.generateNodePath(getMyPlayer()
									.getLocation(), best.getLocation()))
							.traverse();
				} else {
					RSObject obj;
					return (obj = methods.objects.getTopAt(best.getLocation(),
							Objects.TYPE_FLOOR_DECORATION)) != null
							&& obj.doAction("Use");
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
