package group5.startscreenud2balatro;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Vector;


public class gameplayGUIController{
    private static ImageView backgroundView;

    private static GameMaster game;

    private static Friend f1;
    private static Label f1Stats;
    private static Friend f2;
    private static Label f2Stats;
    private static Friend f3;
    private static Label f3Stats;

    private static Enemy e1;
    private static Label e1Stats;
    private static Enemy e2;
    private static Label e2Stats;
    private static Enemy e3;
    private static Label e3Stats;



    private static final int IDLE_FRAME_COUNT   = 6;
    private static final int IDLE_FRAME_WIDTH   = 128;
    private static final int IDLE_FRAME_HEIGHT  = 128;
    private static final Duration IDLE_FRAME_DURATION = Duration.millis(100);

//    private int idleFrameIndex = 0; // Declare this at the class level if needed

    private static ImageView f1Sprite;
    private static ImageView f2Sprite;
    private static ImageView f3Sprite;

    private static ImageView e1Sprite;
    private static ImageView e2Sprite;
    private static ImageView e3Sprite;

    private static Unit selectedUnit;
    private static boolean unitSelected;

    private static Unit enemyTarget;
    private static int enemyTargetIndex;

    private static Font HeaderFont;
    private static Font textFont;
    private static Font activityLogFont;
//    private Font rpgHeaderFont;

    private static Label instructionsLabel;
    private static Line cardSectionBorder;
    private static Label cardsLabel;
    private static int cardSelectedIndex;
    private static boolean cardSelected;

    private static ScrollPane activityLogPane;
    private static VBox logContent;

    //vector holders for nodes created by functions that needs to be updated
    private static Vector<StackPane> cardGraphicsHolder;
    private static Vector<Label> friendStatsLabelHolder;
    private static Vector<Label> enemyStatsLabelHolder;

    private static Label backToMenuLabel;
    private static Label floorLabel;




    public void initialize(){
        Image background = new Image(getClass().getResource("/backgrounds/terrace.png").toExternalForm());
//        rpgHeaderFont = Font.loadFont(getClass().getResource("/fonts/AGoblinAppears.ttf").toExternalForm(), 20);
        HeaderFont = Font.font("Times New Roman", FontWeight.BOLD, 25);
        textFont = Font.font("Times New Roman", 16);
        activityLogFont = Font.font("Times New Roman", 25);
//        Image background = new Image("/group5/StartScreenBalatro.png");
        System.out.println("Working initialize 1");
        backgroundView = new ImageView();
        backgroundView.setImage(background);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);
        System.out.println("Working initialize 2");

        game = GameMaster.getInstance("Player1", 10);
        game.initializeFloor();
        f1 = game.getActiveFriendUnits().get(0);
        f2 = game.getActiveFriendUnits().get(1);
        f3 = game.getActiveFriendUnits().get(2);

        e1 = game.getActiveEnemyUnits().get(0);
        e2 = game.getActiveEnemyUnits().get(1);
        e3 = game.getActiveEnemyUnits().get(2);

        f1Stats = new Label();
        f2Stats = new Label();
        f3Stats = new Label();

        e1Stats = new Label();
        e2Stats = new Label();
        e3Stats = new Label();


        f1Sprite = new ImageView();
        f2Sprite = new ImageView();
        f3Sprite = new ImageView();

        e1Sprite = new ImageView();
        e2Sprite = new ImageView();
        e3Sprite = new ImageView();


        System.out.println("Working initialize 3");

        f1Sprite.setImage(f1.getIdleSprite());
        f2Sprite.setImage(f2.getIdleSprite());
        f3Sprite.setImage(f3.getIdleSprite());

        e1Sprite.setImage(e1.getIdleSprite());
//        e1Sprite.setScaleX(-1);
        e2Sprite.setImage(e2.getIdleSprite());
        e3Sprite.setImage(e3.getIdleSprite());

        setupIdleAnimation(f1Sprite);
        setupIdleAnimation(f2Sprite);
        setupIdleAnimation(f3Sprite);

        setupIdleAnimation(e1Sprite);
        setupIdleAnimation(e2Sprite);
        setupIdleAnimation(e3Sprite);
        System.out.println("Working initialize 4");
//        f1.setLayoutX(640);
//        f1.setLayoutY(360);
//        if(customRPGFont == null){
//            System.out.println("Font not loaded...");
//        }
        instructionsLabel = new Label();
        instructionsLabel.setFont(HeaderFont);
        System.out.println("Working initialize 5");
        instructionsLabel.setText("Pick a card");
        instructionsLabel.setTextFill(Color.WHITE);

