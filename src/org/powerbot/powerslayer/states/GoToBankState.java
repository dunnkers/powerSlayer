package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.abstracts.GoToState;
import org.powerbot.powerslayer.common.MethodBase;

public class GoToBankState extends GoToState {
	//TODO: Write State
    public GoToBankState(MethodBase methods) {
        super(methods);
    }

    public int loop() {
        return 0;
    }

    public boolean activeCondition() {
        return false;
    }
}
