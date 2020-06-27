package com.github.cc3002.citricliquid.phases;


import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.board.BonusPanel;
import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurnTest {
    private Turn turn;
    private Player player;
    private Player player2;
    private int chapter;
    private IPanel panelHome;
    private IPanel bonusPanel;
    private int id = 1;

    @BeforeEach
    public void setUp() {
        turn = new Turn();
        player =new Player("player1", 4, 14, 1, 2);
        player2 =new Player("player1", 1, 1, 1, 2);
        chapter = 1;
        panelHome = new HomePanel(id++);
        bonusPanel = new BonusPanel(id++);
        panelHome.addNextPanel(bonusPanel);
        bonusPanel.addNextPanel(panelHome);
        player.setHomePanel(panelHome);
    }

    @Test
    public void creationTurnTest() {
        assertTrue(turn.isCheckingHP());
        assertFalse(turn.isActivatingPanelEffect());
        assertFalse(turn.isAttackedDecisionWaitPhase());
        assertFalse(turn.isCheckingAWinner());
        assertFalse(turn.isCheckingCardEffectInPanel());
        assertFalse(turn.isEndGame());
        assertFalse(turn.isInRecoveryPhase());
        assertFalse(turn.isPlayerMoving());
        assertFalse(turn.isReceivingStars());
        assertFalse(turn.isWaitPhaseAnotherPlayer());
        assertFalse(turn.isWaitPhaseChoosingCard());
        assertFalse(turn.isWaitPhaseEncounterHomePanel());
    }

    @Test
    public void firstTransitionToReceivingStarsTest() {
        turn.checkHP(player);
        assertFalse(turn.isCheckingHP());
        assertTrue(turn.isReceivingStars());
        assertFalse(turn.isInRecoveryPhase());
    }

    @Test
    public void firstTransitionToRecoveryPhase() {
        player.setCurrentHP(0);
        turn.checkHP(player);
        assertFalse(turn.isCheckingHP());
        assertFalse(turn.isReceivingStars());
        assertTrue(turn.isInRecoveryPhase());
        turn.tryToRecover(player, 6);
        assertTrue(turn.isReceivingStars());
    }

    @Test
    public void secondTransitionToWaitPhaseChoosingCardTest() {
        turn.checkHP(player);
        assertFalse(turn.isCheckingHP());
        assertTrue(turn.isReceivingStars());
        turn.receivesStars(player, chapter);
        assertEquals(1, player.getStars());
        assertFalse(turn.isReceivingStars());
        assertTrue(turn.isWaitPhaseChoosingCard());
    }

    @Test
    public void thirdTransitionToPlayerMovingTest() {
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        assertFalse(turn.isWaitPhaseChoosingCard());
        assertTrue(turn.isPlayerMoving());
    }


    @Test
    public void fourthTransitionToWaitPhaseAnotherPlayerTest() {
        player.setCurrentPanel(bonusPanel);
        player2.setCurrentPanel(panelHome);
        panelHome.addPlayer(player2);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        assertTrue(turn.isWaitPhaseAnotherPlayer());
    }

    @Test
    public void fourthTransitionToWaitPhaseEncounterHomePanelTest() {
        player.setCurrentPanel(bonusPanel);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        assertTrue(turn.isWaitPhaseEncounterHomePanel());
    }

    @Test
    public void fourthTransitionToCheckingCardEffectInPanelTest() {
        player.setCurrentPanel(bonusPanel);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksDecisionHomePanel(true, player);
        assertTrue(turn.isCheckingCardEffectInPanel());
    }

    @Test
    public void fifthTransitionToWaitPhaseEncounterHomePanelTest() {
        player.setCurrentPanel(bonusPanel);
        player2.setCurrentPanel(panelHome);
        panelHome.addPlayer(player2);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        assertTrue(turn.isWaitPhaseAnotherPlayer());
        turn.checksIntentionToAttack(false, player, player2);
        assertTrue(turn.isWaitPhaseEncounterHomePanel());
    }

    @Test
    public void fifthTransitionToAttackedDecisionWaitPhaseTest() {
        player.setCurrentPanel(bonusPanel);
        player2.setCurrentPanel(panelHome);
        panelHome.addPlayer(player2);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksIntentionToAttack(true, player, player2);
        assertTrue(turn.isAttackedDecisionWaitPhase());
    }

    @Test
    public void fifthTransitionBackToPlayerMovingTest() {
        player.setCurrentPanel(bonusPanel);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksDecisionHomePanel(false, player);
        assertTrue(turn.isPlayerMoving());
        turn.playerMovesRemainingSteps(player);
        assertTrue(turn.isWaitPhaseEncounterHomePanel());
    }


    @Test
    public void sixthTransitionToCheckingCardEffectInPanelTest() {
        player.setCurrentPanel(bonusPanel);
        player2.setCurrentPanel(panelHome);
        panelHome.addPlayer(player2);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksIntentionToAttack(true, player, player2);
        turn.checksEnemyDecision(false, player, player2);
        assertTrue(turn.isCheckingCardEffectInPanel());

    }

    @Test
    public void sixthTransitionToActivatingPanelEffectTest() {
        player.setCurrentPanel(bonusPanel);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksDecisionHomePanel(true, player);
        assertTrue(turn.isCheckingCardEffectInPanel());
        turn.checksCardEffect(player.getCurrentPanel());
        assertTrue(turn.isActivatingPanelEffect());
    }
    @Test
    public void seventhTransitionToCheckingAWinnerTest() {
        player.setCurrentPanel(bonusPanel);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksDecisionHomePanel(true, player);
        turn.checksCardEffect(player.getCurrentPanel());
        turn.panelEffectActivates(player.getCurrentPanel(), player);
        assertTrue(turn.isCheckingAWinner());
    }

    @Test
    public void eighthTransitionToStartingTurnCheckingHPTest() {
        player.setCurrentPanel(bonusPanel);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksDecisionHomePanel(true, player);
        turn.checksCardEffect(player.getCurrentPanel());
        turn.panelEffectActivates(player.getCurrentPanel(), player);
        turn.checksAWinner(player);
        assertTrue(turn.isCheckingHP());
    }
    @Test
    public void eighthTransitionToEndGameTest() {
        player.setCurrentPanel(bonusPanel);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksDecisionHomePanel(true, player);
        turn.checksCardEffect(player.getCurrentPanel());
        turn.panelEffectActivates(player.getCurrentPanel(), player);
        player.normaClear();
        player.normaClear();
        player.normaClear();
        player.normaClear();
        player.normaClear();
        turn.checksAWinner(player);
        assertTrue(turn.isEndGame());
    }

    @Test
    public void ninthTransitionToStartingTurnCheckingHPTest() {
        player.setCurrentPanel(bonusPanel);
        turn.checkHP(player);
        turn.receivesStars(player, chapter);
        turn.checksCardEffect(true);
        turn.playerMoves(player, 4);
        turn.checksDecisionHomePanel(true, player);
        turn.checksCardEffect(player.getCurrentPanel());
        turn.panelEffectActivates(player.getCurrentPanel(), player);
        player.normaClear();
        player.normaClear();
        player.normaClear();
        player.normaClear();
        player.normaClear();
        turn.checksAWinner(player);
        turn.startNewGame();
        assertTrue(turn.isCheckingHP());
    }
}
