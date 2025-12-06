package se.yrgo.game.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameUITest {

    @Test
    void testGetUserInput(){
        Scanner scanner = new Scanner("line\n");

        GameUI gameUI = new GameUI(scanner);
        var input = gameUI.getInput();
        assertEquals("line", input);
    }

}