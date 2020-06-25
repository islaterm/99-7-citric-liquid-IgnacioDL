package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.BossUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.WildUnit;
import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricliquid.model.NormaGoal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class that represents a Wild unit in the game.
 *
 * @author Ignacio Diaz Lara.
 */
public class GameController {
    private List<IPanel> listPanels = new ArrayList<>();
    public List<Player> listPlayers = new ArrayList<>();
    public List<HomePanel> listHomePanels = new ArrayList<>();
    private int turn = 0;
    private int chapter = 1;
    private WinnerHandler winnerHandler = new WinnerHandler(this);
    private Player winner;

    /**
     * Creates a Bonus Panel and adds it to the array of panels.
     */
    public BonusPanel createBonusPanel(int id){
        BonusPanel bonusPanel = new BonusPanel(id);
        listPanels.add(bonusPanel);
        return bonusPanel;
    }

    /**
     * Creates a Boss Panel and adds it to the array of panels.
     */
    public BossPanel createBossPanel(int id){
        BossPanel bossPanel = new BossPanel(id);
        listPanels.add(bossPanel);
        return bossPanel;
    }

    /**
     * Creates a Drop Panel and adds it to the array of panels.
     */
    public DropPanel createDropPanel(int id){
        DropPanel dropPanel = new DropPanel(id);
        listPanels.add(dropPanel);
        return dropPanel;
    }

    /**
     * Creates a Encounter Panel and adds it to the array of panels.
     */
    public EncounterPanel createEncounterPanel(int id){
        EncounterPanel encounterPanel = new EncounterPanel(id);
        listPanels.add(encounterPanel);
        return encounterPanel;
    }

    /**
     * Creates a Home Panel and adds it to the array of panels.
     */
    public HomePanel createHomePanel(int id){
        HomePanel homePanel = new HomePanel(id);
        listPanels.add(homePanel);
        listHomePanels.add(homePanel);
        return homePanel;
    }

    /**
     * Creates a Neutral Panel and adds it to the array of panels.
     */
    public NeutralPanel createNeutralPanel(int id){
        NeutralPanel neutralPanel = new NeutralPanel(id);
        listPanels.add(neutralPanel);
        return neutralPanel;
    }

    /**
     * Returns the array of panels.
     */
    public List<IPanel> getPanels(){
        return listPanels;
    }

    /**
     * Creates a Player, sets the initial panel of the player, adds the player to the list
     * of players in the array of players of the panel, adds the player
     * to the array of players of the game.
     */
    public Player createPlayer(String name, int hp, int atk, int def, int evd, IPanel panel){
        Player player = new Player(name, hp, atk, def, evd);
        player.setHomePanel(panel);
        player.setCurrentPanel(panel);
        panel.addPlayer(player);
        listPlayers.add(player);
        player.addWinnerListener(winnerHandler);
        return player;
    }
    /**
     * Creates a Wild Unit.
     */
    public WildUnit createWildUnit(String name, int hp, int atk, int def, int evd){
        return new WildUnit(name, hp, atk, def, evd);
    }

    /**
     * Creates a Boss Unit.
     */
    public BossUnit createBossUnit(String name, int hp, int atk, int def, int evd){
        return new BossUnit(name, hp, atk, def, evd);
    }

    /**
     * Sets a target panel to the list of next panel of a origin panel.
     */
    public void setNextPanel(IPanel originPanel, IPanel targetPanel) {
        if (originPanel.getId()!=targetPanel.getId()) {
            originPanel.addNextPanel(targetPanel);
        }
    }

    /**
     * Creates a Wild Unit.
     */
    public Player getTurnOwner() {
        return listPlayers.get(turn%listPlayers.size());
    }

    /**
     * Sets a normal Goal for the current Player.
     */
    public void setCurrPlayerNormaGoal(NormaGoal goal) {
        listPlayers.get(turn).setNormaGoal(goal);
    }

    /**
     * Returns the current panel of the player.
     */
    public IPanel getPlayerPanel(Player unit) {
        return unit.getCurrentPanel();
    }

    /**
     * The current player makes a move.
     */
    public void  movePlayer() {
        int steps = getTurnOwner().roll();

        while (steps>0){
            //if there's only one panel to move
            Iterator<IPanel> iterator = getTurnOwner().getCurrentPanel().getNextPanels().iterator();

            if (getTurnOwner().getCurrentPanel().getNextPanels().size() == 1 ) {
                IPanel newActualPanel = iterator.next();
                getTurnOwner().getCurrentPanel().removerPlayer(getTurnOwner());
                getTurnOwner().setCurrentPanel(newActualPanel);
                newActualPanel.addPlayer(getTurnOwner());
            }
            //if the player needs to decides the next panel
            //this section is commented because testMediator requires to stop at split for now
            /**else{
                int chosenPanel = getTurnOwner().decidesNextPanel();
                IPanel newActualPanel = iterator.next();
                getTurnOwner().getCurrentPanel().removerPlayer(getTurnOwner());
                while (chosenPanel>0){
                    newActualPanel = iterator.next();
                    chosenPanel--;
                }
                getTurnOwner().setCurrentPanel(newActualPanel);
                newActualPanel.addPlayer(getTurnOwner());
            }*/
            if (getTurnOwner().getCurrentPanel().getType()=="Home"){
                if (getTurnOwner().decidesStaysHomePanel()){
                    break;
                }
            }
            steps--;
        }
        //card effect activation
        getTurnOwner().getCurrentPanel().activatedBy(getTurnOwner());
        endTurn();
    }

    /**
     * Returns the chapter of the game.
     */
    public int getChapter() {
        return chapter;
    }

    /**
     * Returns the turn of the game.
     */
    public void endTurn() {
        turn++;
        if (turn % 4 == 0) {
            chapter++;
        }
    }

    /**
     * Sets the player's home panel.
     */
    public void setPlayerHome(Player unit, HomePanel panel) {
        unit.setHomePanel(panel);
    }

    public void getWinnerHandler(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

}
