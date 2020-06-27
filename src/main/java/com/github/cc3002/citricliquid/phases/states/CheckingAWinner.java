package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class CheckingAWinner extends State {

    /**
     * Later panel effects were activated, it is possible to have
     * a winner, this checks if the current player norma level
     * is already 6. If the game has a winner, goes to EndGame, otherwise
     * starts a new turn for next player at phase StartingTurnCheckingHP.
     *
     */
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
