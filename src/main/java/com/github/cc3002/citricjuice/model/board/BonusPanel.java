package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

public class BonusPanel extends AbstractPanel {

    public BonusPanel() {
        super();
    }

    /**
     * Returns the type of this panel
     */
    public String getType() {
        return "Bonus";
    }

    /**
     * Reduces the player's star count by the D6 roll multiplied by the maximum between the player's
     * norma level and three.
     */
    private static void applyBonusTo(final @NotNull Player player) {

        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));

    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    public void activatedBy(final Player player){
        applyBonusTo(player);
    }

}
