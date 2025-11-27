package se.yrgo.game.ui;

import se.yrgo.game.items.Item;
import se.yrgo.game.player.Player;
import se.yrgo.game.Room.Room1;
import se.yrgo.game.monster.Monster;

import java.util.*;

public class Game {
    private Player player; //Initialized in runGame method
    private List<Room1> room1s;
    private int numberOfRoomsInGame;
    private Scanner scanner; //Todo: init in constructor

    public Game() {
        numberOfRoomsInGame = 10;
        initializeRooms();
    }

    private void initializeRooms() {
        room1s = new ArrayList<>();

        for (int i = 0; i < numberOfRoomsInGame; i++) {
            room1s.add(RoomMain.getRoom()); //Todo: Need a method for getting a room object
        }
    }

    public void runGame(Scanner scanner) {
        this.scanner = scanner;

        System.out.println("Choose a player name: ");
        String name = scanner.nextLine();

        if (name == null || name.isBlank()) {
            System.out.println("Incompatible name format. Your name is now 'Humble Hero'!");
            name = "Humble Hero";
        }
        name = name.strip();
        player = new Player(name, 100, 0);

        System.out.printf("Welcome %s! You start your journey here...%n", player.getName());
        printWaitingIntervalDots();

        while (!room1s.isEmpty() && player.getHealth() > 0) {
            int roomCounter = 0;

            encounterRoom(player, room1s.get(roomCounter));

            room1s.remove(room1s.get(roomCounter));
            roomCounter++;
        }

        if (player.getHealth() <= 0) {
            //Game over
        } else {
            System.out.printf("At last, %s steps out of the last room and reaches the goal...%n%n", player.getName());
            System.out.println("You have cleared the game!!");
            System.out.printf("Final score: %d", player.getScore());
        }

    }

    /**
     * Room encounter logics. Returns true if room was cleared without dying, false otherwise...
     *
     * @param player the current player
     * @param room1   the room to encounter
     * @return true if all went well, false if player died
     */
    private boolean encounterRoom(Player player, Room1 room1) {
        //Todo: Don't forget: end of battle, increase score

        System.out.printf("You step into %s%n", room1.getName().toLowerCase());
        System.out.printf("Where you encounter %s! Get ready for battle!!%n",
                room1.getMonster.getPresentation.toLower()); //Todo somehow get the room's monster
        pauseTextFlow(2000);

        doBattle(player, room1.getMonster);

        if (isPlayerDead(player)) {
            return false;
        }

        pauseTextFlow(2000);
        System.out.println("************************\n");

        if (room1.getItem() != null) { //Todo: get the room's item
            findItem(player, room1.getItem);
        }

        if (isPlayerDead(player)) {
            return false;
        }

        System.out.println("You exit the room.");
        return true;
    }


    private boolean isPlayerDead(Player player) {
        return player.getHealth() <= 0;
    }


    public void doBattle(Player player, Monster monster) {
        System.out.printf("""
                - BATTLE WITH %s - 
                """, monster.getMonsterType().toUpperCase());

        while (!isPlayerDead(player) && monster.getHealth() > 0) {
            System.out.printf("""
                            %s: %d HP left
                            %s: %d HP left
                            """,
                    player.getName(), player.getHealth(),
                    monster.getMonsterType(), monster.getHealth());

            pauseTextFlow(1500);
            System.out.printf("%s charges the %s!", player.getName(), monster.getMonsterType());

            int damage = player.getAttackDamage();
            monster.wound(damage);

            System.out.printf("You inflicted %d points of damage to the %s!%n", damage, monster.getMonsterType());
            pauseTextFlow(1500);

            if (monster.getHealth() <= 0) {
                System.out.printf("You killed the %s!%n", monster.getMonsterType());
                break;
            }

            System.out.printf("It's still alive and kicking ");
            printWaitingIntervalDots();
            System.out.printf("you!%n");
            pauseTextFlow(1000);

            player.decreaseHealth(monster.getAttackDamage());
            System.out.printf("You take %d points of damage! Ouch!", monster.getAttackDamage());
            pauseTextFlow(1000);
        }

        if (!isPlayerDead(player)) {
            player.increaseScore(monster.getRewardPoints());
            System.out.printf("Congratulations! You won the battle! You earned %d victory points!",
                    monster.getRewardPoints());
        }
    }

    private void findItem(Player player, Item item) {
        System.out.println("What's this? The monster dropped something...");

        System.out.printf("You see %s.%n", item.getName); //Todo: getName method on item.

        System.out.println("What do you want to do?");

        System.out.printf("""
                1. Pick it up and use. YOLO!
                2. Leave it. It might be dangerous. 
                """);

        var input = getUserInput(new int[]{1, 2});

        if (input == 1) {
            item.pickup(player);
        } else {
            System.out.println("You leave it lying and walk away.");
        }
    }

    private int getUserInput(int[] possibleChoices) {
        int input = -1;

        while (!Arrays.asList(possibleChoices).contains(input)) { //Todo: test!
            try {
                input = scanner.nextInt();
                if (!Arrays.asList(possibleChoices).contains(input)) {
                    System.out.println("Wrong input, try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again: ");
            }
        }
        return input;
    }

    private void printWaitingIntervalDots() {
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

    private void pauseTextFlow(int milisToPause) {
        try {
            Thread.sleep(milisToPause);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }
}

//Todo: Create GameUi class?
