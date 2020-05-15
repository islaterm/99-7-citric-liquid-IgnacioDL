package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a panel in the board of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater
 *     Muñoz</a>.
 * @version 1.0.6-rc.2
 * @since 1.0
 */
public abstract class AbstractPanel implements IPanel {
  private final Set<AbstractPanel> nextPanels = new HashSet<>();
  private static int count = 0;
  protected final int id;

  public AbstractPanel() {
    this.id = ++count;
  }

  /**
   * Returns a copy of this panel's next ones.
   */
  public Set<AbstractPanel> getNextPanels() {
    return Set.copyOf(nextPanels);
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param abstractPanel
   *     the panel to be added.
   */
  public void addNextPanel(final AbstractPanel abstractPanel) {
    nextPanels.add(abstractPanel);
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  public abstract void activatedBy(final Player player);

  /**
   * Returns the type of the panel.
   */
  public abstract String getType();
}
