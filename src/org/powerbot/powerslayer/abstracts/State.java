package org.powerbot.powerslayer.abstracts;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.common.RSBotCommon;

/**
 * Created by IntelliJ IDEA.
 * User: Taylor
 * Date: 5/5/11
 * Time: 5:40 PM
 * Package: org.powerbot.powerslayer.abstracts;
 */
public abstract class State extends RSBotCommon {
    public State(PowerSlayer main) {
        super(main);
    }

    public abstract int loop();

    public abstract boolean activeCondition();
}
