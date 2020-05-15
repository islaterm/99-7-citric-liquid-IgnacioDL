package com.github.cc3002.citricjuice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WildUnitTest {
    private final static String PLAYER_NAME = "WildUnit";
    private WildUnit WildU;

    @BeforeEach
    public void setUp() {
        WildU = new WildUnit(PLAYER_NAME,4, 1, -1, 2);
    }

    @Test
    public void constructorTest() {
        final var expectedWildU = new WildUnit(PLAYER_NAME, 4, 1, -1, 2);
        assertEquals(expectedWildU, WildU);
    }

    @Test
    public void testEqualsWildUnit() {
        final var o = new Object();
        assertNotEquals(WildU, o);
        assertEquals(WildU, WildU);
        final var expectedWildU = new WildUnit("WildUnit", 4, 1, -1, 2);
        assertEquals(expectedWildU, WildU);
    }

    @Test
    public void hitPointsTest() {
        assertEquals(WildU.getMaxHP(), WildU.getCurrentHP());
        WildU.setCurrentHP(2);
        assertEquals(2, WildU.getCurrentHP());
        WildU.setCurrentHP(-1);
        assertEquals(0, WildU.getCurrentHP());
        WildU.setCurrentHP(5);
        assertEquals(4, WildU.getCurrentHP());
    }

    // region : consistency tests
    @RepeatedTest(100)
    public void hitPointsConsistencyTest() {
        final long testSeed = new Random().nextLong();
        // We're gonna try and set random hit points in [-maxHP * 2, maxHP * 2]
        final int testHP = new Random(testSeed).nextInt(4 * WildU.getMaxHP() + 1)
                - 2 * WildU.getMaxHP();
        WildU.setCurrentHP(testHP);
        assertTrue(0 <= WildU.getCurrentHP()
                        && WildU.getCurrentHP() <= WildU.getMaxHP(),
                WildU.getCurrentHP() + "is not a valid HP value"
                        + System.lineSeparator() + "Test failed with random seed: "
                        + testSeed);
    }

    @RepeatedTest(100)
    public void rollConsistencyTest() {
        final long testSeed = new Random().nextLong();
        WildU.setSeed(testSeed);
        final int roll = WildU.roll();
        assertTrue(roll >= 1 && roll <= 6,
                roll + "is not in [1, 6]" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);
    }
    // endregion
}
