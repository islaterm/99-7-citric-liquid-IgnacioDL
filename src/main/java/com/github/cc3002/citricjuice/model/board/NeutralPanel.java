package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

public class NeutralPanel extends AbstractPanel {

    public NeutralPanel() {
        super();
    }

    /**
     * Returns the type of this panel.
     */
    @Override
    public String getType() {
        return "Neutral";
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    @Override
    public void activatedBy(final Player player){
    }
}
