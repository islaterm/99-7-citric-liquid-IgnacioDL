package com.github.cc3002.citricjuice.model;

/**
 * Abstract class that represents a enemy unit in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public abstract class AbstractEnemy extends AbstractUnit{

    /**
     * Creates a new character.
     *
     * @param name the character's name.
     * @param hp   the initial (and max) hit points of the character.
     * @param atk  the base damage the character does.
     * @param def  the base defense of the character.
     * @param evd  the base evasion of the character.
     */
    public AbstractEnemy(String name, int hp, int atk, int def, int evd) {
        super(name, hp, atk, def, evd);
    }

    /**
     * Returns the specific amount of stars the Wild Unit opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     * In this case half of the stars of the Unit.
     */
    @Override
    public int giveStarsToWildUnit() {
        int starsToGive = (int) (this.getStars() * 0.5);
        this.reduceStarsBy(starsToGive);
        return starsToGive;
    }

    /**
     * Returns the specific amount of stars the Boss Unit opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     * In this case half of the stars of the Unit.
     */
    @Override
    public int giveStarsToBossUnit() {
        int starsToGive = (int) (this.getStars() * 0.5);
        this.reduceStarsBy(starsToGive);
        return starsToGive;
    }

    /**
     * Returns the specific amount of stars the Player opponent wins for defeating this type of unit
     * and decrease the same amount of stars for the opponent.
     * In this case all of the stars of the Unit.
     */
    @Override
    public int giveStarsToPlayer() {
        int starsToGive = this.getStars();
        this.reduceStarsBy(starsToGive);
        return starsToGive;
    }
}
