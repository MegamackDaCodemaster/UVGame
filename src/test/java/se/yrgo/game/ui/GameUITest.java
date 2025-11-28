package se.yrgo.game.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameUITest {
    private GameUI gameUI;
    private String mockInput = "line1\nline2\n";

    @BeforeEach
    void test() {
        gameUI = new GameUI(new Scanner(mockInput));
    }

    @Test
    void getUserInput_afterClearingPreviousLineInBuffer(){
        var input = gameUI.getInput();
        assertEquals("line2", input);
    }


}