package com.github.cc3002.citricliquid.gui;


import com.github.cc3002.citricjuice.model.BossUnit;
import com.github.cc3002.citricjuice.model.Player;
import com.github.cc3002.citricjuice.model.WildUnit;
import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricliquid.controller.GameController;
import com.github.cc3002.citricliquid.gui.nodes.MovableNodeBuilder;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Ignacio Slater Muñoz.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
public class View extends Application {
    private final Group root = new Group();
    private static final String RESOURCE_PATH = "src/main/resources/";
    private GameController controller = new GameController();
    private int id = 0;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;


    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("99.7% Citric Liquid");
        primaryStage.setResizable(false);
        int width = 800;
        int height = 533;
        Scene scene = new Scene(root, width, height);
          var spriteHomePanel1 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageHomePanel.png")
                .setPosition(120, 120)
                .setSize(50, 50)
                .build();
        var spriteHomePanel2 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageHomePanel.png")
                .setPosition(120, 320)
                .setSize(50, 50)
                .build();
        var spriteHomePanel3 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageHomePanel.png")
                .setPosition(320, 120)
                .setSize(50, 50)
                .build();
        var spriteHomePanel4 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageHomePanel.png")
                .setPosition(320, 320)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel1 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(70, 170)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel2 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(120, 270)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel3 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(170, 70)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel4 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(170, 370)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel5 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(220, 120)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel6 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(220, 320)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel7 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(270, 70)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel8 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(270, 370)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel9 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(320, 170)
                .setSize(50, 50)
                .build();
        var spriteNeutralPanel10 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageNeutralPanel.png")
                .setPosition(370, 270)
                .setSize(50, 50)
                .build();
        var spriteDropPanel1 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageDropPanel.png")
                .setPosition(120, 170)
                .setSize(50, 50)
                .build();
        var spriteDropPanel2 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageDropPanel.png")
                .setPosition(170, 20)
                .setSize(50, 50)
                .build();
        var spriteDropPanel3 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageDropPanel.png")
                .setPosition(270, 420)
                .setSize(50, 50)
                .build();
        var spriteDropPanel4 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageDropPanel.png")
                .setPosition(420, 170)
                .setSize(50, 50)
                .build();
        var spriteEncounterPanel1 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageEncounterPanel.png")
                .setPosition(20, 270)
                .setSize(50, 50)
                .build();
        var spriteEncounterPanel2 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageEncounterPanel.png")
                .setPosition(170, 320)
                .setSize(50, 50)
                .build();
        var spriteEncounterPanel3 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageEncounterPanel.png")
                .setPosition(270, 120)
                .setSize(50, 50)
                .build();
        var spriteEncounterPanel4 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageEncounterPanel.png")
                .setPosition(320, 270)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel1 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(20, 170)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel2 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(70, 270)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel3 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(120, 220)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel4 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(170, 120)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel5 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(170, 420)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel6 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(270, 20)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel7 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(270, 320)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel8 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(320, 220)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel9 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(370, 170)
                .setSize(50, 50)
                .build();
        var spriteBonusPanel10 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBonusPanel.png")
                .setPosition(420, 270)
                .setSize(50, 50)
                .build();
        var spriteBossPanel1 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBossPanel.png")
                .setPosition(20, 220)
                .setSize(50, 50)
                .build();
        var spriteBossPanel2 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBossPanel.png")
                .setPosition(220, 20)
                .setSize(50, 50)
                .build();
        var spriteBossPanel3 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBossPanel.png")
                .setPosition(220, 420)
                .setSize(50, 50)
                .build();
        var spriteBossPanel4 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageBossPanel.png")
                .setPosition(420, 220)
                .setSize(50, 50)
                .build();

