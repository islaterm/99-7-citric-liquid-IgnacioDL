package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

public class RecoveryPhase extends State {

    @Override
    public void tryToRecover(Player currentPlayer, int chapter) {
        int roll = currentPlayer.roll();
        if (chapter + roll == 7) {
            currentPlayer.setCurrentHP(currentPlayer.getMaxHP());
        }
        if (chapter>=6) {
            currentPlayer.setCurrentHP(currentPlayer.getMaxHP());
        }
        else {
            //next player turn
            this.changeState(new StartingTurnCheckingHP());
            return;
        }
        this.changeState(new ReceivingStars());
    }

    @Override
    public boolean isInRecoveryPhase() { return true; }
}
