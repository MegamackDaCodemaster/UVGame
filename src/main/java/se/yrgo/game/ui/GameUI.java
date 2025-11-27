package se.yrgo.game.ui;

import java.util.Scanner;

public final class GameUI {
    private final Scanner scanner;

    public GameUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void printToScreen(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public static void pauseTextFlow(int millisToPause) {
        try {
            Thread.sleep(millisToPause);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }

    public static void printWaitingIntervalDots() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.printf(".");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        System.out.println();
    }
}
