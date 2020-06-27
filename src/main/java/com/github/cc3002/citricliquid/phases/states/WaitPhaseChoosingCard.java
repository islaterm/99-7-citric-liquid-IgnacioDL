package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class WaitPhaseChoosingCard extends State {

    /**
     * Checks possible card effect in the panel and activates it.
     * Then goes to next phase PlayerMoving.
     */
    @Override
    public void checksCardEffect(boolean playerInput) {
        //implements card effect, not in the game yet
        //This part is commented until cards are introduced
        /*
        if (playerInput) {
            cardEffect();
            this.changeState(new PlayerMoving());
        }
        else {
            this.changeState(new PlayerMoving());
        }*/
        this.changeState(new PlayerMoving());
    }

    @Override
    public boolean isWaitPhaseChoosingCard() { return true; }
}
