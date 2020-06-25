package com.github.cc3002.citricliquid.controller;
import com.github.cc3002.citricjuice.model.Player;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WinnerHandler implements PropertyChangeListener {
    private GameController controller;

    public WinnerHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        controller.getWinnerHandler((Player) propertyChangeEvent.getNewValue());
    }
}
