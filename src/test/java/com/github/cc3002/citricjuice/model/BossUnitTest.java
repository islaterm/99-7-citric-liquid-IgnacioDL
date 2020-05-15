package com.github.cc3002.citricjuice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BossUnitTest {
    private final static String PLAYER_NAME = "BossUnit";
    private BossUnit BossU;

    @BeforeEach
    public void setUp() {
        BossU = new BossUnit(PLAYER_NAME,4, 1, -1, 2);
    }

    @Test
    public void constructorTest() {
        final var expectedBossUnit = new BossUnit(PLAYER_NAME, 4, 1, -1, 2);
        assertEquals(expectedBossUnit, BossU);
    }

    @Test
    public void testEqualsWildUnit() {
        final var o = new Object();
        assertNotEquals(BossU, o);
        assertEquals(BossU, BossU);
        final var expectedBossUnit = new BossUnit("BossUnit", 4, 1, -1, 2);
        assertEquals(expectedBossUnit, BossU);
    }

    @Test
    public void hitPointsTest() {
        assertEquals(BossU.getMaxHP(), BossU.getCurrentHP());
        BossU.setCurrentHP(2);
        assertEquals(2, BossU.getCurrentHP());
        BossU.setCurrentHP(-1);
        assertEquals(0, BossU.getCurrentHP());
        BossU.setCurrentHP(5);
        assertEquals(4, BossU.getCurrentHP());
    }

    // region : consistency tests
    @RepeatedTest(100)
    public void hitPointsConsistencyTest() {
        final long testSeed = new Random().nextLong();
        // We're gonna try and set random hit points in [-maxHP * 2, maxHP * 2]
        final int testHP = new Random(testSeed).nextInt(4 * BossU.getMaxHP() + 1)
                - 2 * BossU.getMaxHP();
        BossU.setCurrentHP(testHP);
        assertTrue(0 <= BossU.getCurrentHP()
                        && BossU.getCurrentHP() <= BossU.getMaxHP(),
                BossU.getCurrentHP() + "is not a valid HP value"
                        + System.lineSeparator() + "Test failed with random seed: "
                        + testSeed);
    }

    @RepeatedTest(100)
    public void rollConsistencyTest() {
        final long testSeed = new Random().nextLong();
        BossU.setSeed(testSeed);
        final int roll = BossU.roll();
        assertTrue(roll >= 1 && roll <= 6,
                roll + "is not in [1, 6]" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);
    }
    // endregion
}
