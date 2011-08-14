package org.powerbot.powerslayer.abstracts;

import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;


public abstract class State extends DMethodProvider {

    public State(MethodBase methods) {
        super(methods);
    }

    public abstract int loop();

    public abstract boolean activeCondition();
}
