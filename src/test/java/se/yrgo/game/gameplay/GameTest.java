package se.yrgo.game.gameplay;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    private Scanner scanner;
    private Game game;

    String badPlayerNameInput = "\n \n";

    void setUp(String input) {
        scanner = new Scanner(input);
        game = new Game(scanner);
    }


    @Test
    void givePlayerDefaultName_whenInputIsEmpty() {
        setUp(badPlayerNameInput);

        try {
            game.runGame();
        } catch (NoSuchElementException e) {
            System.out.println("This test's mock input only covers the test purpose, then NSE Exception is thrown.");
        } finally {
            assertEquals(Game.DEFAULT_PLAYER_NAME, game.getPlayer().getName());
        }
    }


//    @Test
//    void constructsCorrectNoOfRooms() {
//        var testGame = new Game();
//        assertEquals(Game.START_AMOUNT_OF_ROOMS, testGame.);
//    }


}