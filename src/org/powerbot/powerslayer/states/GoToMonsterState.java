package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.abstracts.GoToState;

public class GoToMonsterState extends GoToState {
	//TODO: Write State
    public GoToMonsterState(PowerSlayer parent) {
        super(parent);
    }

    public int loop() {
        return 0;
    }

    public boolean activeCondition() {
        return false;
    }
}
