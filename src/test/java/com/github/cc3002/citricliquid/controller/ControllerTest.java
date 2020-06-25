package com.github.cc3002.citricliquid.controller;


import com.github.cc3002.citricjuice.model.BossUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.WildUnit;
import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricliquid.model.NormaGoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test suite for the controller.
 *
 * @author Ignacio Diaz Lara.
 */
public class ControllerTest {
    private final Random random = new Random();
    private HomePanel testHomePanel;
    private NeutralPanel testNeutralPanel;
    private BonusPanel testBonusPanel;
    private DropPanel testDropPanel;
    private EncounterPanel testEncounterPanel;
    private BossPanel testBossPanel;
    private Player player1;
    private long testSeed;
    private GameController controller = new GameController();

    @BeforeEach
    public void setUp() {
        testBonusPanel = controller.createBonusPanel(0);
        testBossPanel = controller.createBossPanel(1);
        testDropPanel = controller.createDropPanel(2);
        testEncounterPanel = controller.createEncounterPanel(3);
        testHomePanel = controller.createHomePanel(4);
        testNeutralPanel = controller.createNeutralPanel(5);
        testSeed = new Random().nextLong();
        player1 = controller.createPlayer("Player 1", 4, 1, -1, 2, testHomePanel);
    }


    @Test
    public void getPanelsTest() {
        assertTrue(controller.getPanels().size() == 6,
                "The expected amount of panels doesn't match the actual one");
        assertTrue(controller.getPanels().contains(testBonusPanel),
                "The added panel is not correctly stored in the controller");
        assertTrue(controller.getPanels().contains(testBossPanel),
                "The added panel is not correctly stored in the controller");
        assertTrue(controller.getPanels().contains(testDropPanel),
                "The added panel is not correctly stored in the controller");
        assertTrue(controller.getPanels().contains(testEncounterPanel),
                "The added panel is not correctly stored in the controller");
        assertTrue(controller.getPanels().contains(testHomePanel),
                "The added panel is not correctly stored in the controller");
        assertTrue(controller.getPanels().contains(testNeutralPanel),
                "The added panel is not correctly stored in the controller");

    }

    @Test
    public void nextPanelsTest() {
        assertTrue(testBonusPanel.getNextPanels().isEmpty(),
                "The panel shouldn't have panels if none has been added");
        controller.setNextPanel(testBonusPanel,testBonusPanel);
        assertTrue(testBonusPanel.getNextPanels().isEmpty(),
                "A panel shouldn't be able to add itself as next");
        controller.setNextPanel(testBonusPanel,testBossPanel);
        assertTrue(testBonusPanel.getNextPanels().size() == 1,
                "The amount of next panels does not match the actual one");
        controller.setNextPanel(testBonusPanel,testDropPanel);
        controller.setNextPanel(testBonusPanel,testEncounterPanel);
        controller.setNextPanel(testBonusPanel,testHomePanel);
        controller.setNextPanel(testBonusPanel,testNeutralPanel);
        assertTrue(testBonusPanel.getNextPanels().size() == 5,
                "The amount of next panels does not match the actual one");

    }

    @Test
    public void controllerCreatesPlayerTest() {
        assertTrue(player1.getCurrentPanel().getId() == testHomePanel.getId(),
                "The initial panel is not the same");
        assertTrue(player1.getHomePanel().getType() == "Home",
                "The home panel is not a Home Panel");
        assertTrue(player1.getCurrentPanel().getPlayers().contains(player1),
                "The initial panel does not contains the player without any movement");
    }

    @Test
    public void getPlayerCurrentPanelTest() {
        assertTrue(player1.getCurrentPanel()==controller.getPlayerPanel(player1),
                "Current panel of the player does not match with actual one");
        player1.setCurrentPanel(testBossPanel);
        assertTrue(player1.getCurrentPanel()==controller.getPlayerPanel(player1),
                "Current panel of the player does not match with actual one");
    }


    @Test
    public void setHomePanelTest() {
        assertEquals(player1.getHomePanel(),testHomePanel);
        controller.setPlayerHome(player1, testNeutralPanel);
        assertEquals(player1.getHomePanel(), testNeutralPanel);
    }

    @Test
    public void controllerCreatesOthersUnitsTest() {
        BossUnit bossUnit = controller.createBossUnit("Store Manager", 8,3,2,-1);
        assertTrue(bossUnit.getType()=="BossUnit",
                "The type does not match with actual type");
        WildUnit wildUnit = controller.createWildUnit("Robo Ball",3,-1,1,-1);
        assertTrue(wildUnit.getType()=="WildUnit",
                "The type does not match with actual type");
    }

    @Test
    public void turnOwnerTest() {
        assertEquals(player1, controller.getTurnOwner());
        Player player2 = controller.createPlayer("Player 1", 4, 1, -1, 2, testHomePanel);
        assertEquals(player1, controller.getTurnOwner());
        controller.endTurn();
        assertEquals(player2, controller.getTurnOwner());
    }

    @Test
    public void setNormaGoalTest() {
        assertTrue(player1.getNormaGoal()==NormaGoal.STARS,
                "Players should begin with a star norma goal");
        controller.setCurrPlayerNormaGoal(NormaGoal.WINS);
        assertTrue(player1.getNormaGoal()==NormaGoal.WINS,
                "The norma goal does not match the actual one");
    }

    @Test
    public void endTurnAndChapterTest() {
        assertTrue(controller.getChapter()==1, "First chapter should be 1");
        controller.endTurn();
        assertTrue(controller.getChapter()==2, "This chapter should be 2");
        controller.endTurn();
        controller.endTurn();
        controller.endTurn();
        assertTrue(controller.getChapter()==5, "This chapter should be 5");
    }

    @Test
    public void getWinnerTest() {
        player1.increaseStarsBy(200);
        player1.normaCheck();
        player1.normaCheck();
        player1.normaCheck();
        player1.normaCheck();
        player1.normaCheck();
        assertEquals(player1, controller.getWinner());
    }

    @Test
    public void moverPlayerTest() {
        testHomePanel.addNextPanel(testBonusPanel);
        controller.movePlayer();
        assertEquals(player1.getCurrentPanel(),testBonusPanel);
        testBonusPanel.addNextPanel(testHomePanel);
        controller.movePlayer();
        assertEquals(player1.getCurrentPanel(),testHomePanel);
    }
}