        cardSectionBorder = new Line(0, 0, 1000, 0);

        cardSectionBorder.setStroke(Color.WHITE);
        cardSectionBorder.setStrokeWidth(2);

        cardsLabel = new Label();
        cardsLabel.setFont(HeaderFont);
        cardsLabel.setText("Cards:");
        cardsLabel.setTextFill(Color.WHITE);

        cardSelected = false;
        unitSelected = false;

        friendStatsLabelHolder = new Vector<Label>();
        enemyStatsLabelHolder = new Vector<Label>();

        backToMenuLabel = new Label("<Back To Menu");
        backToMenuLabel.setFont(HeaderFont);
        backToMenuLabel.setTextFill(Color.WHITE);
        backToMenuLabel.setOnMouseClicked(e ->{
            System.out.println("Exiting to Menu");
            backToMenu();
        });

        floorLabel = new Label("Floor: " + game.getCurrentFloor() + "/" + game.getTotalFloor());
        floorLabel.setFont(HeaderFont);
        floorLabel.setTextFill(Color.WHITE);




    }


    public static Scene getScene(){
//        primaryStage.setTitle("Project GUI");




        //load StackPane to be able to stack sprites over the background
        StackPane root = new StackPane();


        //Prepare Background and ready it to be loaded into the scene


        root.getChildren().add(backgroundView);

        drawCharacter(root, f1, f1Sprite, 0);
        drawUnitStats(root, f1, f1Stats, 0);
        drawCharacter(root, f2, f2Sprite, 1);
        drawUnitStats(root, f2, f2Stats, 1);
        drawCharacter(root, f3, f3Sprite, 2);
        drawUnitStats(root, f3, f3Stats, 2);

        drawCharacter(root, e1, e1Sprite, 0);
        drawUnitStats(root, e1, e1Stats, 0);
        drawCharacter(root, e2, e2Sprite, 1);
        drawUnitStats(root, e2, e2Stats, 1);
        drawCharacter(root, e3, e3Sprite, 2);
        drawUnitStats(root, e3, e3Stats, 2);

        root.getChildren().add(instructionsLabel);
        root.setAlignment(instructionsLabel, Pos.TOP_LEFT);
//        instructionsLabel.setScaleX(2);
        instructionsLabel.setTranslateX(640);
        instructionsLabel.setTranslateY(320  + (4 * f1.getIdleSprite().getHeight()));

        root.getChildren().add(cardSectionBorder);
        root.setAlignment(cardSectionBorder, Pos.TOP_LEFT);
        cardSectionBorder.setTranslateX(640);
        cardSectionBorder.setTranslateY(360  + (4 * f1.getIdleSprite().getHeight()));

        root.getChildren().add(cardsLabel);
        root.setAlignment(cardsLabel, Pos.TOP_LEFT);
        cardsLabel.setTranslateX(640);
        cardsLabel.setTranslateY(370  + (4 * f1.getIdleSprite().getHeight()));

        drawCard(root, game.getHand().get(0), 0);
        drawCard(root, game.getHand().get(1), 1);
        drawCard(root, game.getHand().get(2), 2);
        drawCard(root, game.getHand().get(3), 3);
        drawCard(root, game.getHand().get(4), 4);

        drawActivityLog(root);
        addMessage(logContent, game.getPlayer() + " has entered Floor " + game.getCurrentFloor() + " of the Tower");

        root.getChildren().add(backToMenuLabel);
        root.setAlignment(backToMenuLabel, Pos.BOTTOM_LEFT);

        root.getChildren().add(floorLabel);
        root.setAlignment(floorLabel, Pos.BOTTOM_RIGHT);



//        addMessage(logContent, "Test");


        //Load Image on top of StackPane

        Scene gameplayScene = new Scene(root);
        return gameplayScene;
    }



