package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a Home panel in the board of the game.
 *
 * @author Ignacio Diaz Lara
 */
public class HomePanel extends AbstractPanel {

    /**
     * Creates a Home Panel.
     *
     * @param id
     *     the panel's id.
     */
    public HomePanel(int id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Home";
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     * In this case does a norma check and restores a player's HP in 1.
     */
    @Override
    public void activatedBy(@NotNull final Player player){
        player.normaCheck();
        player.setCurrentHP(player.getCurrentHP() + 1);
    }
}
