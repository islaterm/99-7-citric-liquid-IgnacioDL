package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

import java.util.Set;

public interface IPanel {

    /**
     * Adds a new adjacent panel to this one.
     *
     * @param abstractPanel
     *     the panel to be added.
     */
    void addNextPanel(final AbstractPanel abstractPanel);

    /**
     * Returns a copy of this panel's next ones.
     */
    Set<AbstractPanel> getNextPanels();

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    void activatedBy(final Player player);

    /**
     * Returns the type of the panel.
     */
    String getType();
}
