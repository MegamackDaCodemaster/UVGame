package se.yrgo.game.gameplay;

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

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameActionsTest {
    private GameActions gameActions;
    private GameUI gameUI;

    private Player player;
    private Monster monster;
    private Item item;
    private Room room;

    private String input = "\n\n\n\n\n\n\n\n2\n\n";


    @BeforeEach
    void setUp() {
        Scanner scanner = new Scanner(input);

        gameUI = new GameUI(scanner);
        gameActions = new GameActions(scanner, gameUI);

        gameActions.setPlayer(new Player("Mock Hero", 100, 0));

        monster = new Troll();
        item = new Potion("Health potion", 50);

        room = new Room1("library", "a dusty library");
        room.addMonster(monster);
        room.addItem(item);

        gameActions.setRoom(room);
    }

    @Test
    void encounterRoom() {
        gameActions.encounterRoom();
    }
}