package com.github.cc3002.citricjuice.model;

public abstract class AbstractUnit implements IUnit{
    protected final String name;
    protected final int maxHP;
    protected final int atk;
    protected final int def;
    protected final int evd;
    protected int currentHP;

    public AbstractUnit(final String name, final int hp, final int atk, final int def,
                  final int evd) {
        this.name = name;
        this.maxHP = currentHP = hp;
        this.atk = atk;
        this.def = def;
        this.evd = evd;
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
     * The character's hit points have a constraint to always be between 0 and maxHP, both inclusive.
     */
    public void setCurrentHP(final int newHP) {
        this.currentHP = Math.max(Math.min(newHP, maxHP), 0);
    }
}
