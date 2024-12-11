package group5.startscreenud2balatro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class GamePlayController {

    @FXML
    private Label gameStatusLabel;

    @FXML
    private ImageView gamePlayImage;

    @FXML
    private Label floorInfoLabel;
    @FXML
    private TextArea friend1;
    @FXML
    private TextArea friend2;
    @FXML
    private TextArea friend3;

    @FXML
    private TextArea enemy1;
    @FXML
    private TextArea enemy2;
    @FXML
    private TextArea enemy3;
    @FXML
    private TextArea card1;
    @FXML
    private TextArea card2;
    @FXML
    private TextArea card3;
    @FXML
    private TextArea card4;
    @FXML
    private TextArea card5;
    @FXML
    private TextArea activityLogTextField;

    @FXML
    private Button enterButton;
    @FXML
    private Button homeButton;

    @FXML
    private TextArea playerInput;

    @FXML
    private Label playerInputLabel;

    @FXML
    private Label errorMessageLabel;

    private String errorMessage;

    private GameMaster game;

    private Card selectedCard;

    private int selectedTarget;

    private int unitTurn = 0;

    boolean gameOver = false;

    @FXML
    private void onClickhome() {
        System.out.println(" Returning to main menue ");

        // Load the StartScreen scene
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/group5/StartScreenUD2Balatro.fxml"));
            Parent startScreenRoot = fxmlLoader.load();
            Scene startScreenScene = new Scene(startScreenRoot);

            // Get the current stage and set the StartScreen scene
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(startScreenScene);
        } catch (IOException e) {
            System.err.println("Error loading StartScreen: " + e.getMessage());
        }
    }

    public void initialize() {
        // Load the image when the scene is initialized
        // Image image = new Image(getClass().getResource("/group5/gamePlayScreen.png").toExternalForm());
        // gamePlayImage.setImage(image);
        game = GameMaster.getInstance("Player 1", 10); //Default parameters for testing
        game.initializeFloor();
        floorInfoLabel.setText("Floor:   " + game.getCurrentFloor() + "/" + game.getTotalFloor());

        //populate friend units textbox
        friend1.setWrapText(true);
        friend2.setWrapText(true);
        friend3.setWrapText(true);
        friend1.setEditable(false);
        friend2.setEditable(false);
        friend3.setEditable(false);

        friend1.insertText(0, "Defense: " + game.getActiveFriendUnits().get(0).getDefense());
        friend1.insertText(0, "Attack: " + game.getActiveFriendUnits().get(0).getAttack() + "\n");
        friend1.insertText(0, "HP: " + game.getActiveFriendUnits().get(0).getCurrentHealth() + "/" + game.getActiveFriendUnits().get(0).getMaxHealth() + "\n");
        friend1.insertText(0, game.getActiveFriendUnits().get(0).getName() + "\n");

        friend2.insertText(0, "Defense: " + game.getActiveFriendUnits().get(1).getDefense());
        friend2.insertText(0, "Attack: " + game.getActiveFriendUnits().get(1).getAttack() + "\n");
        friend2.insertText(0, "HP: " + game.getActiveFriendUnits().get(1).getCurrentHealth() + "/" + game.getActiveFriendUnits().get(1).getMaxHealth() + "\n");
        friend2.insertText(0, game.getActiveFriendUnits().get(1).getName() + "\n");

        friend3.insertText(0, "Defense: " + game.getActiveFriendUnits().get(2).getDefense());
        friend3.insertText(0, "Attack: " + game.getActiveFriendUnits().get(2).getAttack() + "\n");
        friend3.insertText(0, "HP: " + game.getActiveFriendUnits().get(2).getCurrentHealth() + "/" + game.getActiveFriendUnits().get(2).getMaxHealth() + "\n");
        friend3.insertText(0, game.getActiveFriendUnits().get(2).getName() + "\n");


        //populate enemy units textbox
        enemy1.setWrapText(true);
        enemy2.setWrapText(true);
        enemy3.setWrapText(true);
        enemy1.setEditable(false);
        enemy2.setEditable(false);
        enemy3.setEditable(false);

        enemy1.insertText(0, "Defense: " + game.getActiveEnemyUnits().get(0).getDefense());
        enemy1.insertText(0, "Attack: " + game.getActiveEnemyUnits().get(0).getAttack() + "\n");
        enemy1.insertText(0, "HP: " + game.getActiveEnemyUnits().get(0).getCurrentHealth() + "/" + game.getActiveEnemyUnits().get(0).getMaxHealth() + "\n");
        enemy1.insertText(0, game.getActiveEnemyUnits().get(0).getName() + "\n");

        enemy2.insertText(0, "Defense: " + game.getActiveEnemyUnits().get(1).getDefense());
        enemy2.insertText(0, "Attack: " + game.getActiveEnemyUnits().get(1).getAttack() + "\n");
        enemy2.insertText(0, "HP: " + game.getActiveEnemyUnits().get(1).getCurrentHealth() + "/" + game.getActiveEnemyUnits().get(1).getMaxHealth() + "\n");
        enemy2.insertText(0, game.getActiveEnemyUnits().get(1).getName() + "\n");

        enemy3.insertText(0, "Defense: " + game.getActiveEnemyUnits().get(2).getDefense());
        enemy3.insertText(0, "Attack: " + game.getActiveEnemyUnits().get(2).getAttack() + "\n");
        enemy3.insertText(0, "HP: " + game.getActiveEnemyUnits().get(2).getCurrentHealth() + "/" + game.getActiveEnemyUnits().get(2).getMaxHealth() + "\n");
        enemy3.insertText(0, game.getActiveEnemyUnits().get(2).getName() + "\n");

        //populate card textbox
        loadCards();

        activityLogTextField.setWrapText(true);
        activityLogTextField.setEditable(false);
        activityLogTextField.insertText(0, game.getPlayer() + " has entered the Tower. Starting on Floor 1....\n");

        errorMessageLabel.setText("");



    }

    public void onEnterClick(){
        if(gameOver){
            activityLogTextField.appendText("Game Over!");
            return;
        }

        errorMessageLabel.setText("");
        boolean cardPicked = false;
        boolean targetPicked = false;

        String input = playerInput.getText().trim();
        int selectedIndex;

        boolean heal = false;




        try{
            selectedIndex = Integer.parseInt(input);

            // validates card selection isn't larger than hand size
//            if (selectedIndex <= 0 && selectedIndex >= game.getHand().size()) {
//                errorMessageLabel.setText("Invalid card selection. Please select a valid card.");
//                return;
//            }

            if(selectedCard == null){


                cardPicked = checkCardSelection(selectedIndex);
                if(cardPicked){
                    selectedCard = game.getHand().get(selectedIndex - 1);
                }


                //clear input
                playerInput.clear();
                input = "";
                if(selectedCard.getActionType().equals("attack") || selectedCard.getActionType().equals("heal")){
                    playerInputLabel.setText("Please choose a target");

                }
                else{
                    //if the card type is not for attacking or healing, then the move is for the current unit
                    targetPicked = true;
                    selectedTarget = 1;

                }

                if(cardPicked && targetPicked){
                    if(unitTurn > 2){
                        unitTurn = 0;
                    }
                    makeMove(selectedCard, selectedTarget, heal);
                    selectedCard = null;
                    return;

                }
            }

            else {
                cardPicked = checkCardSelection(selectedIndex);
                if(selectedCard.getActionType().equals("attack") || selectedCard.getActionType().equals("heal")){
                    playerInputLabel.setText("Please choose a target");

                    //picking card from hand
                    input = playerInput.getText().trim();
                    selectedIndex = Integer.parseInt(input);
                    targetPicked = checkTargetSelection(selectedIndex);
                    selectedTarget = selectedIndex - 1;

                    //clear input
                    playerInput.clear();
                    input = "";

                    //check if heal card is picked
                    heal = selectedCard.getActionType().equals("heal");


                }

                else{
                    //if the card type is not for attacking or healing, then the move is for the current unit
                    targetPicked = true;
                    selectedTarget = 1;
                }

//                    playerInputLabel.setText("Please select a card");



            }

            if(cardPicked && targetPicked){
                if(unitTurn > 2){
                    unitTurn = 0;
                }
                makeMove(selectedCard, selectedTarget, heal);
                selectedCard = null;
                selectedTarget = 0;
                return;

            }



        }
        catch(NumberFormatException e){
            playerInput.clear();
            errorMessageLabel.setText("Error: Please enter a number.");
            return;
        }
        catch(IndexOutOfBoundsException e){
            playerInput.clear();
            errorMessageLabel.setText("Error: " + e.getMessage());
            return;
        }

    }

    //will update unit stats on screen
    public void updateTextAreas(){
        friend1.clear();
        friend2.clear();
        friend3.clear();
        enemy1.clear();
        enemy2.clear();
        enemy3.clear();
        //populate friend units textbox
        friend1.setWrapText(true);
        friend2.setWrapText(true);
        friend3.setWrapText(true);

        friend1.insertText(0, "Defense: " + game.getActiveFriendUnits().get(0).getDefense());
        friend1.insertText(0, "Attack: " + game.getActiveFriendUnits().get(0).getAttack() + "\n");
        friend1.insertText(0, "HP: " + game.getActiveFriendUnits().get(0).getCurrentHealth() + "/" + game.getActiveFriendUnits().get(0).getMaxHealth() + "\n");
        friend1.insertText(0, game.getActiveFriendUnits().get(0).getName() + "\n");

        friend2.insertText(0, "Defense: " + game.getActiveFriendUnits().get(1).getDefense());
        friend2.insertText(0, "Attack: " + game.getActiveFriendUnits().get(1).getAttack() + "\n");
        friend2.insertText(0, "HP: " + game.getActiveFriendUnits().get(1).getCurrentHealth() + "/" + game.getActiveFriendUnits().get(1).getMaxHealth() + "\n");
        friend2.insertText(0, game.getActiveFriendUnits().get(1).getName() + "\n");

        friend3.insertText(0, "Defense: " + game.getActiveFriendUnits().get(2).getDefense());
        friend3.insertText(0, "Attack: " + game.getActiveFriendUnits().get(2).getAttack() + "\n");
        friend3.insertText(0, "HP: " + game.getActiveFriendUnits().get(2).getCurrentHealth() + "/" + game.getActiveFriendUnits().get(2).getMaxHealth() + "\n");
        friend3.insertText(0, game.getActiveFriendUnits().get(2).getName() + "\n");


        //populate enemy units textbox
        enemy1.setWrapText(true);
        enemy2.setWrapText(true);
        enemy3.setWrapText(true);

        enemy1.insertText(0, "Defense: " + game.getActiveEnemyUnits().get(0).getDefense());
        enemy1.insertText(0, "Attack: " + game.getActiveEnemyUnits().get(0).getAttack() + "\n");
        enemy1.insertText(0, "HP: " + game.getActiveEnemyUnits().get(0).getCurrentHealth() + "/" + game.getActiveEnemyUnits().get(0).getMaxHealth() + "\n");
        enemy1.insertText(0, game.getActiveEnemyUnits().get(0).getName() + "\n");

        enemy2.insertText(0, "Defense: " + game.getActiveEnemyUnits().get(1).getDefense());
        enemy2.insertText(0, "Attack: " + game.getActiveEnemyUnits().get(1).getAttack() + "\n");
        enemy2.insertText(0, "HP: " + game.getActiveEnemyUnits().get(1).getCurrentHealth() + "/" + game.getActiveEnemyUnits().get(1).getMaxHealth() + "\n");
        enemy2.insertText(0, game.getActiveEnemyUnits().get(1).getName() + "\n");

        enemy3.insertText(0, "Defense: " + game.getActiveEnemyUnits().get(2).getDefense());
        enemy3.insertText(0, "Attack: " + game.getActiveEnemyUnits().get(2).getAttack() + "\n");
        enemy3.insertText(0, "HP: " + game.getActiveEnemyUnits().get(2).getCurrentHealth() + "/" + game.getActiveEnemyUnits().get(2).getMaxHealth() + "\n");
        enemy3.insertText(0, game.getActiveEnemyUnits().get(2).getName() + "\n");

        //update floor label
        floorInfoLabel.setText("Floor:   " + game.getCurrentFloor() + "/" + game.getTotalFloor());
//        loadCards();
    }

    //helper function for readability of onEnterClick
    private void makeMove(Card c, int target, boolean heal){

//        target -= 1;
        Random random = new Random();
        int randNum = random.nextInt(3);
        String victoryMessage;
        victoryMessage = game.checkWinner();
        if(!victoryMessage.equals("")){
            activityLogTextField.appendText(victoryMessage + "\n");
            gameOver = true;
            return;
        }
        if(heal){
            if(game.getActiveFriendUnits().get(unitTurn).getCurrentHealth() > 0){
                activityLogTextField.appendText(game.getActiveFriendUnits().get(unitTurn).action(c, game.getActiveFriendUnits().get(target)) + "\n");
            }
            else{
                activityLogTextField.appendText(game.getActiveFriendUnits().get(unitTurn).getName() + " is already dead\n");
            }
            if(game.getActiveFriendUnits().get(unitTurn).getCurrentHealth() > 0){
                activityLogTextField.appendText(game.getActiveEnemyUnits().get(unitTurn).action(game.getActiveFriendUnits().get(randNum)) + "\n");
            }
            else{
                activityLogTextField.appendText(game.getActiveEnemyUnits().get(unitTurn).getName() + " is already dead\n");
            }

        }
        else{
            if(game.getActiveFriendUnits().get(unitTurn).getCurrentHealth() > 0){
                activityLogTextField.appendText(game.getActiveFriendUnits().get(unitTurn).action(c, game.getActiveEnemyUnits().get(target)) + "\n");
            }
            else{
                activityLogTextField.appendText(game.getActiveFriendUnits().get(unitTurn).getName() + " is already dead\n");
            }
            if(game.getActiveFriendUnits().get(unitTurn).getCurrentHealth() > 0){
                activityLogTextField.appendText(game.getActiveEnemyUnits().get(unitTurn).action(game.getActiveFriendUnits().get(randNum)) + "\n");
            }
            else{
                activityLogTextField.appendText(game.getActiveEnemyUnits().get(unitTurn).getName() + " is already dead\n");
            }


        }
        unitTurn++;
        playerInputLabel.setText("Please select a card");
        if(game.getActiveFriendUnits().get(unitTurn).getCurrentHealth() > 0){
            game.getHand().remove(selectedCard);
            game.pullCardFromDeck();
        }

        loadCards();
        updateTextAreas();

    }

    private boolean checkCardSelection(int index) throws IndexOutOfBoundsException {
        // changed from && to or
        if (index < 1 || index > 5) {
            throw new IndexOutOfBoundsException("Index must be between 1 and 5.");
        }
        return true;
    }
    private boolean checkTargetSelection(int index) throws IndexOutOfBoundsException {
        // changed from && to or
        if (index < 1 || index > 3) {
            throw new IndexOutOfBoundsException("Index must be between 1 and 3.");
        }
        return true;
    }

    private void loadCards(){
        //clears the textArea
        card1.clear();
        card2.clear();
        card3.clear();
        card4.clear();
        card5.clear();

        //sets the text inside to continue at the next line if it hit the edge
        card1.setWrapText(true);
        card2.setWrapText(true);
        card3.setWrapText(true);
        card4.setWrapText(true);
        card5.setWrapText(true);


        //populate the text area using card information


        card1.insertText(0, game.getHand().get(0).getCardName() + "\n");
        card1.appendText("Card Type: " + game.getHand().get(0).getActionType() + "\n");
        card1.appendText("Card Power: " + game.getHand().get(0).getActionValue());

        card2.insertText(0, game.getHand().get(1).getCardName() + "\n");
        card2.appendText("Card Type: " + game.getHand().get(1).getActionType() + "\n");
        card2.appendText("Card Power: " + game.getHand().get(1).getActionValue());

        card3.insertText(0, "Card Power: " + game.getHand().get(2).getActionValue());
        card3.insertText(0, "Card Type: " + game.getHand().get(2).getActionType() + "\n");
        card3.insertText(0, game.getHand().get(2).getCardName() + "\n");

        card4.insertText(0, "Card Power: " + game.getHand().get(3).getActionValue());
        card4.insertText(0, "Card Type: " + game.getHand().get(3).getActionType() + "\n");
        card4.insertText(0, game.getHand().get(3).getCardName() + "\n");

        card5.insertText(0, "Card Power: " + game.getHand().get(4).getActionValue());
        card5.insertText(0, "Card Type: " + game.getHand().get(4).getActionType() + "\n");
        card5.insertText(0, game.getHand().get(4).getCardName() + "\n");
    }



    /**
     * Updates the game state and modifies the label accordingly.
     * @param state The state of the game ("Playing", "Win", "Lose").
     */
    public void setGameState(String state) {
        switch (state) {
            case "Win":
                gameStatusLabel.setText("You Win!");
                break;
            case "Lose":
                gameStatusLabel.setText("Game Over");
                break;
            default:
                gameStatusLabel.setText("Playing...");
        }
    }
}