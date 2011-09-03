package org.powerbot.powerslayer.abstracts;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.common.DMethodProvider;


public abstract class State extends DMethodProvider {

	
    public State(PowerSlayer parent) {
    	super(parent);
    }

    public abstract int loop();

    public abstract boolean activeCondition();
}
