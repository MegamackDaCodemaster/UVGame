package se.yrgo.game.Room;

import se.yrgo.game.monster.Monster;
import se.yrgo.game.items.Item;

//Utility class

public class RoomGenerator {

    private static final String[] NAMES = {
            "Entrance",
            "Stairwell",
            "Old Cell",
            "Flooded Tunnel",
            "Dark Hallway",
            "Sacrifice Chamber",
            "Deep Cavern"
    };

    private static final String[] DESCRIPTIONS = {
            "Cold air creeps from the darkness.",
            "You descend steep stone steps.",
            "Rusty bars line the walls.",
            "Water drips from the ceiling.",
            "Only faint echoes can be heard.",
            "You smell dried blood.",
            "You feel a presence watching you."
    };

    private static final String[] MONSTER_NAMES = {
            "Troll", "EX1", "EX2", "EX3", "EX4", "EX5", "EX6", "EX7",
    };
    private static final String[] ITEM_NAMES = {
            "potion", "example1", "example2", "example3",
            "example4", "example5", "example6", "example7",
    };

    public static Room generateDungeon(int numberOfRooms) {
        Room start = createRoom(0);
        Room current = start;

        for (int i = 1; i < numberOfRooms; i++) {
            Room next = createRoom(i);
            current.setNextRoom(next);
            current = next;
        }

        return start; // return the top room
    }

    private static Room createRoom(int index) {
        String name = NAMES[index % NAMES.length];
        String desc = DESCRIPTIONS[index % DESCRIPTIONS.length];
        return new Room1(name, desc);
    }
}
