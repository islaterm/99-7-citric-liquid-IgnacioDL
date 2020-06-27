package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

/**
 * Class that represents a Neutral panel in the board of the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class NeutralPanel extends AbstractPanel {

    /**
     * Creates a Neutral Panel.
     *
     * @param id
     *     the panel's id.
     */
    public NeutralPanel(int id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Neutral";
    }

    @Override
    public void activatedBy(final Player player){
    }
}
