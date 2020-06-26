package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

public class ReceivingStars extends State {

    @Override
    public void receivesStars(Player currentPlayer, int chapter) {
        currentPlayer.increaseStarsBy((chapter/5)+1);
        this.changeState(new WaitPhaseChoosingCard());
    }


    @Override
    public boolean isReceivingStars() { return true; }
}
