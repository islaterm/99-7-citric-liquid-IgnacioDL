package com.github.cc3002.citricliquid.phases;

import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricliquid.phases.states.StartingTurnCheckingHP;

public class Turn {
    private State state;

    public Turn() {
        this.setState(new StartingTurnCheckingHP());
    }

    void setState(State aState) {
        state = aState;
        state.setTurn(this);
    }

    public void checkHP(Player currentPlayer) {
        state.checkHP(currentPlayer);
    }
    public void tryToRecover(Player currentPlayer, int chapter) {
        state.tryToRecover(currentPlayer, chapter);
    }
    public void receivesStars(Player currentPlayer, int chapter) {
        state.receivesStars(currentPlayer, chapter);
    }
    public void checksCardEffect(IPanel panel)
    {state.checksCardEffect(panel);
    }

    public void panelEffectActivates(IPanel panel, Player currentPlayer) {
        state.panelEffectActivates(panel, currentPlayer);
    }

    public void startNewGame() {
        state.startNewGame();
    }

    public void checksAWinner(Player currentPlayer) {
        state.checksAWinner(currentPlayer);
    }
    public void playerMoves(Player currentPlayer) {
        state.playerMoves(currentPlayer);
    }

    public void checksCardEffect(boolean playerInput) {
        state.checksCardEffect(playerInput);
    }





    public boolean isCheckingHP() { return state.isCheckingHP(); }
    public boolean isReceivingStars() { return state.isReceivingStars(); }
    public boolean isWaitPhaseChoosingCard() { return state.isWaitPhaseChoosingCard(); }
    public boolean isPlayerMoving() { return state.isPlayerMoving(); }
    public boolean isCheckingCardEffectInPanel() { return state.isCheckingCardEffectInPanel(); }
    public boolean isActivatingPanelEffect() { return state.isActivatingPanelEffect(); }
    public boolean isCheckingAWinner() { return state.isCheckingAWinner(); }
    public boolean isInRecoveryPhase() { return state.isInRecoveryPhase(); }
    public boolean isInWaitPhase() { return state.isInWaitPhase(); }
    public boolean isEndGame() { return state.isEndGame(); }
}
