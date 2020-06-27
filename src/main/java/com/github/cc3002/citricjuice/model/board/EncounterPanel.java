package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

/**
 * Class that represents a Encounter panel in the board of the game.
 *
 * @author Ignacio Diaz Lara
 */
public class EncounterPanel extends AbstractPanel {

    /**
     * Creates a Encounter Panel.
     *
     * @param id
     *     the panel's id.
     */
    public EncounterPanel(int id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Encounter";
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    @Override
    public void activatedBy(final Player player){ }
}

