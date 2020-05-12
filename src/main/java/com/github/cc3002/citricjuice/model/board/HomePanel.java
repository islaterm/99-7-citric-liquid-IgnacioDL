package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

public class HomePanel extends AbstractPanel {

    public HomePanel() {
        super();
    }

    /**
     * Returns the type of this panel
     */
    public String getType() {
        return "Home";
    }

    /**
     * Restores a player's HP in 1.
     */
    private static void applyHealTo(final @NotNull Player player) {
        player.setCurrentHP(player.getCurrentHP() + 1);
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    public void activatedBy(final Player player){
        applyHealTo(player);
    }
}
