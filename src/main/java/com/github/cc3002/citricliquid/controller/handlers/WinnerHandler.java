package com.github.cc3002.citricliquid.controller.handlers;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricliquid.controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Class that represents an connection between a publisher and a subscriber.
 * Handles notifications about a new winner.
 *
 * @author Ignacio Diaz Lara.
 */
public class WinnerHandler implements PropertyChangeListener {
    private GameController controller;

    /**
     * Creates a new Winner Handler.
     *
     * @param controller
     *     the handler's controller.
     */
    public WinnerHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * This method get called when a bound property is changed.
     *
     * @param propertyChangeEvent
     *      A propertyChangeEvent object describing the event source
     *      and property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        controller.getWinnerHandler((Player) propertyChangeEvent.getNewValue());
    }
}
