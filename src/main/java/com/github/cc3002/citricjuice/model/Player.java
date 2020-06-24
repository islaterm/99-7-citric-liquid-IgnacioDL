package com.github.cc3002.citricjuice.model;


import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricliquid.model.NormaGoal;
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
  private int normaLevel = 1;
  private NormaGoal normaGoal = NormaGoal.STARS;
  private IPanel homePanel;
  private IPanel currentPanel;

  /**
   * Creates a new player.
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

  public Player(final String name, final int hp, final int atk, final int def,
                final int evd) {
    super(name, hp, atk, def, evd);
  }

  /**
   * Returns the number of the next panel chosen.
   * For the moment it always choose the first next panel.
   *
   */
  public int decidesNextPanel() {
    return 0;
  }

  /**
   * Returns boolean decision of the player whether wants to stays in the
   * Home Panel or not.
   * For the moment it always chooses to stay in the Home Panel.
   */
  public boolean decidesStaysHomePanel() {
    return true;
  }

  /**
   * Checks requirements for a norma clear, and triggers it when needed.
   */
  public void normaCheck() {
    if (this.getStars()>=10 && this.getNormaLevel()==1){
      this.normaClear();
      return;
    }
    if (this.getStars()>=30 && this.getNormaLevel()==2){
      this.normaClear();
      return;
    }
    if (this.getStars()>=70 && this.getNormaLevel()==3){
      this.normaClear();
      return;
    }
    if (this.getStars()>=120 && this.getNormaLevel()==4){
      this.normaClear();
      return;
    }
    if (this.getStars()>=200 && this.getNormaLevel()==5){
      this.normaClear();
      //notify win
    }
  }

  /**
   * Sets the current Panel.
   */
  public void setCurrentPanel(IPanel panel) {
    this.currentPanel = panel;
  }

  /**
   * Returns the current Panel.
   */
  public IPanel getCurrentPanel() {
    return currentPanel;
  }

  /**
   * Returns the home Panel.
   */
  public HomePanel getHomePanel(HomePanel homePanel) {
    return homePanel;
  }

  /**
   * Sets the home Panel.
   */
  public void setHomePanel(IPanel homePanel) {
    this.homePanel = homePanel;
  }

  /**
   * Sets the current norma goal.
   */
  public void setNormaGoal(NormaGoal normaGoal) {
    this.normaGoal = normaGoal;
  }

  /**
   * Returns the current norma goal.
   */
  public NormaGoal getNormaGoal() {
    return normaGoal;
  }

  /**
   * Returns the current norma level.
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
   * In this case, players gives 2 wins.
   */
  @Override
  public int giveWins(){
    return 2;
  }

  /**
   * Returns the specific amount of stars the Wild Unit opponent wins for defeating this type of unit
   * and decrease the same amount of stars for the opponent.
   * In this case half of the stars of the player.
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
   * In this case half of the stars of the player.
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
   * In this case half of the stars of the player.
   */
  @Override
  public int giveStarsToPlayer(){
    int starsToGive = (int) (this.getStars() * 0.5);
    this.reduceStarsBy(starsToGive);
    return starsToGive;
  }

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
