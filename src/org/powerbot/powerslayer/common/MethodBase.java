package org.powerbot.powerslayer.common;

import java.util.Random;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.methods.Banking;
import org.powerbot.powerslayer.methods.SlayerMasters;
import org.powerbot.powerslayer.methods.Traveling;
import org.powerbot.powerslayer.methods.UniversalFighter;

public class MethodBase {
    public PowerSlayer parent = null;
   
    public Banking bankingProcess = new Banking(this);
    public Random random = new Random();
    public SlayerMasters masters = new SlayerMasters(this);
    public Traveling travel = new Traveling(this);
    public UniversalFighter fighter = new UniversalFighter(this);

    public MethodBase(PowerSlayer parent) {
        this.parent = parent;
    }
}
