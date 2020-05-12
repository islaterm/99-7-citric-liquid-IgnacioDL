package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;
import org.jetbrains.annotations.NotNull;

public class BossPanel extends AbstractPanel {
    public BossPanel() {
        super();
    }

    /**
     * Returns the type of this panel
     */
    public String getType() {
        return "Boss";
    }


    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    public void activatedBy(final Player player){
    }

}
