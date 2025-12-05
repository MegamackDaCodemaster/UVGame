/*package se.yrgo.game.room;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import se.yrgo.game.Room.Room1;
import se.yrgo.game.items.Beer;
import se.yrgo.game.items.Potion;
import se.yrgo.game.items.Item;
import se.yrgo.game.monster.Monster;
import se.yrgo.game.monster.Troll;

public class DungeonGeneratorTest {

    @Test
    void testDungeonRooms() {
        // Generate dungeon
        List<Room1> dungeon = DungeonGenerator.Dungeon();

        // Check total number of rooms
        assertEquals(4, dungeon.size(), "Dungeon should have 4 rooms");

        // Test first room
        Room entrance = dungeon.get(0);
        assertEquals("Entrance", entrance.getName(), "First room name should be Entrance");
        assertNotNull(entrance.getMonster(), "Entrance should have a monster");
        assertTrue(entrance.getMonster() instanceof Troll, "Monster should be a Troll");

        // Test second room
        Room stairwell = dungeon.get(1);
        assertEquals("Stairwell", stairwell.getName(), "Second room name should be Stairwell");
        assertNotNull(stairwell.getItem(), "Stairwell should have an item");
        assertTrue(stairwell.getItem() instanceof Potion, "Item should be a Potion");

        // Test last room
        Room darkHallway = dungeon.get(3);
        assertEquals("Dark Hallway", darkHallway.getName(), "Last room name should be Dark Hallway");
        assertNotNull(darkHallway.getItem(), "Dark Hallway should have an item");
        assertTrue(darkHallway.getItem() instanceof Beer, "Item should be a Beer");
    }
}
*/