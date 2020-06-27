package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class PlayerMoving extends State {

    /**
     * Checks if the current panel of a player has more players, then
     * goes to phase WaitPhaseAnotherPlayer; if it's a Home Panel goes
     * to phase WaitPhaseEncounterHomePanel; otherwise, goes to next phase
     * CheckingCardEffectInPanel.
     */
    @Override
    public void playerMoves(Player currentPlayer, int steps) {
        currentPlayer.move(steps);
        if (currentPlayer.getCurrentPanel().getPlayers().size()>1) {
            this.changeState(new WaitPhaseAnotherPlayer());
            return;
        }
        if (currentPlayer.getCurrentPanel().equals(currentPlayer.getHomePanel())) {
            this.changeState(new WaitPhaseEncounterHomePanel());
        }
        else {
            this.changeState(new CheckingCardEffectInPanel());
        }
    }

    /**
     * Later decisions were made by player, in case it still has
     * steps to move, the player moves the remaining states,
     * otherwise goes to next phase CheckingCardEffectInPanel.
     */
    @Override
    public void playerMovesRemainingSteps(Player currentPlayer) {
        if (currentPlayer.getRemainingSteps()<=0) {
            this.changeState(new CheckingCardEffectInPanel());
        }
        else {
            this.playerMoves(currentPlayer, currentPlayer.getRemainingSteps());
        }
    }

    @Override
    public boolean isPlayerMoving() { return true; }
}
