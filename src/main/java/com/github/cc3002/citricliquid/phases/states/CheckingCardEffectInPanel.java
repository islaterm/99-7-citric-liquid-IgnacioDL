package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricliquid.phases.State;

public class CheckingCardEffectInPanel extends State {

    @Override
    public void checksCardEffect(IPanel panel) {
        //no cards are implemented yet
        this.changeState(new ActivatingPanelEffect());
    }

    @Override
    public boolean isCheckingCardEffectInPanel() { return true; }
}
