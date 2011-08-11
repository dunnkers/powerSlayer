package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.Banks;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.wrappers.Task;
import org.rsbot.script.methods.Calculations;
import org.rsbot.script.methods.Equipment;
import org.rsbot.script.wrappers.Item;
import org.rsbot.script.wrappers.Tile;

public class Traveling extends DMethodProvider {
    public Traveling(MethodBase methods) {
        super(methods);
    }

    public boolean travelToMaster(SlayerMaster master) {
        return travelTo(master.getLocation());
    }

    public boolean travelToMonster(Task task) {
        return travelTo(task.getMonster().getNearest(
                getMyPlayer().getLocation()));
    }

    public Item getEquipmentItem(int... ids) {
        for (Item i : Equipment.getItems()) {
            for (int id : ids) {
                if (id == i.getID()) {
                    return i;
                }
            }
        }
        return null;
    }

    // The default will be the closest bank to the player
    public boolean travelToBank() {
        return travelToBank(getNearestBank());
    }

    public boolean travelToBank(Banks bank) {
        return travelTo(bank.getArea().getCentralTile());
    }

    public boolean travelTo(Tile t) {
        return Web.generateRoute(getMyPlayer().getLocation(), t).execute();
    }

    public Banks getNearestBank() {
        /*
       * TODO Add a method to remove all banks that a player can not
       * reach.TODO Use the web to return a 'real' distance.
       */
        Banks best = null;
        int bDist = Integer.MAX_VALUE;
        for (Banks b : Banks.values()) {
            int dist = Calculations.distanceTo(b.getArea().getCentralTile());
            if (dist < bDist) {
                best = b;
                bDist = dist;
            }
        }
        return best;
    }

    public boolean isInBank(Tile tile) {
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
