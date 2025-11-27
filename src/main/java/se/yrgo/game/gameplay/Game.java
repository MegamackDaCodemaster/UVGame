package se.yrgo.game.gameplay;

import se.yrgo.game.Room.Room1;
import se.yrgo.game.items.Item;
import se.yrgo.game.player.Player;
import se.yrgo.game.Room.Room;
import se.yrgo.game.Room.RoomMain;
import se.yrgo.game.monster.Monster;
import se.yrgo.game.ui.GameUI;

import java.util.*;

public class Game {
    private Player player; //todo move to constructor and get method for setting name
    private List<Room> rooms;
    private Scanner scanner;
    private GameActions gameActions;
    private GameUI gameUI;

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

        rooms.add(new Room1("Cave", "A dark and creepy cave") {
        });

//        for (int i = 0; i < START_AMOUNT_OF_ROOMS; i++) {
//            rooms.add(RoomMain.getRoom()); //Todo: Need a method for getting a room object
//        }
    }

    public void runGame() {

        GameUI.printToScreen("Choose a player name: ");
        String name = scanner.nextLine();

        if (name == null || name.isBlank()) {
            GameUI.printToScreen("Incompatible name format. Your name is now 'Humble Hero'!");
            name = "Humble Hero";
        }
        name = name.strip();
        player = new Player(name, 100, 0);

        gameActions.setPlayer(player);

        GameUI.printToScreen(String.format("Welcome %s! You start your journey here...%n", player.getName()));
        GameUI.printWaitingIntervalDots();

        while (!rooms.isEmpty() && player.getHealth() > 0) {
            int roomCounter = 0;

            gameActions.setRoom(rooms.get(roomCounter));
            gameActions.encounterRoom();

            rooms.remove(rooms.get(roomCounter));
            roomCounter++;
        }

        if (gameActions.isPlayerDead(player)) {
            GameUI.printToScreen("""
                    Game over.
                    Better luck next time!
                    """);
        }
        else {
            GameUI.printToScreen(String.format("""
                    At last, %s steps out of the last room and reaches the goal...
                    
                    You have cleared the game!!
                    
                    Final score: %d
                    """, player.getName(), player.getScore()));
        }
    }
}
