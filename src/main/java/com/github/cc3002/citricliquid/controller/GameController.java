package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.BossUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.WildUnit;
import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricliquid.controller.handlers.WinnerHandler;
import com.github.cc3002.citricliquid.model.NormaGoal;
import com.github.cc3002.citricliquid.phases.State;
import com.github.cc3002.citricliquid.phases.Turn;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
    private int turnCount = 0;
    private int chapter = 1;
    private WinnerHandler winnerHandler = new WinnerHandler(this);
    private Player winner;
    private boolean input;
    private Turn turn;

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
        return listPlayers.get(turnCount %listPlayers.size());
    }

    /**
     * Sets a normal Goal for the current Player.
     */
    public void setCurrPlayerNormaGoal(NormaGoal goal) {
        listPlayers.get(turnCount).setNormaGoal(goal);
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
        getTurnOwner().move(getTurnOwner().roll());
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
        turnCount++;
        if (turnCount % listPlayers.size() == 0) {
            chapter++;
        }
    }

    /**
     * Sets the player's home panel.
     */
    public void setPlayerHome(Player unit, IPanel panel) {
        unit.setHomePanel(panel);
    }

    /**
     * Receives a player from the winner Handler and sets it as the winner.
     */
    public void getWinnerHandler(Player winner) {
        this.winner = winner;
    }

    /**
     * Returns the winner of the game.
     * Returns null in case there's not winner yet.
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Initiates a new Turn.
     */
    public void newTurn() {
        this.turn = new Turn();
    }

    /**
     * Sets the input to true.
     */
    public void affirmative() {
        input = true;
    }

    /**
     * Sets the input to false.
     */
    public void negative() {
        input = false;
    }

    /**
     * Sets the state of the turn.
     */
    public void setState(final @NotNull State state) {
        this.turn.setState(state);
    }
}
