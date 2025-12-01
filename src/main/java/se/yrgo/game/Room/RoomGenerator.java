package se.yrgo.game.Room;

import se.yrgo.game.monster.Monster;
import se.yrgo.game.items.Item;

//Utility class

public class RoomGenerator {
    public static Room Dungeon;{

        // Create rooms individually
        Room entrance = new Room1("Entrance", "Cold air creeps from the darkness.");
        Room stairwell = new Room1("Stairwell", "You descend steep stone steps.");
        Room oldCell = new Room1("Old Cell", "Rusty bars line the walls.");
        Room darkHallway = new Room1("Dark Hallway", "Only faint echoes can be heard.");

        // Optionally add monsters/items
        entrance.setMonster(new Monster("Troll"));


        // Linked rooms
        entrance.setNextRoom(stairwell);
        stairwell.setNextRoom(oldCell);
        oldCell.setNextRoom(darkHallway);

    }

    public static void main(String[] args) {
        Room currentRoom = roomGenerator();

        // Traverse the dungeon
        while (currentRoom != null) {
            System.out.println(currentRoom);
            currentRoom = currentRoom.getNextRoom();
        }
    }

    private static Room roomGenerator() {
    }
}



