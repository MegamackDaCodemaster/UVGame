package se.yrgo.game.gameplay;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.yrgo.game.Room.Room;
import se.yrgo.game.Room.Room1;
import se.yrgo.game.items.Item;
import se.yrgo.game.items.Potion;
import se.yrgo.game.monster.Monster;
import se.yrgo.game.monster.Troll;
import se.yrgo.game.player.Player;
import se.yrgo.game.ui.GameUI;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;


class GameActionsTest {
    private GameActions gameActions;
    private GameUI gameUI;
    private Scanner scanner;

    private Player player;
    private Monster monster;
    private Item item;
    private Room room;

    private String encounterRoomInput_LeaveItemChoice = "\n\n\n\n\n\n\n\n\n\n2\n\n\n";
    private String encounterRoomInput_PickUpItemChoice = "\n\n\n\n\n\n\n\n\n\n1\n\n\n";


    void setUp(Scanner scanner) {
        gameUI = new GameUI(scanner);
        gameActions = new GameActions(scanner, gameUI);

        player = new Player("Mock Hero", 100, 0, 20);
        gameActions.setPlayer(player);

        monster = new Troll();
        item = new Potion("Health potion", 20_000);

        room = new Room1("Entrance", "Cold air creeps from the darkness.");
        room.setMonster(monster);
        room.setItem(item);

        gameActions.setRoom(room);
    }

    @Test
    void encounterRoomSafely_NotPickUpItem() {
        this.scanner = new Scanner(encounterRoomInput_LeaveItemChoice);
        setUp(scanner);

        assertTrue(gameActions.encounterRoom());
    }

    @Test
    void encounterRoomSafely_PickUpItemHealthPotion() {
        this.scanner = new Scanner(encounterRoomInput_PickUpItemChoice);
        setUp(scanner);

        assertTrue(gameActions.encounterRoom());
        assertTrue(player.getHealth() > 20_000);
    }

    @Test
    void exitIfPlayerIsKilledInBattle() {
        String inputThatWorksWhenPlayerIsKilledInOneStrike = "\n\n\n\n";
        this.scanner = new Scanner(inputThatWorksWhenPlayerIsKilledInOneStrike);
        setUp(scanner);

        player.decreaseHealth(99);
        assertFalse(gameActions.encounterRoom());
    }

    @AfterEach
    void closeScanner() {
        scanner.close();
    }
}