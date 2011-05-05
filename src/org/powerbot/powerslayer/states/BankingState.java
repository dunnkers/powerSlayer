package org.powerbot.powerslayer.states;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.abstracts.State;

public class BankingState extends State {

    public BankingState(PowerSlayer main) {
        super(main);
    }

    @Override
    public int loop() {
        if (methods.travel.isInBank(main.getMyPlayer().getLocation())) {
            methods.paint.Current = "Completing banking phase.";
            methods.banking.doBanking();
        } else {
            methods.paint.Current = "Traveling to nearest bank.";
            methods.travel.travelToBank();
        }
        return 0;
    }

    @Override
    public boolean activeCondition() {
        return !main.isFullyEquiped(main.currentTask.getRequirements());
    }
}