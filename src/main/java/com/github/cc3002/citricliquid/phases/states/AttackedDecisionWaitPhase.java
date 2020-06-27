package com.github.cc3002.citricliquid.phases.states;

import com.github.cc3002.citricjuice.model.IUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.phases.State;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class AttackedDecisionWaitPhase extends State {

    /**
     * The Enemy decides to dodge or defends. If the enemy dies,
     * the player obtains wins and stars from it, and it goes to
     * phase CheckingCardEffectInPanel. If the enemy don't
     * die, it goes to phase AttackedDecisionWaitPhase.
     */
    @Override
    public void checksEnemyDecision(boolean enemyInput, Player currentPlayer, IUnit enemy) {
        if (enemyInput) {
            enemy.dodges(currentPlayer);
        }
        else {
            enemy.defends(currentPlayer);
        }
        if (enemy.getCurrentHP()<=0){
            currentPlayer.getStarsFromUnit(enemy);
            currentPlayer.increaseWins(enemy);
            this.changeState(new CheckingCardEffectInPanel());
        }
        else {
            enemy.attackTo(currentPlayer);
            this.changeState(new AttackedDecisionWaitPhase());
        }
    }

    /**
     * The player decides to dodge or defend the counter attack. If the player dies,
     * the enemy obtains wins and stars from it, and it goes to
     * phase StartingTurnCheckingHP. If the player don't
     * die, it goes to phase AttackedDecisionWaitPhase.
     */
    @Override
    public void checksPlayerDecision(boolean enemyInput, Player currentPlayer, IUnit enemy) {
        if (enemyInput) {
            currentPlayer.dodges(enemy);
        }
        else {
            currentPlayer.defends(enemy);
        }
        if (currentPlayer.getCurrentHP()<=0){
            enemy.getStarsFromUnit(currentPlayer);
            enemy.increaseWins(currentPlayer);
            //new turn for next player
            this.changeState(new StartingTurnCheckingHP());
        }
        else {
            currentPlayer.attackTo(enemy);
            this.changeState(new AttackedDecisionWaitPhase());
        }
    }

    @Override
    public boolean isAttackedDecisionWaitPhase() { return true; }
}
