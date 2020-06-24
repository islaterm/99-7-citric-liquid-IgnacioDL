package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

public class EncounterPanel extends AbstractPanel {

    public EncounterPanel() {
        super();
    }

    public EncounterPanel(int id) {
        super(id);
    }
    /**
     * Returns the type of this panel.
     */
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

