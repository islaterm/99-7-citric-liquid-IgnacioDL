package com.github.cc3002.citricliquid.phases;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.board.IPanel;

public class State {
    private Turn turn;

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    protected void changeState(State state) {
        turn.setState(state);
    }

    void error() { throw new RuntimeException(); }

    public void checkHP(Player currentPlayer) {error();}
    public void tryToRecover(Player currentPlayer, int chapter) {error();}
    public void receivesStars(Player currentPlayer, int chapter) {error();}
    public void checksCardEffect(IPanel panel) {error();}
    public void panelEffectActivates(IPanel panel, Player player) {error();}
    public void checksAWinner(Player currentPlayer) {error();}
    public void startNewGame() {error();}
    public void playerMoves(Player currentPlayer) {error();}
    public void checksCardEffect(boolean playerInput) {error();}


    public boolean isCheckingHP() { return false; }
    public boolean isReceivingStars() { return false; }
    public boolean isWaitPhaseChoosingCard() { return false; }
    public boolean isPlayerMoving() { return false; }
    public boolean isCheckingCardEffectInPanel() { return false; }
    public boolean isActivatingPanelEffect() { return false; }
    public boolean isCheckingAWinner() { return false; }
    public boolean isInRecoveryPhase() { return false; }
    public boolean isInWaitPhase() { return false; }
    public boolean isEndGame() { return false; }
}
