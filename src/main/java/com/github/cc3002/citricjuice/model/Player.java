package com.github.cc3002.citricjuice.model;


import org.jetbrains.annotations.NotNull;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater
 *     Muñoz</a>.
 * @version 1.0.6-rc.3
 * @since 1.0
 */
public class Player extends AbstractUnit {
  private int normaLevel;

  public Player(final String name, final int hp, final int atk, final int def,
                final int evd) {
    super(name, hp, atk, def, evd);
    normaLevel = 1;
  }

  /**
   * Returns the current norma level
   */
  public int getNormaLevel() {
    return normaLevel;
  }

  /**
   * Performs a norma clear action; the {@code norma} counter increases in 1.
   */
  public void normaClear() {
    normaLevel++;
  }

  /**
   * Returns the specific amount of wins the opponent wins for defeating this type of unit.
   */
  @Override
  public int giveWins(){
    return 2;
  }

  /**
   * Returns the specific amount of stars the Wild Unit opponent wins for defeating this type of unit
   * and decrease the same amount of stars for the opponent.
   */
  @Override
  public int giveStarsToWildUnit(){
    int starsToGive = (int) (this.getStars() * 0.5);
    this.reduceStarsBy(starsToGive);
    return starsToGive;
  }

  /**
   * Returns the specific amount of stars the Boss Unit opponent wins for defeating this type of unit
   * and decrease the same amount of stars for the opponent.
   */
  @Override
  public int giveStarsToBossUnit(){
    int starsToGive = (int) (this.getStars() * 0.5);
    this.reduceStarsBy(starsToGive);
    return starsToGive;
  }

  /**
   * Returns the specific amount of stars the Player opponent wins for defeating this type of unit
   * and decrease the same amount of stars for the opponent.
   */
  @Override
  public int giveStarsToPlayer(){
    int starsToGive = (int) (this.getStars() * 0.5);
    this.reduceStarsBy(starsToGive);
    return starsToGive;
  }

  /**
   * Increases the amount of Stars for this Unit and decreases the same amount of stars for the opponent.
   */
  @Override
  public void getStarsFromUnit(@NotNull IUnit opponent){
    this.increaseStarsBy(opponent.giveStarsToPlayer());
  }

  /**
   * Changes the Player attack stat.
   */
  public void changePlayerAtk(int newAtk){
    this.atk = newAtk;
  }

  /**
   * Changes the Player Defense stat.
   */
  public void changePlayerDef(int newDef){
    this.def = newDef;
  }

  /**
   * Changes the Player EVD stat.
   */
  public void changePlayerEvd(int newEvd){
    this.evd = newEvd;
  }

  /**
   * Determines if one player is equivalent to another.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }
    final Player player = (Player) o;
    return getMaxHP() == player.getMaxHP() &&
           getAtk() == player.getAtk() &&
           getDef() == player.getDef() &&
           getEvd() == player.getEvd() &&
           getNormaLevel() == player.getNormaLevel() &&
           getStars() == player.getStars() &&
           getCurrentHP() == player.getCurrentHP() &&
           getName().equals(player.getName());
  }

  /**
   * Returns a copy of this character.
   */
  public Player copy() {
    return new Player(name, maxHP, atk, def, evd);
  }
}
