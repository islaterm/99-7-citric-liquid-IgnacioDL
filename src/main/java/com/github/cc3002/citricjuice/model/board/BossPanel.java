package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

public class BossPanel extends AbstractPanel {

    public BossPanel() {
        super();
    }

    /**
     * Returns the type of this panel.
     */
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
