package se.yrgo.game.ui;

import java.util.*;

public class StartMenu {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n***MENU***");
        System.out.println("\n1. Play\n2. Exit");
        System.out.print("OPTION: ");
        int menuOption = scanner.nextInt();

        switch (menuOption) {
            case 1 -> game.runGame(scanner);
        }
    }
}
