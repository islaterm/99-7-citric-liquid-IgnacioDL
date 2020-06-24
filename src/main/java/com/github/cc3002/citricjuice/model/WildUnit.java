package com.github.cc3002.citricjuice.model;

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
     */
    @Override
    public int giveWins(){
        return 1;
    }

    /**
     * Increases the amount of Stars for this Unit and decreases the same amount of stars for the opponent.
     */
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