private void setupIdleAnimation(ImageView u) {
    u.setViewport(new Rectangle2D(0, 0, IDLE_FRAME_WIDTH, IDLE_FRAME_HEIGHT));

    final int[] frameIndex = {0}; // local index for this animation, which means each sprite has its own independent animation state

    Timeline idleAnim = new Timeline(
            new KeyFrame(IDLE_FRAME_DURATION, e -> {
                frameIndex[0] = (frameIndex[0] + 1) % IDLE_FRAME_COUNT;

                u.setViewport(new Rectangle2D(
                        frameIndex[0] * IDLE_FRAME_WIDTH,
                        0,
                        IDLE_FRAME_WIDTH,
                        IDLE_FRAME_HEIGHT
                ));
            })
    );

    idleAnim.setCycleCount(Timeline.INDEFINITE);
    idleAnim.play();
}

    private static void drawCharacter(StackPane root, Unit u, ImageView uSprite, int index){
        int initialX = 640;
        int initialY = 360;
        root.getChildren().add(uSprite);
        root.setAlignment(uSprite, Pos.TOP_LEFT);
        if(u instanceof Enemy){
            initialX += 500;
            uSprite.setScaleX(-1.75);
        }
        else{
            uSprite.setScaleX(1.75);
        }
        uSprite.setScaleY(1.75);
        uSprite.setTranslateX(initialX);
        uSprite.setTranslateY(initialY  + (index * u.getIdleSprite().getHeight()));


        uSprite.setOnMouseClicked(e ->{
            System.out.println("Unit Selected: " + u.getName());
            playerAction(cardSelected, u, index);
//            selectedUnit = u;
//            unitSelected = true;
        });


    }

    private static void drawCard(StackPane root, Card c, int index) {
        System.out.println("Drawing Card 1");
        double width = 100;
        double height = 150;
        double spacing = 20;
        double x = 640 + (index * (width + spacing));
        double y = 410  + (4 * f1.getIdleSprite().getHeight());

        System.out.println("Drawing Card 2");

//        Rectangle test = new Rectangle(width, height);
//        test.setFill(Color.rgb(0,0,0, 0.70));
//        test.setStroke(Color.WHITE);
//        test.setStrokeWidth(3);

        Rectangle cardRect = new Rectangle(width, height);
        cardRect.setArcWidth(20);
        cardRect.setArcHeight(20);
        cardRect.setFill(Color.rgb(0,0,0, 0.75));
        cardRect.setStroke(Color.WHITE);
        cardRect.setStrokeWidth(3);

        System.out.println("Drawing Card 3");

        Text cardLabel = new Text(c.getCardName() + "\nAction Type: " + c.getActionType() + "\nValue: " + c.getActionValue());
        cardLabel.setFont(textFont);
        cardLabel.setFill(Color.WHITE);
        cardLabel.setWrappingWidth(100);

        System.out.println("Drawing Card 4");
        StackPane cardPane = new StackPane(cardRect, cardLabel);
        cardPane.setAlignment(cardRect, Pos.TOP_LEFT);
        cardPane.setAlignment(cardLabel, Pos.TOP_LEFT);
        cardLabel.setTranslateX(10);
        cardLabel.setTranslateY(10);


        System.out.println("Drawing Card 5");


        // Save the index of the selected card
        cardPane.setOnMouseClicked(e -> {
            System.out.println("Card selected: " + (index + 1));
            cardSelectedIndex = index;
            cardSelected = true;
            instructionsLabel.setText("Pick a target");
            // Call a method to handle the selected card
//            selectCard(c);
        });

        root.getChildren().add(cardPane);

        root.setAlignment(cardPane, Pos.TOP_LEFT);
        cardPane.setTranslateX(x);
        cardPane.setTranslateY(y);


    }

    public static void drawUnitStats(StackPane root, Unit u, Label stats, int index){
        int initialX = 580;
        int initialY = 445;

        if(u instanceof Enemy){
            initialX += 675;
        }

        stats.setText(u.getName() + "\n" +
                "HP: " + u.getCurrentHealth() + "/" + u.getMaxHealth() + "\n" +
                "Attack: " + u.getAttack() + "\n" +
                "Defense: " + u.getDefense());

        stats.setFont(textFont);
        stats.setTextFill(Color.WHITE);

        root.getChildren().add(stats);
        root.setAlignment(stats, Pos.TOP_LEFT);
        stats.setTranslateX(initialX);
        stats.setTranslateY(initialY  + (index * u.getIdleSprite().getHeight()));

        if(u instanceof Friend){
            friendStatsLabelHolder.add(stats);
        }
        else{
            enemyStatsLabelHolder.add(stats);
        }
    }


    public static void drawActivityLog(StackPane root) {
        Label activityLogLabel = new Label("Activity Log");
        activityLogLabel.setFont(HeaderFont);
        activityLogLabel.setTextFill(Color.WHITE);

        Line activityLogSectionLine = new Line(0, 0, 450, 0);
        activityLogSectionLine.setStroke(Color.WHITE);
        activityLogSectionLine.setStrokeWidth(2);

        // Background shape
        Rectangle background = new Rectangle(450, 700);
        background.setArcWidth(20);
        background.setArcHeight(20);
        background.setFill(Color.rgb(0, 0, 0, 0.75));
        background.setStroke(Color.WHITE);

        // Content container for log messages
        logContent = new VBox(10);
        logContent.setPadding(new Insets(10));
        logContent.setPrefWidth(430); // slightly narrower than ScrollPane for padding
        logContent.setAlignment(Pos.TOP_LEFT);

        // ScrollPane setup
        ScrollPane activityLogPane = new ScrollPane(logContent);
        activityLogPane.setPrefSize(450, 700);
        activityLogPane.setFitToWidth(true);
        activityLogPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        activityLogPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        // Clip the scrollpane to the same shape as background
        Rectangle clip = new Rectangle(450, 700);
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        activityLogPane.setClip(clip);

        // Group background + scrollpane in a StackPane so they align
        StackPane logBox = new StackPane(background, activityLogPane);
        logBox.setMaxSize(450, 500);

        root.getChildren().add(activityLogLabel);
        root.getChildren().add(activityLogSectionLine);

        root.setAlignment(activityLogLabel, Pos.TOP_LEFT);
        activityLogLabel.setTranslateX(70);
        activityLogLabel.setTranslateY(190);
        root.setAlignment(activityLogSectionLine, Pos.TOP_LEFT);
        activityLogSectionLine.setTranslateX(70);
        activityLogSectionLine.setTranslateY(225);

        // Position it on the root (top-left)

        root.getChildren().add(logBox);
        root.setAlignment(logBox, Pos.TOP_LEFT);
        logBox.setTranslateX(70);
        logBox.setTranslateY(250);
    }

    public static void addMessage(VBox logContent, String message){
        Label logMessageLabel = new Label(message);
        logMessageLabel.setFont(activityLogFont);
        logMessageLabel.setTextFill(Color.WHITE);
        logMessageLabel.setWrapText(true);
        logContent.getChildren().add(logMessageLabel);

    }

    private static void playerAction(boolean cardSelected, Unit u, int unitIndex){
        if(cardSelected){
            //call a function here
            selectedUnit = u;
            unitSelected = true;





            instructionsLabel.setText("Pick a card");

            game.processTurn(game.getHand().get(cardSelectedIndex), selectedUnit);

            addMessage(logContent, game.getTurnLog());

            enemyTarget = game.getEnemyTarget();

            if(enemyTarget instanceof Friend){
                friendStatsLabelHolder.get(game.getEnemyTargetIndex()).setText(enemyTarget.getName() + "\n" +
                        "HP: " + enemyTarget.getCurrentHealth() + "/" + enemyTarget.getMaxHealth() + "\n" +
                        "Attack: " + enemyTarget.getAttack() + "\n" +
                        "Defense: " + enemyTarget.getDefense());
            }
            else{
                enemyStatsLabelHolder.get(game.getEnemyTargetIndex()).setText(enemyTarget.getName() + "\n" +
                        "HP: " + enemyTarget.getCurrentHealth() + "/" + enemyTarget.getMaxHealth() + "\n" +
                        "Attack: " + enemyTarget.getAttack() + "\n" +
                        "Defense: " + enemyTarget.getDefense());
            }

            if(selectedUnit instanceof Enemy){
                enemyStatsLabelHolder.get(unitIndex).setText(u.getName() + "\n" +
                        "HP: " + u.getCurrentHealth() + "/" + u.getMaxHealth() + "\n" +
                        "Attack: " + u.getAttack() + "\n" +
                        "Defense: " + u.getDefense());
            }
            else{
                friendStatsLabelHolder.get(unitIndex).setText(u.getName() + "\n" +
                        "HP: " + u.getCurrentHealth() + "/" + u.getMaxHealth() + "\n" +
                        "Attack: " + u.getAttack() + "\n" +
                        "Defense: " + u.getDefense());
            }

            game.setTurnLog("");


            cardSelected = false;
            unitSelected = false;
        }
        else{
            addMessage(logContent, "Please select a target...");
        }
    }

    private void backToMenu(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/group5/StartScreenUD2Balatro.fxml"));
            Parent startScreenRoot = fxmlLoader.load();
            Scene startScreenScene = new Scene(startScreenRoot);

            // Get the current stage and set the StartScreen scene
            Stage stage = (Stage) backToMenuLabel.getScene().getWindow();
            stage.setScene(startScreenScene);
        } catch (IOException e) {
            System.err.println("Error loading StartScreen: " + e.getMessage());
        }
    }


}
