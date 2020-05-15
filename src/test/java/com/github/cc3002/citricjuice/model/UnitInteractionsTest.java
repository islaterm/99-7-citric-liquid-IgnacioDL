package com.github.cc3002.citricjuice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class UnitInteractionsTest {
    private Player Jugador1;
    private WildUnit Chicken;
    private BossUnit StoreManager;
    private Player Jugador2;
    private WildUnit RoboBall;
    private BossUnit ShifuRobot;
    private Player Jugador3;
    private WildUnit Seagull;
    private BossUnit FlyingCastle;
    private WildUnit Chicken2;
    private BossUnit StoreManager2;
    private Player Jugador4;

    @BeforeEach
    public void setUp() {
        Jugador1 = new Player ("Jugador 1", 4,1,-1,2);
        Chicken = new WildUnit("Chiken",3,-1,-1,1);
        StoreManager = new BossUnit("Store Manager", 8,3,2,-1);
        Jugador2 = new Player ("Jugador 2", 3,2,-1,2);
        RoboBall = new WildUnit("Robo Ball",3,-1,1,-1);
        ShifuRobot = new BossUnit("Shifu Robot", 7,2,3,-2);
        Jugador3 = new Player ("Jugador 3", 3,2,1,1);
        Seagull = new WildUnit("Seagull",3,1,-1,-1);
        FlyingCastle = new BossUnit("Flying Castle", 10,2,1,-3);
        Chicken2 = new WildUnit("Chiken 2",3,-1,-1,1);
        StoreManager2 = new BossUnit("Store Manager 2", 8,3,2,-1);
        Jugador4 = new Player ("Jugador 4", 3,3,0,0);
    }

    @RepeatedTest(100)
    public void unitAttacks() {
        final long testSeed = new Random().nextLong();
        Jugador1.setSeed(testSeed);
        Jugador1.attackTo(Jugador2);
        assertTrue(Jugador1.currentAtk > Jugador1.getAtk());
    }

    @RepeatedTest(100)
    public void unitDefends() {
        final long testSeed = new Random().nextLong();
        Jugador1.setSeed(testSeed);
        Jugador1.defends(Jugador3);
        assertTrue(Jugador1.getCurrentHP()<Jugador1.getMaxHP(),
                "HP is not affected for damage for seed;" + testSeed);
        assertTrue(0 <= Jugador1.getCurrentHP()
                && Jugador1.getCurrentHP() <= Jugador1.getMaxHP(),
                "HP is not in range between 0 and max HP for seed: " + testSeed);
    }

    @RepeatedTest(100)
    public void unitDodges() {
        final long testSeed = new Random().nextLong();
        Jugador4.setSeed(testSeed);
        Jugador4.dodges(Jugador3);
        assertTrue(Jugador2.getCurrentHP()<=Jugador2.getMaxHP(),
                "HP is not affected for damage for seed;" + testSeed);
        assertTrue(0 <= Jugador2.getCurrentHP()
                && Jugador2.getCurrentHP() <= Jugador2.getMaxHP(),
                "HP is not in range between 0 and max HP for seed: " + testSeed);
    }

    @Test
    public void winsIncrease() {
        Jugador1.increaseWins(Jugador2);
        Jugador2.increaseWins(Chicken);
        Jugador3.increaseWins(FlyingCastle);
        Chicken.increaseWins(Jugador3);
        RoboBall.increaseWins(Seagull);
        Seagull.increaseWins(ShifuRobot);
        StoreManager.increaseWins(Jugador1);
        ShifuRobot.increaseWins(RoboBall);
        FlyingCastle.increaseWins(StoreManager);
        assertEquals(2, Jugador1.getWins());
        assertEquals(1, Jugador2.getWins());
        assertEquals(3, Jugador3.getWins());
        assertEquals(2, Chicken.getWins());
        assertEquals(1, RoboBall.getWins());
        assertEquals(3, Seagull.getWins());
        assertEquals(2, StoreManager.getWins());
        assertEquals(1, ShifuRobot.getWins());
        assertEquals(3, FlyingCastle.getWins());
    }

    @Test
    public void starsModifications() {
        Jugador1.increaseStarsBy(10);
        Jugador2.increaseStarsBy(10);
        Jugador3.increaseStarsBy(10);
        Chicken.increaseStarsBy(10);
        RoboBall.increaseStarsBy(10);
        Seagull.increaseStarsBy(10);
        StoreManager.increaseStarsBy(10);
        ShifuRobot.increaseStarsBy(10);
        FlyingCastle.increaseStarsBy(10);
        Chicken2.increaseStarsBy(10);
        Jugador4.increaseStarsBy(20);
        Jugador1.getStarsFromUnit(Jugador2);
        Jugador2.getStarsFromUnit(Chicken);
        Jugador3.getStarsFromUnit(FlyingCastle);
        RoboBall.getStarsFromUnit(Seagull);
        ShifuRobot.getStarsFromUnit(StoreManager);
        StoreManager2.getStarsFromUnit(Chicken2);
        Chicken2.getStarsFromUnit(Jugador4);
        StoreManager2.getStarsFromUnit(Jugador4);
        Chicken2.getStarsFromUnit(StoreManager2);
        assertEquals(15, Jugador1.getStars());
        assertEquals(15, Jugador2.getStars());
        assertEquals(20, Jugador3.getStars());
        assertEquals(0, Chicken.getStars());
        assertEquals(15, RoboBall.getStars());
        assertEquals(5, Seagull.getStars());
        assertEquals(5, StoreManager.getStars());
        assertEquals(15, ShifuRobot.getStars());
        assertEquals(0, FlyingCastle.getStars());
        assertEquals(20, Chicken2.getStars());
        assertEquals(5, StoreManager2.getStars());

    }

    @Test
    public void playerStatsModifications() {
        assertEquals(1, Jugador1.getAtk());
        assertEquals(-1, Jugador1.getDef());
        assertEquals(2, Jugador1.getEvd());
        Jugador1.changePlayerAtk(5);
        Jugador1.changePlayerDef(4);
        Jugador1.changePlayerEvd(3);
        assertEquals(5, Jugador1.getAtk());
        assertEquals(4, Jugador1.getDef());
        assertEquals(3, Jugador1.getEvd());
    }
    // endregion
}
