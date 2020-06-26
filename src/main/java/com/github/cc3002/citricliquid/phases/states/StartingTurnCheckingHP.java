package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

public class StartingTurnCheckingHP extends State {

    @Override
    public void checkHP(Player currentPlayer) {
        if (currentPlayer.getCurrentHP()>0) {
            this.changeState(new ReceivingStars());
        }
        else {
            this.changeState(new RecoveryPhase());
        }
    }

    @Override
    public boolean isCheckingHP() { return true; }
}
