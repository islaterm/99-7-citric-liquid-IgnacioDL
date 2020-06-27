package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class RecoveryPhase extends State {

    /**
     * The current Player rolls trying to recover. This depends
     * on the chapter. If the player recovers goes to next phase
     * ReceivingStars, otherwise its turn is over and next phase is
     * StartingTurnCheckingHP for next player.
     */
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
