package se.yrgo.game.ui;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class GameUI {
    private final Scanner scanner;

    public GameUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void printToScreen(String message) {
        System.out.printf(message);
    }

    public String getInput() {
        var input = scanner.nextLine();
        return input;
    }

    public static void pauseTextFlow(int millisToPause) {
        try {
            Thread.sleep(millisToPause);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }

    public static void printWaitingIntervalDots(int numberOfDots) {
        try {
            for (int i = 0; i < numberOfDots; i++) {
                System.out.printf(".");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        System.out.println();
    }

    public void waitForKeyPress() {
        var key = scanner.nextLine();
    }
}
