package com.github.cc3002.citricjuice.model.board;

import com.github.cc3002.citricjuice.model.Player;

import java.util.Set;

public interface IPanel {

    void addNextPanel(final AbstractPanel abstractPanel);
    Set<AbstractPanel> getNextPanels();
    void activatedBy(final Player player);
    String getType();
}
