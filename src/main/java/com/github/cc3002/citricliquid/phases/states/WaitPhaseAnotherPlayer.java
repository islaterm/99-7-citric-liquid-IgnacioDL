package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.IUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class WaitPhaseAnotherPlayer extends State {

    /**
     * The player decides to attack or not. If decides to attack,
     * checks if the enemy is dead, if so, player returns to moving phase
     * PlayerMoving; if not, the player attacks and it goes to phase
     * AttackedDecisionWaitPhase. If the player decides not to attack
     * it checks if is in its home panel, if so, it goes to phase
     * WaitPhaseEncounterHomePanel. Otherwise, goes to phase
     * PlayerMoving.
     */
    @Override
    public void checksIntentionToAttack(boolean playerInput, Player currentPlayer, IUnit enemy) {
        if (playerInput) {
            if (enemy.getCurrentHP()<=0) {
                this.changeState(new PlayerMoving());
                return;
            }
            //player activates card, not implemented yet
            currentPlayer.attackTo(enemy);
            this.changeState(new AttackedDecisionWaitPhase());
            return;
        }
        if (currentPlayer.getHomePanel().equals(currentPlayer.getCurrentPanel())) {
            this.changeState(new WaitPhaseEncounterHomePanel());
        }
        else {
            this.changeState(new PlayerMoving());
        }
    }

    @Override
    public boolean isWaitPhaseAnotherPlayer() { return true; }
}
