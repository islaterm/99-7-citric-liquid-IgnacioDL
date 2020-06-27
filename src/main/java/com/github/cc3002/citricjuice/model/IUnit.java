package com.github.cc3002.citricjuice.model;

/**
 * Interface that represents a unit in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public interface IUnit {

    /**
     * Returns the character's name.
     */
    String getName();

    /**
     * Returns the character's max hit points.
     */
    int getMaxHP();

    /**
     * Returns the current character's attack points.
     */
    int getCurrentAtk();

    /**
     * Returns the character's attack points.
     */
    int getAtk();

    /**
     * Returns the current character's defense points.
     */
    int getDef();

    /**
     * Returns the current character's evasion points.
     */
    int getEvd();

    /**
     * Returns the current hit points of the character.
     */
    int getCurrentHP();

    /**
     * Sets the current character's hit points.
     * <p>
     * The character's hit points have a constraint to always be between 0 and maxHP,
     * both inclusive.
     */
    void setCurrentHP(final int newHP);

    /**
     * Returns this player's star count.
     */
    int getStars();

    /**
     * Increases this player's star count by an amount.
     */
    void increaseStarsBy(final int amount);

    /**
     * Reduces this player's star count by a given amount.
     * <p>
     * The star count will must always be greater or equal to 0.
     */
    void reduceStarsBy(final int amount);

    /**
     * Returns this units's wins count.
     */
    int getWins();

    /**
     * Returns the specific amount of wins the opponent wins for defeating this type of unit.
     */
    int giveWins();

    /**
     * Increases this player's wins count depending on the amount of wins that the opponent gives.
     */
    void increaseWins(IUnit opponent);

    /**
     * Returns the specific amount of stars the Wild Unit opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     */
    int giveStarsToWildUnit();

    /**
     * Returns the specific amount of stars the Boss Unit opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     */
    int giveStarsToBossUnit();

    /**
     * Returns the specific amount of stars the Player opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     */
    int giveStarsToPlayer();

    /**
     * Increases the amount of Stars for this Unit and decreases the same amount of stars for the opponent.
     */
    void getStarsFromUnit(IUnit opponent);

    /**
     * Returns a uniformly distributed random value in [1, 6]
     */
    int roll();

    /**
     * For now it only changes the current attack for the attacker
     * with no response from the opponent.
     */
    void attackTo(IUnit opponent);

    /**
     * Sets a new current HP for the unit, decreased by a damage made by the opponent.
     */
    void defends(IUnit opponent);

    /**
     * Sets a new current HP for the unit, decreased or not by a damage made by the opponent.
     */
    void dodges(IUnit opponent);
}