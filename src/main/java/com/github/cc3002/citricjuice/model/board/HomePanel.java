package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

public class HomePanel extends AbstractPanel {

    public HomePanel() {
        super();
    }

    /**
     * Returns the type of this panel.
     */
    @Override
    public String getType() {
        return "Home";
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     * In this case restores a player's HP in 1.
     */
    @Override
    public void activatedBy(@NotNull final Player player){
        player.setCurrentHP(player.getCurrentHP() + 1);
    }
}
