package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class ActivatingPanelEffect extends State {

    /**
     * The panel effects activates. Then goes to
     * next phase CheckingAWinner.
     */
    @Override
    public void panelEffectActivates(IPanel panel, Player player) {
        panel.activatedBy(player);
        this.changeState(new CheckingAWinner());
    }

    @Override
    public boolean isActivatingPanelEffect() { return true; }
}
