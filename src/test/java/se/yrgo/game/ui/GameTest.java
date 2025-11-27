package se.yrgo.game.ui;

import org.junit.jupiter.api.Test;
import se.yrgo.game.gameplay.Game;

import java.util.Scanner;

class GameTest {
    private Game game = new Game();
    private Scanner scanner = new Scanner(System.in);

//    @Test
//    void constructsCorrectNoOfRooms() {
//        var testGame = new Game();
//        assertEquals(Game.START_AMOUNT_OF_ROOMS, testGame.);
//    }

    @Test
    void input() {
        var input = game.getUserInput(new int[]{1, 2}, scanner);
        System.out.println(input);

        scanner.nextLine();
    }
}