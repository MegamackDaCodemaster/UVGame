package se.yrgo.game.gameplay;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    private Scanner scanner;
    private Game game;

    String badPlayerNameInput = " \n";
    String examplePlayerNameInput = "A name\n";

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
            System.out.println("This test's mock input only covers the test purpose, then NoSuchElementException is thrown.");
        } finally {
            assertEquals(Game.DEFAULT_PLAYER_NAME, game.getPlayer().getName());
        }
    }

    @Test
    void testPlayerChooseName() {
        setUp(examplePlayerNameInput);

        try {
            game.runGame();
        } catch (NoSuchElementException e) {
            System.out.println("This test's mock input only covers the test purpose, then NoSuchElementException is thrown.");
        } finally {
            assertEquals("A name", game.getPlayer().getName());
        }
    }

    @Test
    void throwWhenNoScannerArgInConstructor(){
        assertThrows(NullPointerException.class, () ->
                new Game(null));
    }

}