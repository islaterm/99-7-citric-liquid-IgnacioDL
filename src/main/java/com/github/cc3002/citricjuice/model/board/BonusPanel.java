package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a Bonus panel in the board of the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class BonusPanel extends AbstractPanel {

    /**
     * Creates a Bonus Panel.
     *
     * @param id
     *     the panel's id.
     */
    public BonusPanel(int id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Bonus";
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     * In this case educes the player's star count by the D6 roll multiplied by the maximum between the player's
     * norma level and three.
     */
    @Override
    public void activatedBy(@NotNull final Player player){
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
    }
}
