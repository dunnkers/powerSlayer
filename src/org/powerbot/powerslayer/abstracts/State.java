package org.powerbot.powerslayer.abstracts;

import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;

/**
 * Created by IntelliJ IDEA. User: Taylor Date: 5/5/11 Time: 5:40 PM Package:
 * org.powerbot.powerslayer.abstracts;
 */
public abstract class State extends DMethodProvider {

	public State(MethodBase methods) {
		super(methods);
	}

	public abstract int loop();

	public abstract boolean activeCondition();
}
