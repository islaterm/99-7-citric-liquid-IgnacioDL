package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

import java.util.ArrayList;
import java.util.Set;

public interface IPanel {

    /**
     * Adds a new adjacent panel to this one.
     *
     * @param IPanel
     *     the panel to be added.
     */
    void addNextPanel(final IPanel IPanel);

    /**
     * Returns a copy of this panel's next ones.
     */
    Set<IPanel> getNextPanels();

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    void activatedBy(final Player player);

    /**
     * Returns the type of the panel.
     */
    String getType();

    /**
     * Returns the id of the panel.
     */
    int getId();

    /**
     * Returns the array of players in the panel.
     */
    ArrayList<Player> getPlayers();

    /**
     * Removes a player from the array of players.
     */
    void removerPlayer(Player player);

    /**
     * Adds a player from the array of players.
     */
    void addPlayer(Player player);
}
