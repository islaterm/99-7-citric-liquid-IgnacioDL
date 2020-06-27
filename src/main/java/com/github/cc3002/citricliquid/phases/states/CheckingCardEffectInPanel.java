package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class CheckingCardEffectInPanel extends State {

    /**
     * The current Player decides to play a card.
     * Cards are not implemented yet.
     * Then goes to next phase ActivatingPanelEffect.
     */
    @Override
    public void checksCardEffect(IPanel panel) {
        //no cards are implemented yet
        this.changeState(new ActivatingPanelEffect());
    }

    @Override
    public boolean isCheckingCardEffectInPanel() { return true; }
}
