package com.github.cc3002.citricjuice.model;

import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a Boss unit in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class BossUnit extends AbstractEnemy {

    /**
     * Creates a new Boss Unit .
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

    public BossUnit(String name, int hp, int atk, int def, int evd) {
        super(name, hp, atk, def, evd);
    }

    /**
     * Returns the specific amount of wins the opponent wins for defeating this type of unit.
     * In this case, players gives 3 wins.
     */
    @Override
    public int giveWins(){
        return 3;
    }


    @Override
    public void getStarsFromUnit(@NotNull IUnit opponent){
        this.increaseStarsBy(opponent.giveStarsToBossUnit());
    }

    /**
     * Determines if one Boss Unit is equivalent to another.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BossUnit)) {
            return false;
        }
        final BossUnit bossUnit = (BossUnit) o;
        return getMaxHP() == bossUnit.getMaxHP() &&
                getAtk() == bossUnit.getAtk() &&
                getDef() == bossUnit.getDef() &&
                getEvd() == bossUnit.getEvd() &&
                getStars() == bossUnit.getStars() &&
                getCurrentHP() == bossUnit.getCurrentHP() &&
                getName().equals(bossUnit.getName());
    }
}
