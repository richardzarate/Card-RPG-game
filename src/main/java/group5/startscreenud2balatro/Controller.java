package group5.startscreenud2balatro;

import java.io.*;

public class Controller implements Serializable {

    private GameMaster gameMaster;
    private static Controller controllerInstance;
    private static final String DEFAULT_SAVE_FILE = "latestGameState.bin";

    // Constructor
    private Controller() {
        this.gameMaster = null;
    }


    public static Controller getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }


    public void saveToBinaryFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DEFAULT_SAVE_FILE))) {
            oos.writeObject(this); // Save the entire Controller instance
            System.out.println("Game state saved to binary file at: " + DEFAULT_SAVE_FILE);
        } catch (IOException e) {
            System.err.println("Error saving game state to binary file: " + e.getMessage());
        }
    }

    // Load the game state from a binary file
    public static Controller loadFromBinaryFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            controllerInstance = (Controller) ois.readObject(); // Load the Controller instance
            System.out.println("Game state loaded from binary file at: " + filePath);
            return controllerInstance;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading game state from binary file: " + e.getMessage());
            return null;
        }
    }


    public void continueGame() {
        File saveFile = new File(DEFAULT_SAVE_FILE);
        if (saveFile.exists()) {
            controllerInstance = loadFromBinaryFile(DEFAULT_SAVE_FILE);
            if (controllerInstance != null) {
                System.out.println("Game successfully continued from the most recent save.");
                System.out.println("Loaded GameMaster player: " + controllerInstance.getGameMaster().getPlayer());
            } else {
                System.out.println("Failed to load the game from the save file.");
            }
        } else {
            System.out.println("No saved game found. Starting a new game.");
        }
    }

    public GameMaster getGameMaster() {
        return gameMaster;
    }

    public void setGameMaster(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
    }
}



