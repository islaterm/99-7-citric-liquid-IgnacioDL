package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.BossUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.WildUnit;
import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricliquid.model.NormaGoal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameController {
    public List<IPanel> listPanels = new ArrayList<>();
    public List<Player> listPlayers = new ArrayList<>();
    public List<HomePanel> listHomePanels = new ArrayList<>();
    int turn = -1;


    public BonusPanel createBonusPanel(int id){
        BonusPanel bonusPanel = new BonusPanel(id);
        listPanels.add(bonusPanel);
        return bonusPanel;
    }

    public BossPanel createBossPanel(int id){
        BossPanel bossPanel = new BossPanel(id);
        listPanels.add(bossPanel);
        return bossPanel;
    }

    public DropPanel createDropPanel(int id){
        DropPanel dropPanel = new DropPanel(id);
        listPanels.add(dropPanel);
        return dropPanel;
    }

    public EncounterPanel createEncounterPanel(int id){
        EncounterPanel encounterPanel = new EncounterPanel(id);
        listPanels.add(encounterPanel);
        return encounterPanel;
    }

    public HomePanel createHomePanel(int id){
        HomePanel homePanel = new HomePanel(id);
        listPanels.add(homePanel);
        listHomePanels.add(homePanel);
        return homePanel;
    }

    public NeutralPanel createNeutralPanel(int id){
        NeutralPanel neutralPanel = new NeutralPanel(id);
        listPanels.add(neutralPanel);
        return neutralPanel;
    }

    public List<IPanel> getPanels(){
        return listPanels;
    }

    public Player createPlayer(String name, int hp, int atk, int def, int evd, IPanel panel){
        Player player = new Player(name, hp, atk, def, evd);
        player.setHomePanel(panel);
        listPlayers.add(player);
        turn++;
        return player;
    }

    public WildUnit createWildUnit(String name, int hp, int atk, int def, int evd){
        return new WildUnit(name, hp, atk, def, evd);
    }

    public BossUnit createBossUnit(String name, int hp, int atk, int def, int evd){
        return new BossUnit(name, hp, atk, def, evd);
    }

    public void setNextPanel(IPanel originPanel, IPanel targetPanel) {
        originPanel.addNextPanel(targetPanel);
    }

    public Player getTurnOwner() {
        return listPlayers.get(turn);
    }

    public void setCurrPlayerNormaGoal(NormaGoal goal) {
        listPlayers.get(turn).setNormaGoal(goal);
    }

    public IPanel getPlayerPanel(Player unit) {
        return unit.getCurrentPanel();
    }

    public void  movePlayer() {
        Iterator<IPanel> iterator = getTurnOwner().getCurrentPanel().getNextPanels().iterator();
        if (getTurnOwner().getCurrentPanel().getNextPanels().size() == 1 ) {
            getTurnOwner().getCurrentPanel().removerPlayer(getTurnOwner());
            IPanel newActualPanel = iterator.next();
            getTurnOwner().setCurrentPanel(newActualPanel);
            newActualPanel.addPlayer(getTurnOwner());
        }
        //card effect activation
        getTurnOwner().getCurrentPanel().activatedBy(getTurnOwner());
    }
}
