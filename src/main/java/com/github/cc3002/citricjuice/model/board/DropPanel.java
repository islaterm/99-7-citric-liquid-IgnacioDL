package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

public class DropPanel extends AbstractPanel {
    public DropPanel() {
        super();
    }

    /**
     * Returns the type of this panel
     */
    public String getType() {
        return "Drop";
    }

    /**
     * Reduces the player's star count by the D6 roll multiplied by the player's norma level.
     */
    private static void applyDropTo(final @NotNull Player player) {
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    public void activatedBy(final Player player){
        applyDropTo(player);
    }
}
