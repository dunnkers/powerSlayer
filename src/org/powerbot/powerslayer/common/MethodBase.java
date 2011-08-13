package org.powerbot.powerslayer.common;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.methods.Banking;
import org.powerbot.powerslayer.methods.SlayerMasters;
import org.powerbot.powerslayer.methods.Traveling;
import org.powerbot.powerslayer.methods.UniversalFighter;

import java.util.Random;

/**
 * Created by IntelliJ IDEA. User: Taylor Date: 5/5/11 Time: 5:05 PM Package:
 * org.powerbot.powerslayer.common;
 */
public class MethodBase {
    public PowerSlayer parent = null;
    public UniversalFighter fighter = new UniversalFighter(this);
    public Banking bankingProcess = new Banking(this);
    public Traveling travel = new Traveling(this);
    public SlayerMasters masters = new SlayerMasters(this);
    public Random random = new Random();

    public MethodBase(PowerSlayer parent) {
        this.parent = parent;
    }
}
