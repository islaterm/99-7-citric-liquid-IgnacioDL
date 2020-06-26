package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

public class PlayerMoving extends State {

    @Override
    public void playerMoves(Player currentPlayer) {
        currentPlayer.move();
        if (currentPlayer.getCurrentPanel().getPlayers().size()>1) {
            this.changeState(new WaitPhase());
            return;
        }
        if (currentPlayer.getCurrentPanel().equals(currentPlayer.getHomePanel())) {
            this.changeState(new WaitPhase());
            return;
        }
        if (currentPlayer.getCurrentPanel().getNextPanels().size()>1) {
            this.changeState(new WaitPhase());
        }
        else {
            this.changeState(new CheckingCardEffectInPanel());
        }
    }

    @Override
    public boolean isPlayerMoving() { return true; }
}
