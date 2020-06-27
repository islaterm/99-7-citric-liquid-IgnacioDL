package com.github.cc3002.citricliquid.phases;

import com.github.cc3002.citricjuice.model.IUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricliquid.phases.states.StartingTurnCheckingHP;

/**
 * Class that represents a Turn in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class Turn {
    private State state;

    /**
     * Creates a Turn.
     *
     */
    public Turn() {
        this.setState(new StartingTurnCheckingHP());
    }

    /**
     * Sets a State.
     *
     */
    void setState(State aState) {
        state = aState;
        state.setTurn(this);
    }

    /**
     * Checks the current Player HP. If it's more than zero,
     * advances to the next state, otherwise goes to RecoveryPhase.
     */
    public void checkHP(Player currentPlayer) {
        state.checkHP(currentPlayer);
    }

    /**
     * The current Player rolls trying to recover. This depends
     * on the chapter. If the player recovers goes to next phase
     * ReceivingStars, otherwise its turn is over and next phase is
     * StartingTurnCheckingHP for next player.
     */
    public void tryToRecover(Player currentPlayer, int chapter) {
        state.tryToRecover(currentPlayer, chapter);
    }

    /**
     * The current Player receives star depending of the chapter.
     */
    public void receivesStars(Player currentPlayer, int chapter) {
        state.receivesStars(currentPlayer, chapter);
    }

    /**
     * The current Player decides to play a card.
     * Cards are not implemented yet.
     * Then goes to next phase ActivatingPanelEffect.
     */
    public void checksCardEffect(IPanel panel)
    {state.checksCardEffect(panel);
    }

    /**
     * The panel effects activates. Then goes to
     * next phase CheckingAWinner.
     */
    public void panelEffectActivates(IPanel panel, Player currentPlayer) {
        state.panelEffectActivates(panel, currentPlayer);
    }

    /**
     * Since a player already won, this initiates a new
     * game, goes to initial phase StartingTurnCheckingHP.
     */
    public void startNewGame() {
        state.startNewGame();
    }

    /**
     * Later panel effects were activated, it is possible to have
     * a winner, this checks if the current player norma level
     * is already 6. If the game has a winner, goes to EndGame, otherwise
     * starts a new turn for next player at phase StartingTurnCheckingHP.
     *
     */
    public void checksAWinner(Player currentPlayer) {
        state.checksAWinner(currentPlayer);
    }

    /**
     * Checks if the current panel of a player has more players, then
     * goes to phase WaitPhaseAnotherPlayer; if it's a Home Panel goes
     * to phase WaitPhaseEncounterHomePanel; otherwise, goes to next phase
     * CheckingCardEffectInPanel.
     */
    public void playerMoves(Player currentPlayer, int steps) {
        state.playerMoves(currentPlayer, steps);
    }

    /**
     * Checks possible card effect in the panel and activates it.
     * Then goes to next phase PlayerMoving.
     */
    public void checksCardEffect(boolean playerInput) {
        state.checksCardEffect(playerInput);
    }

    /**
     * The player decides to attack or not. If decides to attack,
     * checks if the enemy is dead, if so, player returns to moving phase
     * PlayerMoving; if not, the player attacks and it goes to phase
     * AttackedDecisionWaitPhase. If the player decides not to attack
     * it checks if is in its home panel, if so, it goes to phase
     * WaitPhaseEncounterHomePanel. Otherwise, goes to phase
     * PlayerMoving.
     */
    public void checksIntentionToAttack(boolean input, Player currentPlayer, IUnit enemy) {
        state.checksIntentionToAttack(input, currentPlayer, enemy);
    }

    /**
     * The player decides if stays in the panel goes to
     * CheckingCardEffectInPanel, otherwise goes to
     * phase PlayerMoving.
     */
    public void checksDecisionHomePanel(boolean playerInput, Player currentPlayer) {
        state.checksDecisionHomePanel(playerInput,currentPlayer);
    }

    /**
     * Later decisions were made by player, in case it still has
     * steps to move, the player moves the remaining states,
     * otherwise goes to next phase CheckingCardEffectInPanel.
     */
    public void playerMovesRemainingSteps(Player currentPlayer) {
        state.playerMovesRemainingSteps(currentPlayer);
    }

    /**
     * The Enemy decides to dodge or defends. If the enemy dies,
     * the player obtains wins and stars from it, and it goes to
     * phase CheckingCardEffectInPanel. If the enemy don't
     * die, it goes to phase AttackedDecisionWaitPhase.
     */
    public void checksEnemyDecision(boolean enemyInput, Player currentPlayer, IUnit enemy) {
        state.checksEnemyDecision(enemyInput, currentPlayer, enemy);
    }

    /**
     * The player decides to dodge or defend the counter attack. If the player dies,
     * the enemy obtains wins and stars from it, and it goes to
     * phase StartingTurnCheckingHP. If the player don't
     * die, it goes to phase AttackedDecisionWaitPhase.
     */
    public void checksPlayerDecision(boolean enemyInput, Player currentPlayer, IUnit enemy) {
        state.checksPlayerDecision(enemyInput, currentPlayer, enemy);
    }

    /**
     * Returns true if the turn is in the isCheckingHP state.
     */
    public boolean isCheckingHP() {
        return state.isCheckingHP();
    }

    /**
     * Returns true if the turn is in the isReceivingStars state.
     */
    public boolean isReceivingStars() {
        return state.isReceivingStars();
    }

    /**
     * Returns true if the turn is in the isWaitPhaseChoosingCard state.
     */
    public boolean isWaitPhaseChoosingCard() {
        return state.isWaitPhaseChoosingCard();
    }

    /**
     * Returns true if the turn is in the isPlayerMoving state.
     */
    public boolean isPlayerMoving() {
        return state.isPlayerMoving();
    }

    /**
     * Returns true if the turn is in the isCheckingCardEffectInPanel state.
     */
    public boolean isCheckingCardEffectInPanel() {
        return state.isCheckingCardEffectInPanel();
    }

    /**
     * Returns true if the turn is in the isActivatingPanelEffect state.
     */
    public boolean isActivatingPanelEffect() {
        return state.isActivatingPanelEffect();
    }

    /**
     * Returns true if the turn is in the isCheckingAWinner state.
     */
    public boolean isCheckingAWinner() {
        return state.isCheckingAWinner();
    }

    /**
     * Returns true if the turn is in the isInRecoveryPhase state.
     */
    public boolean isInRecoveryPhase() {
        return state.isInRecoveryPhase();
    }


    /**
     * Returns true if the turn is in the isEndGame state.
     */
    public boolean isEndGame() {
        return state.isEndGame();
    }

    /**
     * Returns true if the turn is in the isWaitPhaseAnotherPlayer state.
     */
    public boolean isWaitPhaseAnotherPlayer() {
        return state.isWaitPhaseAnotherPlayer();
    }

    /**
     * Returns true if the turn is in the isWaitPhaseEncounterHomePanel state.
     */
    public boolean isWaitPhaseEncounterHomePanel() {
        return state.isWaitPhaseEncounterHomePanel();
    }

    /**
     * Returns true if the turn is in the isAttackedDecisionWaitPhase state.
     */
    public boolean isAttackedDecisionWaitPhase() {
        return state.isAttackedDecisionWaitPhase();
    }
}
