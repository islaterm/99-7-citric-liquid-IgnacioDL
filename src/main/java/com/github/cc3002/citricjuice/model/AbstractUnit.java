package com.github.cc3002.citricjuice.model;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public abstract class AbstractUnit implements IUnit{
    protected final String name;
    protected final int maxHP;
    protected int atk;
    protected int currentAtk;
    protected int def;
    protected int evd;
    protected int currentHP;
    protected int stars;
    private final Random random;
    private int wins;

    /**
     * Creates a new character.
     *
     * @param name
     *     the character's name.
     * @param hp
     *     the initial (and max) hit points of the character.
     * @param atk
     *     the base damage the character does.
     * @param def
     *     the base defense of the character.
     * @param evd
     *     the base evasion of the character.
     */

    public AbstractUnit(final String name, final int hp, final int atk, final int def,
                  final int evd) {
        this.name = name;
        this.maxHP = currentHP = hp;
        this.atk = currentAtk = atk;
        this.def = def;
        this.evd = evd;
        random = new Random();
        wins = 0;
    }
    /**
     * Returns the character's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the character's max hit points.
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * Returns the current character's attack points.
     */
    public int getCurrentAtk() {
        return currentAtk;
    }
    /**
     * Returns the character's attack points.
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Returns the current character's defense points.
     */
    public int getDef() {
        return def;
    }

    /**
     * Returns the current character's evasion points.
     */
    public int getEvd() {
        return evd;
    }

    /**
     * Returns the current hit points of the character.
     */
    public int getCurrentHP() {
        return currentHP;
    }

    /**
     * Sets the current character's hit points.
     * <p>
     * The character's hit points have a constraint to always be between 0 and maxHP,
     * both inclusive.
     */
    public void setCurrentHP(final int newHP) {
        this.currentHP = Math.max(Math.min(newHP, maxHP), 0);
    }

    /**
     * Increases this player's star count by an amount.
     */
    public void increaseStarsBy(final int amount) {
        stars += amount;
    }

    /**
     * Returns this player's star count.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Reduces this player's star count by a given amount.
     * <p>
     * The star count will must always be greater or equal to 0
     */
    public void reduceStarsBy(final int amount) {
        stars = Math.max(0, stars - amount);
    }

    /**
     * Set's the seed for this player's random number generator.
     * <p>
     * The random number generator is used for taking non-deterministic decisions, this method is
     * declared to avoid non-deterministic behaviour while testing the code.
     */
    public void setSeed(final long seed) {
        random.setSeed(seed);
    }

    /**
     * Returns this units's wins count.
     */
    public int getWins() {return wins;}


    /**
     * Returns the specific amount of wins the opponent wins for defeating this type of unit.
     */
    public abstract int giveWins();

    /**
     * Increases this player's wins count depending on the amount of wins that the opponent gives.
     */
    public void increaseWins(@NotNull IUnit opponent){
        wins = this.getWins() + opponent.giveWins();
    }

    /**
     * Returns the specific amount of stars the Wild Unit opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     */
    public abstract int giveStarsToWildUnit();

    /**
     * Returns the specific amount of stars the Boss Unit opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     */
    public abstract int giveStarsToBossUnit();

    /**
     * Returns the specific amount of stars the Player opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     */
    public abstract int giveStarsToPlayer();

    /**
     * Increases the amount of Stars for this Unit and decreases the same amount of stars for the opponent.
     */
    public abstract void getStarsFromUnit(IUnit opponent);

    /**
     * Returns a uniformly distributed random value in [1, 6]
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }

    /**
     * For now it only changes the current attack for the attacker
     * with no response from the opponent.
     */
    public void attackTo(IUnit opponent) {
        currentAtk = this.getAtk() + this.roll();
    }

    /**
     * Sets a new current HP for the unit, decreased by a damage made by the opponent.
     */
    public void defends(@NotNull IUnit opponent) {
        int damage = Math.max(1, opponent.getCurrentAtk() + (this.getDef() - this.roll() ) );
        currentHP = Math.max(0, this.getCurrentHP() - damage);
    }
    /**
     * Sets a new current HP for the unit, decreased or not by a damage made by the opponent.
     */
    public void dodges(@NotNull IUnit opponent) {
        int damage = 0;
        if (this.getEvd() + this.roll() <= opponent.getCurrentAtk() ) {
            damage = opponent.getCurrentAtk();
        }
        currentHP = this.getCurrentHP() - damage;
    }
}
