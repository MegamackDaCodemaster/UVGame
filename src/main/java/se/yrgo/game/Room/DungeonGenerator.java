package se.yrgo.game.Room;

import se.yrgo.game.items.Beer;
import se.yrgo.game.items.Potion;
import se.yrgo.game.monster.Goblin;
import se.yrgo.game.monster.Skeleton;
import se.yrgo.game.monster.Slime;
import se.yrgo.game.monster.Troll;

import java.util.ArrayList;
import java.util.List;

//Utility class

public class DungeonGenerator {
    public static List<Room> Dungeon() {

        List<Room> rooms = new ArrayList<>();

        Room entrance = new Room1("Entrance", "Cold air creeps from the darkness.");
        Room stairwell = new Room1("Stairwell", "You descend steep stone steps.");
        Room oldCell = new Room1("Old Cell", "Rusty bars line the walls.");
        Room darkHallway = new Room1("Dark Hallway", "Only faint echoes can be heard.");

        // add monsters/items
        entrance.setMonster(new Slime());
        stairwell.setMonster(new Skeleton());
        oldCell.setMonster(new Goblin());
        darkHallway.setMonster(new Troll());

        entrance.setItem(new Potion("Elixir of Emberlight", 35));
        stairwell.setItem(new Potion("Elixir of Emberlight", 35));
        oldCell.setItem(new Potion("Haze Ale", 10));
        darkHallway.setItem(new Beer("wine", 10));
        darkHallway.setItem(new Potion("Elixer of Emberlight", 35));


        //Order rooms
        rooms.add(entrance);
        rooms.add(stairwell);
        rooms.add(oldCell);
        rooms.add(darkHallway);

        return rooms;
    }
}