        var spritePlayer1 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageKai.png")
                .setPosition(110, 115)
                .setSize(30, 50)
                .build();
        var spritePlayer2 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageMarc.png")
                .setPosition(110, 335)
                .setSize(30, 50)
                .build();
        var spritePlayer3 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageSuguri.png")
                .setPosition(330, 115)
                .setSize(30, 50)
                .build();
        var spritePlayer4 = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "imageYuki.png")
                .setPosition(330, 335)
                .setSize(30, 50)
                .build();

        var background =
                new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));

        HomePanel homePanel1 = controller.createHomePanel(id++);
        HomePanel homePanel2 = controller.createHomePanel(id++);
        HomePanel homePanel3 = controller.createHomePanel(id++);
        HomePanel homePanel4 = controller.createHomePanel(id++);
        NeutralPanel neutralPanel1 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel2 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel3 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel4 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel5 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel6 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel7 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel8 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel9 = controller.createNeutralPanel(id++);
        NeutralPanel neutralPanel10 = controller.createNeutralPanel(id++);
        BossPanel bossPanel1 = controller.createBossPanel(id++);
        BossPanel bossPanel2 = controller.createBossPanel(id++);
        BossPanel bossPanel3 = controller.createBossPanel(id++);
        BossPanel bossPanel4 = controller.createBossPanel(id++);
        BonusPanel bonusPanel1 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel2 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel3 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel4 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel5 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel6 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel7 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel8 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel9 = controller.createBonusPanel(id++);
        BonusPanel bonusPanel10 = controller.createBonusPanel(id++);
        EncounterPanel encounterPanel1 = controller.createEncounterPanel(id++);
        EncounterPanel encounterPanel2 = controller.createEncounterPanel(id++);
        EncounterPanel encounterPanel3 = controller.createEncounterPanel(id++);
        EncounterPanel encounterPanel4 = controller.createEncounterPanel(id++);
        DropPanel dropPanel1 = controller.createDropPanel(id++);
        DropPanel dropPanel2 = controller.createDropPanel(id++);
        DropPanel dropPanel3 = controller.createDropPanel(id++);
        DropPanel dropPanel4 = controller.createDropPanel(id++);

        player1 = controller.createPlayer("Suguri", 1, -1, 2, 5, homePanel1);
        player1 = controller.createPlayer("Kai", 1, 0, 0, 5, homePanel2);
        player1 = controller.createPlayer("Yuki", 2, -1, -1, 5, homePanel3);
        player1 = controller.createPlayer("Marc", 1, 1, -1, 5, homePanel4);
        WildUnit chicken = controller.createWildUnit("Chiken",3,-1,-1,1);
        BossUnit storeManager = controller.createBossUnit("Store Manager", 8,3,2,-1);
        WildUnit roboBall = controller.createWildUnit("Robo Ball",3,-1,1,-1);
        BossUnit shifuRobot = controller.createBossUnit("Shifu Robot", 7,2,3,-2);
        WildUnit seagull = controller.createWildUnit("Seagull",3,1,-1,-1);
        BossUnit flyingCastle = controller.createBossUnit("Flying Castle", 10,2,1,-3);

        root.getChildren().add(background);
        root.getChildren().add(newGameButton());
        root.getChildren().add(positiveButton());
        root.getChildren().add(negativeButton());
        root.getChildren().add(rollButton());
        root.getChildren().add(spriteHomePanel1.getNode());
        root.getChildren().add(spriteHomePanel2.getNode());
        root.getChildren().add(spriteHomePanel3.getNode());
        root.getChildren().add(spriteHomePanel4.getNode());
        root.getChildren().add(spriteNeutralPanel1.getNode());
        root.getChildren().add(spriteNeutralPanel2.getNode());
        root.getChildren().add(spriteNeutralPanel3.getNode());
        root.getChildren().add(spriteNeutralPanel4.getNode());
        root.getChildren().add(spriteNeutralPanel5.getNode());
        root.getChildren().add(spriteNeutralPanel6.getNode());
        root.getChildren().add(spriteNeutralPanel7.getNode());
        root.getChildren().add(spriteNeutralPanel8.getNode());
        root.getChildren().add(spriteNeutralPanel9.getNode());
        root.getChildren().add(spriteNeutralPanel10.getNode());
        root.getChildren().add(spriteDropPanel1.getNode());
        root.getChildren().add(spriteDropPanel2.getNode());
        root.getChildren().add(spriteDropPanel3.getNode());
        root.getChildren().add(spriteDropPanel4.getNode());
        root.getChildren().add(spriteEncounterPanel1.getNode());
        root.getChildren().add(spriteEncounterPanel2.getNode());
        root.getChildren().add(spriteEncounterPanel3.getNode());
        root.getChildren().add(spriteEncounterPanel4.getNode());
        root.getChildren().add(spriteBonusPanel1.getNode());
        root.getChildren().add(spriteBonusPanel2.getNode());
        root.getChildren().add(spriteBonusPanel3.getNode());
        root.getChildren().add(spriteBonusPanel4.getNode());
        root.getChildren().add(spriteBonusPanel5.getNode());
        root.getChildren().add(spriteBonusPanel6.getNode());
        root.getChildren().add(spriteBonusPanel7.getNode());
        root.getChildren().add(spriteBonusPanel8.getNode());
        root.getChildren().add(spriteBonusPanel9.getNode());
        root.getChildren().add(spriteBonusPanel10.getNode());
        root.getChildren().add(spriteBossPanel1.getNode());
        root.getChildren().add(spriteBossPanel2.getNode());
        root.getChildren().add(spriteBossPanel3.getNode());
        root.getChildren().add(spriteBossPanel4.getNode());
        root.getChildren().add(spritePlayer1.getNode());
        root.getChildren().add(spritePlayer2.getNode());
        root.getChildren().add(spritePlayer3.getNode());
        root.getChildren().add(spritePlayer4.getNode());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private @NotNull Text initialText() {
        Text text = new Text();
        text.setFont(new Font(200));
        text.setFill(Color.BLACK);
        text.setText("It's your turn,"+ controller.getTurnOwner().getName() + ", Roll the Dice!");
        text.setLayoutX(600);
        text.setLayoutY(100);
        root.getChildren().add(text);
        return text;
    }

    private @NotNull Button newGameButton() {
        Button button = new Button("New Game!");
        button.setLayoutX(600);
        button.setLayoutY(80);
        button.setFocusTraversable(false);
        button.setOnAction(event -> controller.newTurn());
        return button;
    }

    private @NotNull Button positiveButton() {
        Button button = new Button("Yes!!");
        button.setLayoutX(580);
        button.setLayoutY(250);
        button.setFocusTraversable(false);
        button.setOnAction(event -> controller.affirmative());
        return button;
    }

    private @NotNull Button negativeButton() {
        Button button = new Button("Noo!");
        button.setLayoutX(650);
        button.setLayoutY(250);
        button.setFocusTraversable(false);
        button.setOnAction(event -> controller.negative());
        return button;
    }

    private @NotNull Button rollButton() {
        Button button = new Button("Roll the Dice");
        button.setLayoutX(600);
        button.setLayoutY(300);
        button.setFocusTraversable(false);
        button.setOnAction(event -> controller.getTurnOwner().roll());
        return button;
    }

    private @NotNull Label createLabel(int xPos, int yPos) {
        Label label = new Label();
        label.setLayoutX(xPos);
        label.setLayoutY(yPos);
        root.getChildren().add(label);
        return label;
    }
}
