package se.yrgo.game.ui;

import se.yrgo.game.gameplay.Game;

import java.util.*;

public class StartMenu {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        boolean using = true;

        do {
            System.out.println("\n***MENU***");
            System.out.println("\n1. Play\n2. Exit");
            System.out.print("OPTION: ");
            int menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1 -> game.runGame(scanner);
                case 2 -> { using = false; break; }
            }
        } while (using);
    }
}
