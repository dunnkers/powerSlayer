package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.Banks;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.wrappers.Task;
import org.rsbot.script.methods.Calculations;
import org.rsbot.script.wrappers.Tile;

//TODO: Convert to QS Once it comes out
public class Traveling extends DMethodProvider {
    public Traveling(MethodBase methods) {
        super(methods);
    }

    public boolean travelToMaster(SlayerMaster master) {
        return travelTo(master.getLocation());
    }

    public boolean travelToSlayerLocation(Task task) {
	    return travelTo(task.getMonster().getLocationProfile().getBestLocation().getSlayerLocation().getTile());
    }

    // The default will be the closest bank to the player
    public boolean travelToBank() {
        return travelToBank(getNearestBank());
    }

    public boolean travelToBank(Banks bank) {
        return travelTo(bank.getArea().getCentralTile());
    }

    public boolean travelTo(Tile t) {
        //return Web.generateRoute(getMyPlayer().getLocation(), t).execute();
	    return false;
    }

    public Banks getNearestBank() {
        /*
       * TODO Add a method to remove all banks that a player can not  reach.
       * TODO Use the web to return a 'real' distance.
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
}
