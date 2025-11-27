package se.yrgo.game.gameplay;

import se.yrgo.game.Room.Room;
import se.yrgo.game.items.Item;
import se.yrgo.game.monster.Monster;
import se.yrgo.game.player.Player;
import se.yrgo.game.ui.GameUI;

import java.util.Arrays;
import java.util.InputMismatchException;
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
        GameUI.printToScreen(String.format("You step into %s%n", room.getName().toLowerCase()));
        GameUI.printToScreen(String.format("Where you encounter %s! Get ready for battle!!%n",
                room.getMonster().getPresentation().toUpperCase()));
        GameUI.pauseTextFlow(2000);

        doBattle(player, room.getMonster());

        if (isPlayerDead(player)) {
            return false;
        }

        GameUI.pauseTextFlow(2000);
        GameUI.printToScreen(String.format("************************%n"));

        if (room.getItem() != null) {
            findItem(player, room.getItem());
        }

        if (isPlayerDead(player)) {
            return false;
        }

        GameUI.printToScreen("You exit the room.");
        return true;
    }

    private void doBattle(Player player, Monster monster) {
        GameUI.printToScreen(String.format("""
                - BATTLE WITH %s - 
                """, monster.getMonsterType().toUpperCase()));

        while (!isPlayerDead(player) && monster.getHealth() > 0) {
            GameUI.printToScreen(String.format("""
                            %s: %d HP left
                            %s: %d HP left
                            """,
                    player.getName(), player.getHealth(),
                    monster.getMonsterType(), monster.getHealth()));

            GameUI.pauseTextFlow(1500);
            GameUI.printToScreen(String.format("%s charges the %s!", player.getName(), monster.getMonsterType()));

            int damage = player.getAttackDamage();
            monster.wound(damage);

            GameUI.printToScreen(String.format("You inflicted %d points of damage to the %s!%n",
                    damage, monster.getMonsterType()));
            GameUI.pauseTextFlow(1500);

            if (monster.getHealth() <= 0) {
                GameUI.printToScreen(String.format("You killed the %s!%n", monster.getMonsterType()));
                break;
            }

            GameUI.printToScreen(String.format("It's still alive and kicking "));
            GameUI.printWaitingIntervalDots();
            GameUI.printToScreen(String.format("you!!%n"));
            GameUI.pauseTextFlow(1000);

            int monsterAttackDamage = monster.getRandomAttack();
            player.decreaseHealth(monsterAttackDamage);
            GameUI.printToScreen(String.format("You take %d points of damage! Ouch!", monsterAttackDamage));
            GameUI.pauseTextFlow(1000);
        }

        if (!isPlayerDead(player)) {
            player.increaseScore(monster.getRewardPoints());
            GameUI.printToScreen(String.format("Congratulations! You won the battle! You earned %d victory points!",
                    monster.getRewardPoints()));
        }
    }

    private void findItem(Player player, Item item) {
        GameUI.printToScreen("What's this? The monster dropped something...");

//        GameUI.printToScreen(String.format("You see %s.%n", item.getName())); //Todo: getName method on item.

        GameUI.printToScreen("What do you want to do?");

        GameUI.printToScreen(String.format("""
                1. Pick it up and use. YOLO!
                2. Leave it. It might be dangerous. 
                """));

        var input = getUserInput(new String[] {"1", "2"});

        if (input.equals("1")) {
            item.pickup(player);
        } else {
            GameUI.printToScreen("You leave it lying and walk away.");
        }
    }

    //todo move to Player?
    public boolean isPlayerDead(Player player) {
        return player.getHealth() <= 0;
    }

    private String getUserInput(String[] possibleChoices) {
        String input = "";

        while (!Arrays.asList(possibleChoices).contains(input)) { //Todo: test!
            try {
                input = gameUI.getInput();
                if (!Arrays.asList(possibleChoices).contains(input)) {
                    GameUI.printToScreen("Wrong input, try again.");
                }
            } catch (InputMismatchException e) {
                GameUI.printToScreen("Wrong input, try again: ");
            }
        }
        return input;
    }
}
