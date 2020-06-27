package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class WaitPhaseEncounterHomePanel extends State {

    /**
     * The player decides if stays in the panel goes to
     * CheckingCardEffectInPanel, otherwise goes to
     * phase PlayerMoving.
     */
    @Override
    public void checksDecisionHomePanel(boolean playerInput, Player currentPlayer) {
        if (playerInput){
            this.changeState(new CheckingCardEffectInPanel());
        }
        else {
            this.changeState(new PlayerMoving());
        }
    }

    @Override
    public boolean isWaitPhaseEncounterHomePanel() { return true; }
}
