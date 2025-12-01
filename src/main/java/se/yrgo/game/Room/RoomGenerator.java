package se.yrgo.game.Room;

import se.yrgo.game.items.Beer;
import se.yrgo.game.items.Potion;
import se.yrgo.game.monster.Monster;
import se.yrgo.game.items.Item;
import se.yrgo.game.monster.Troll;

//Utility class

public class RoomGenerator {
    public static Room Dungeon() {

        Room entrance = new Room1("Entrance", "Cold air creeps from the darkness.");
        Room stairwell = new Room1("Stairwell", "You descend steep stone steps.");
        Room oldCell = new Room1("Old Cell", "Rusty bars line the walls.");
        Room darkHallway = new Room1("Dark Hallway", "Only faint echoes can be heard.");

        // add monsters/items
        entrance.setMonster(new Troll());

        stairwell.setItem(new Potion("Elixir of Emberlight", 35));
        darkHallway.setItem(new Beer("Haze Ale", 10));


        // Linked rooms
        entrance.setNextRoom(stairwell);
        stairwell.setNextRoom(oldCell);
        oldCell.setNextRoom(darkHallway);

        return entrance;
    }

}



