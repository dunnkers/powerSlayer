package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.common.MethodBase;

public class BankingState extends State {

    public BankingState(MethodBase methods) {
        super(methods);
    }

    @Override
    public int loop() {
        if (methods.travel.isInBank(getMyPlayer().getLocation())) {
            methods.parent.paint.Current = "Completing banking phase.";
            methods.bankingProcess.doBanking();
        } else {
            methods.parent.paint.Current = "Traveling to nearest bank.";
            methods.travel.travelToBank();
        }
        return 0;
    }

    @Override
    public boolean activeCondition() {
        return !methods.parent.isFullyEquipped(methods.parent.currentTask
                .getRequirements());
    }
}