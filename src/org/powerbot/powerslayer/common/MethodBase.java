package org.powerbot.powerslayer.common;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.methods.SlayerMasters;
import org.powerbot.powerslayer.methods.Traveling;
import org.powerbot.powerslayer.methods.UniversalFighter;

import java.util.Random;

public class MethodBase {
    public PowerSlayer parent = null;


    public SlayerMasters masters = new SlayerMasters(this);
    public Traveling travel = new Traveling(this);
    public UniversalFighter fighter = new UniversalFighter(this);

	public Random random = new Random();

    public MethodBase(PowerSlayer parent) {
        this.parent = parent;
    }
}
