package com.github.cc3002.citricjuice.model;

/**
 * Class that represents a Wild unit in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class WildUnit extends AbstractEnemy{

    /**
     * Creates a new Wild Unit .
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

    public WildUnit(String name, int hp, int atk, int def, int evd) {
        super(name, hp, atk, def, evd);
    }

    /**
     * Returns the specific amount of wins the opponent wins for defeating this type of unit.
     * In this case, players gives 1 wins.
     */
    @Override
    public int giveWins(){
        return 1;
    }


    @Override
    public void getStarsFromUnit(IUnit opponent){
        this.increaseStarsBy(opponent.giveStarsToWildUnit());
    }

    /**
     * Determines if one Wild Unit is equivalent to another.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WildUnit)) {
            return false;
        }
        final WildUnit wildUnit = (WildUnit) o;
        return getMaxHP() == wildUnit.getMaxHP() &&
                getAtk() == wildUnit.getAtk() &&
                getDef() == wildUnit.getDef() &&
                getEvd() == wildUnit.getEvd() &&
                getStars() == wildUnit.getStars() &&
                getCurrentHP() == wildUnit.getCurrentHP() &&
                getName().equals(wildUnit.getName());
    }

}
