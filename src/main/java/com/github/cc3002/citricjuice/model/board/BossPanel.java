package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

/**
 * Class that represents a Boss panel in the board of the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class BossPanel extends AbstractPanel {

    /**
     * Creates a new Boss Panel.
     *
     */
    public BossPanel() {
        super();
    }

    /**
     * Creates a Boss Panel.
     *
     * @param id
     *     the panel's id.
     */
    public BossPanel(int id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Boss";
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    @Override
    public void activatedBy(final Player player){ }
}
