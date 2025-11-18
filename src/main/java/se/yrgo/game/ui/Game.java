package se.yrgo.game.ui;

import se.yrgo.game.player.Player;
import se.yrgo.game.Room.Room;
import se.yrgo.game.Room.RoomMain;
import se.yrgo.game.monster.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public Player player;
    public List<Room> rooms;

    public Game() {
        initializeRooms();
    }

    private void initializeRooms() {
        rooms = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            rooms.add(RoomMain.getRoom()); //Todo: Need a method for getting a room object
        }
    }

    public void runGame(Scanner scanner) {
        System.out.println("Choose a player name: ");
        String name = scanner.nextLine();

        player = new Player(name, 100, 0);
        System.out.printf("Welcome %s! You start your journey here...%n", player.getName());
        System.out.println();

        while (!rooms.isEmpty() || player.getHealth() <= 0) {
            int roomCounter = 0;

            encounterRoom(player);

            rooms.remove(rooms.get(roomCounter));
        }

        if (player.getHealth() <= 0) {
            //Game over
        }

        System.out.println("You have cleared the game!!");
        System.out.printf("Final score: %d", player.getScore());
    }

    private void encounterRoom(Player player) {
        //Todo: Print encounter message. Print room content. Print menu for choice of action
        //Todo: Don't forget: end of battle, increase score
    }


    public void doBattle(Player player, Monster monster) {
        int damage = player.getAttackDamage();
        monster.wound(damage);

        System.out.printf("You inflicted %d points of damage to the %s!%n", damage, monster.getName());
        if (monster.getHealth() <= 0) {
            System.out.printf("You killed the %s!%n", monster.getName());
        }

        player.decreaseHealth(monster.getStrength());
        System.out.printf("The %s does %d points of damage to you!", monster.getName(), monster.getStrength());

        if (player.getHealth() <= 0) {
            //Game over
        }
    }


}
