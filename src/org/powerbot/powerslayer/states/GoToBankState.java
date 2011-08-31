package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.abstracts.GoToState;

public class GoToBankState extends GoToState {
	//TODO: Write State
    public GoToBankState(PowerSlayer parent) {
        super(parent);
    }

    public int loop() {
        return 0;
    }

    public boolean activeCondition() {
        return false;
    }
}
