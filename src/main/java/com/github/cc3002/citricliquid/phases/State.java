package com.github.cc3002.citricliquid.phases;

import com.github.cc3002.citricjuice.model.IUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.board.IPanel;

/**
 * Class that represents a state in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class State {
    private Turn turn;

    /**
     * Sets a turn.
     */
    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    /**
     * Changes the state.
     *
     */
    protected void changeState(State state) {
        turn.setState(state);
    }

    /**
     * Returns an error.
     */
    void error() { throw new RuntimeException(); }

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void checkHP(Player currentPlayer) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void tryToRecover(Player currentPlayer, int chapter) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void receivesStars(Player currentPlayer, int chapter) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void checksCardEffect(IPanel panel) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void panelEffectActivates(IPanel panel, Player player) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void checksAWinner(Player currentPlayer) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void startNewGame() {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void playerMoves(Player currentPlayer, int steps) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void checksCardEffect(boolean playerInput) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void checksIntentionToAttack(boolean input, Player currentPlayer, IUnit enemy) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void playerMovesRemainingSteps(Player currentPlayer) {error();}

    /**
     * Returns an error, until a specific state overrides it.
     */
    public void checksEnemyDecision(boolean enemyInput, Player currentPlayer, IUnit enemy) {error();}

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isCheckingHP() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isReceivingStars() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isWaitPhaseChoosingCard() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isPlayerMoving() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isCheckingCardEffectInPanel() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isActivatingPanelEffect() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isCheckingAWinner() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isInRecoveryPhase() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isInWaitPhase() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isEndGame() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isWaitPhaseAnotherPlayer() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isWaitPhaseEncounterHomePanel() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public boolean isAttackedDecisionWaitPhase() { return false; }

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public void checksDecisionHomePanel(boolean playerInput, Player currentPlayer) {error();}

    /**
     * Returns false, until a specific state overrides it to return true.
     */
    public void checksPlayerDecision(boolean enemyInput, Player currentPlayer, IUnit enemy) {error();}
}
