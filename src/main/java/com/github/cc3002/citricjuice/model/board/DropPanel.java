package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a Drop panel in the board of the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class DropPanel extends AbstractPanel {

    /**
     * Creates a Drop Panel.
     *
     * @param id
     *     the panel's id.
     */
    public DropPanel(int id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Drop";
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     * In this case Reduces the player's star count by the D6 roll multiplied by the player's norma level.
     */
    @Override
    public void activatedBy(@NotNull final Player player){
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
    }
}
