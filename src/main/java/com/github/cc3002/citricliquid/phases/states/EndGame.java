package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricliquid.phases.State;

public class EndGame extends State {

    @Override
    public void startNewGame() {
        this.changeState(new StartingTurnCheckingHP());
    }

    @Override
    public boolean isEndGame() { return true; }
}


