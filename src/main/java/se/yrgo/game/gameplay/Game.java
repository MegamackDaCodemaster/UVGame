package se.yrgo.game.gameplay;

import se.yrgo.game.Room.Room1;
import se.yrgo.game.items.Item;
import se.yrgo.game.items.Potion;
import se.yrgo.game.monster.Troll;
import se.yrgo.game.player.Player;
import se.yrgo.game.Room.Room;
import se.yrgo.game.monster.Monster;
import se.yrgo.game.ui.GameUI;

import java.io.IOException;
import java.util.*;

public final class Game {
    private Player player; //todo move to constructor and get method for setting name
    private List<Room> rooms;
    private final Scanner scanner;
    private final GameActions gameActions;
    private final GameUI gameUI;

    public static int START_AMOUNT_OF_ROOMS = 10;

    public Game(Scanner scanner) {
        Objects.requireNonNull(scanner);
        this.scanner = scanner;

        gameUI = new GameUI(scanner);
        gameActions = new GameActions(scanner, gameUI);

        initializeRooms();
    }


    private void initializeRooms() {
        rooms = new ArrayList<>();

        Monster monster = new Troll();
        Item item = new Potion("Health potion", 50);
        Room room = new Room1("Cave", "A dark and creepy cave");
        room.addMonster(monster);
        room.addItem(item);

        rooms.add(room);

    }

    public void runGame() {
//        try {
//            gameUI.testKey();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        setUpPlayer();

        GameUI.printToScreen(String.format("""
                %nWelcome %s!
                In this game you will be informed of game events in text-form.
                When you have read the text and wish to continue, press enter once:
                """, player.getName()));
        gameUI.waitForKeyPress();

        GameUI.printToScreen(String.format("Excellent. Now, your journey may start...%n"));
        GameUI.printWaitingIntervalDots(5);

        while (!rooms.isEmpty() && player.getHealth() > 0) {
            int roomCounter = 0;

            gameActions.setRoom(rooms.get(roomCounter));
            gameActions.encounterRoom();

            rooms.remove(rooms.get(roomCounter));
            roomCounter++;
        }

        if (gameActions.isPlayerDead(player)) {
            GameUI.printToScreen(String.format("""
                    Game over.
                    Better luck next time!
                    """));

            gameUI.waitForKeyPress();
        } else {
            GameUI.printToScreen(String.format("""
                    At last, %s steps out of the last room and reaches the goal...
                    
                    You have cleared the game!!
                    
                    Final score: %d
                    """, player.getName(), player.getScore()));

            gameUI.waitForKeyPress();
        }
    }

    private void setUpPlayer() {
        GameUI.printToScreen("Choose a player name: ");

        String name = gameUI.getInput();

        if (name == null || name.isBlank()) {
            GameUI.printToScreen(String.format("Incompatible name format. Your name is now 'The Humble Hero'!%n%n"));
            name = "The Humble Hero";
        }
        name = name.strip();
        player = new Player(name, 100, 0);

        gameActions.setPlayer(player);
    }
}
