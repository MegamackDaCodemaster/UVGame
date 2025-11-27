package se.yrgo.game.ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameUITest {
    GameUI gameUI;

    void createCustomTestInput(String mockInput) {
        ByteArrayInputStream bais = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(bais);
    }

    @Test
    void clearScannerBuffer_withMockInput() {
        try {
            createCustomTestInput("Blablabla");
            Scanner scanner = new Scanner(System.in);

            assertTrue(scanner.hasNext());
            gameUI = new GameUI(scanner);

            gameUI.flushScanner();
            assertFalse(scanner.hasNext());
        }
        catch (Exception e) {
            fail("Should not throw on this test.", e);
        }
    }
}