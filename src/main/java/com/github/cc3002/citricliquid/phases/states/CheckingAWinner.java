package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

public class CheckingAWinner extends State {

    @Override
    public void checksAWinner(Player currentPlayer) {
        if (currentPlayer.getNormaLevel()<6) {
            this.changeState(new StartingTurnCheckingHP());
        }
        else {
            // new Turn
            this.changeState(new EndGame());
        }
    }

    @Override
    public boolean isCheckingAWinner() { return true; }
}
