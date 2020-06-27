package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class EndGame extends State {

    /**
     * Since a player already won, this initiates a new
     * game, goes to initial phase StartingTurnCheckingHP.
     */
    @Override
    public void startNewGame() {
        this.changeState(new StartingTurnCheckingHP());
    }

    @Override
    public boolean isEndGame() { return true; }
}


