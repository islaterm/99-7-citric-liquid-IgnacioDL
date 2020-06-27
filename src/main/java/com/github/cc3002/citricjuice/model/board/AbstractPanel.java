package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class that represents a panel in the board of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater
 *     Muñoz</a>.
 * @version 1.0.6-rc.2
 * @since 1.0
 */
public abstract class AbstractPanel implements IPanel {
  private final Set<IPanel> nextPanels = new HashSet<>();
  public ArrayList<Integer> listOfPanelsId= new ArrayList<>();
  protected final int id;
  private ArrayList<Player> listOfPlayers= new ArrayList<>();



  /**
   * Creates a abstract Panel.
   *
   * @param id
   *     the panel's id.
   */
  public AbstractPanel(int id) {
    this.id = id;
    listOfPanelsId.add(this.id);
  }

  @Override
  public void removerPlayer(Player player) {
    listOfPlayers.remove(player);
  }

  @Override
  public void addPlayer(Player player) {
    if (!listOfPlayers.contains(player)) {
      listOfPlayers.add(player);
    }
  }

  @Override
  public ArrayList<Player> getPlayers() {
    return listOfPlayers;
  }

  @Override
  public Set<IPanel> getNextPanels() {
    return Set.copyOf(nextPanels);
  }

  @Override
  public void addNextPanel(final IPanel panel) {
    if (panel.getId() != this.getId() ){
      nextPanels.add(panel);
    }
  }

  @Override
  public abstract void activatedBy(final Player player);

  @Override
  public abstract String getType();

  @Override
  public int getId() {
    return this.id;
  }
}
