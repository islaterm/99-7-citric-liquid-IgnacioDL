package com.github.cc3002.citricjuice.model;

import org.jetbrains.annotations.NotNull;
import java.util.Random;

/**
 * Abstract class that represents a unit in the game.
 *
 * @author Ignacio Diaz Lara.
 */
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getCurrentAtk() {
        return currentAtk;
    }

    @Override
    public int getAtk() {
        return atk;
    }

    @Override
    public int getDef() {
        return def;
    }

    @Override
    public int getEvd() {
        return evd;
    }

    @Override
    public int getCurrentHP() {
        return currentHP;
    }

    @Override
    public void setCurrentHP(final int newHP) {
        this.currentHP = Math.max(Math.min(newHP, maxHP), 0);
    }

    @Override
    public void increaseStarsBy(final int amount) {
        stars += amount;
    }

    @Override
    public int getStars() {
        return stars;
    }

    @Override
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

    @Override
    public int getWins() {return wins;}

    @Override
    public abstract int giveWins();

    @Override
    public void increaseWins(@NotNull IUnit opponent){
        wins = this.getWins() + opponent.giveWins();
    }

    @Override
    public abstract int giveStarsToWildUnit();

    @Override
    public abstract int giveStarsToBossUnit();

    @Override
    public abstract int giveStarsToPlayer();

    @Override
    public abstract void getStarsFromUnit(IUnit opponent);

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }

    @Override
    public void attackTo(IUnit opponent) {
        if (this.getCurrentHP()>0 && opponent.getCurrentHP()>0){
            currentAtk = this.getAtk() + this.roll();
        }
        else {
            throw new AssertionError("One of the units is dead");
        }
    }

    @Override
    public void defends(@NotNull IUnit opponent) {
        int damage = Math.max(1, opponent.getCurrentAtk() - (this.getDef() + this.roll() ) );
        currentHP = Math.max(0, this.getCurrentHP() - damage);
    }

    @Override
    public void dodges(@NotNull IUnit opponent) {
        int damage = 0;
        if (this.getEvd() + this.roll() <= opponent.getCurrentAtk() ) {
            damage = opponent.getCurrentAtk();
        }
        currentHP = Math.max(0, this.getCurrentHP() - damage);
    }
}
