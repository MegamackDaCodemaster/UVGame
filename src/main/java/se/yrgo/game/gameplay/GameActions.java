package se.yrgo.game.gameplay;

import se.yrgo.game.Room.Room;
import se.yrgo.game.items.Item;
import se.yrgo.game.monster.Monster;
import se.yrgo.game.player.Player;
import se.yrgo.game.ui.GameUI;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public final class GameActions {
    private Player player;
    private Room room;
    private Scanner scanner;
    private GameUI gameUI;

    public GameActions(Scanner scanner, GameUI gameUI) {
        this.scanner = scanner;
        this.gameUI = gameUI;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Room encounter logics. Returns true if room was cleared without dying, false otherwise...
     *
     * @return true if all went well, false if player died
     */
    public boolean encounterRoom() {
        GameUI.printToScreen(String.format("You step into the %s. %s%n",
                room.getName().toLowerCase(), room.getDescription()));
        GameUI.pauseTextFlow(1000);
        GameUI.printToScreen(String.format("...Where you encounter %s! Get ready for battle!!%n",
                room.getMonster().getDescription()));
        gameUI.waitForKeyPress();

        doBattle(player, room.getMonster());

        if (isPlayerDead(player)) {
            return false;
        }

        if (room.getItem() != null) {
            findItem(player, room.getItem());
        }

        if (isPlayerDead(player)) {
            return false;
        }

        GameUI.printToScreen("You exit the room.%n");
        GameUI.printToScreen(String.format("%n************************%n%n"));
        gameUI.waitForKeyPress();
        return true;
    }

    private void doBattle(Player player, Monster monster) {
        GameUI.printToScreen(String.format("""
                - BATTLE WITH %s - 
                """, monster.getMonsterName().toUpperCase()));

        while (!isPlayerDead(player) && monster.getHealth() > 0) {
            GameUI.printToScreen(String.format("""
                            %s: %d HP left
                            %s: %d HP left
                            """,
                    player.getName(), player.getHealth(),
                    monster.getMonsterName(), monster.getHealth()));

            gameUI.waitForKeyPress();
            GameUI.printToScreen(String.format("%s charges the %s!%n",
                    player.getName(), monster.getMonsterName().toLowerCase()));

            int damage = player.getAttackDamage();
            monster.wound(damage);
            GameUI.pauseTextFlow(1500);

            GameUI.printToScreen(String.format("You inflicted %d points of damage to the %s!%n",
                    damage, monster.getMonsterName().toLowerCase()));
            gameUI.waitForKeyPress();

            if (monster.getHealth() <= 0) {
                GameUI.printToScreen(String.format("You killed the %s!%n", monster.getMonsterName().toLowerCase()));
                gameUI.waitForKeyPress();
                break;
            }

            GameUI.printToScreen("It's still alive and kicking... ");
            GameUI.pauseTextFlow(1500);
            GameUI.printToScreen(String.format("you!!%n"));
            GameUI.pauseTextFlow(1500);

            int monsterAttackDamage = monster.getRandomAttack();
            player.decreaseHealth(monsterAttackDamage);
            GameUI.printToScreen(String.format("You take %d points of damage! Ouch!%n", monsterAttackDamage));
            gameUI.waitForKeyPress();
        }

        if (!isPlayerDead(player)) {
            player.increaseScore(monster.getRewardPoints());
            GameUI.printToScreen(String.format("Congratulations! You won the battle! You earned %d victory points!%n",
                    monster.getRewardPoints()));
            gameUI.waitForKeyPress();
        }
    }

    private void findItem(Player player, Item item) {
        GameUI.printToScreen("What's this? The monster dropped something...%n");
        gameUI.waitForKeyPress();

        GameUI.printToScreen(String.format("You see a %s.%n", item.getName())); //Todo: getName method on item.

        GameUI.printToScreen("What do you want to do?%n");

        GameUI.printToScreen(String.format("""
                1. Pick it up and use. YOLO!
                2. Leave it. It might be dangerous. 
                """));

        var input = getUserInput(new String[]{"1", "2"});

        if (input.contains("1")) {
            String itemResult = item.pickup(player);
            GameUI.printToScreen(itemResult);
            gameUI.waitForKeyPress();
        } else {
            GameUI.printToScreen(String.format("You leave it lying and walk away.%n"));
            gameUI.waitForKeyPress();
        }
    }

    public boolean isPlayerDead(Player player) {
        return player.getHealth() <= 0;
    }

    private String getUserInput(String[] possibleChoices) {
        String input = "";

        while (!Arrays.asList(possibleChoices).contains(input)) { //Todo: test!
            try {
                input = gameUI.getInput();
                if (!Arrays.asList(possibleChoices).contains(input)) {
                    GameUI.printToScreen(String.format("Wrong input, try again.%n"));
                }
            } catch (InputMismatchException e) {
                GameUI.printToScreen(String.format("Wrong input, try again.%n"));
            } catch (NoSuchElementException e) {
                System.err.printf("Error when reading input, there was no line in buffer to read.", e);
                break;
            }
        }
        return input;
    }
}
