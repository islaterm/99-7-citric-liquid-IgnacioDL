package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class StartingTurnCheckingHP extends State {

    /**
     * Checks the current Player HP. If it's more than zero,
     * advances to the next state, otherwise goes to RecoveryPhase.
     */
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
