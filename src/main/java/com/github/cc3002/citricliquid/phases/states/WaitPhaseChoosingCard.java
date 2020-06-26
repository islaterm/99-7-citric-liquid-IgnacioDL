package com.github.cc3002.citricliquid.phases.states;


import com.github.cc3002.citricliquid.phases.State;

public class WaitPhaseChoosingCard extends State {

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
