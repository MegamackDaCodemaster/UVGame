package se.yrgo.game.Room;

import se.yrgo.game.items.Beer;
import se.yrgo.game.items.Potion;
import se.yrgo.game.monster.Goblin;
import se.yrgo.game.monster.Skeleton;
import se.yrgo.game.monster.Slime;
import se.yrgo.game.monster.Troll;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class that generates a predefined dungeon with four rooms.
 * <p>
 * Each room receives:
 * <ul>
 *     <li>a name</li>
 *     <li>a description of the environment</li>
 *     <li>a monster</li>
 *     <li>an item</li>
 * </ul>
 * <p>
 * The rooms are returned in a specific order:
 * <ol>
 *     <li>The Entrance</li>
 *     <li>The Stairwell</li>
 *     <li>An Old Cell</li>
 *     <li>The Dark Hallway</li>
 * </ol>
 * This class is intended to be used as the starting point for the game's dungeon layout.
 */

public class DungeonGenerator {
    /**
     * Creates a dungeon consisting of four rooms with preconfigured monsters and items.
     * <p>
     * Each room is created as a Room1 instance and receives:
     * <ul>
     *     <li>a specific monster (Slime, Skeleton, Goblin, Troll)</li>
     *     <li>a specific item (Potion or Beer)</li>
     * </ul>
     *
     * @return a list of Room objects in the correct order
     */
    public static List<Room> Dungeon() {

        List<Room> rooms = new ArrayList<>();

        Room entrance = new Room1("The Entrance", "Cold air creeps from the darkness.");
        Room stairwell = new Room1("The Stairwell", "You descend steep stone steps.");
        Room oldCell = new Room1("An Old Cell", "Rusty bars line the walls.");
        Room darkHallway = new Room1("The Dark Hallway", "Faint echoes can be heard. you see red glowing eyes staring at you!");

        // add monsters/items
        entrance.setMonster(new Slime());
        stairwell.setMonster(new Skeleton());
        oldCell.setMonster(new Goblin());
        darkHallway.setMonster(new Troll());

        entrance.setItem(new Potion("Elixir of Emberlight", 30));
        stairwell.setItem(new Beer("Haze Ale", 10));
        oldCell.setItem(new Potion("Elixir of Emberlight", 30));
        darkHallway.setItem(new Beer("Haze Ale", 15));


        //Order rooms
        rooms.add(entrance);
        rooms.add(stairwell);
        rooms.add(oldCell);
        rooms.add(darkHallway);

        return rooms;
    }
}



