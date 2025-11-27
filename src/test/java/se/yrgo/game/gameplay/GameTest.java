package se.yrgo.game.gameplay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class GameTest {
    private Scanner scanner;
    private Game game;

    public GameTest() {
        scanner = new Scanner(System.in);
        game = new Game(scanner);
    }

//    @Test
//    void constructsCorrectNoOfRooms() {
//        var testGame = new Game();
//        assertEquals(Game.START_AMOUNT_OF_ROOMS, testGame.);
//    }

    @Test
    void input() {

    }
}