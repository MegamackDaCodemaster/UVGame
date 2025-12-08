package se.yrgo.game.room;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import se.yrgo.game.Room.Room;
import se.yrgo.game.Room.DungeonGenerator;

import se.yrgo.game.items.Beer;
import se.yrgo.game.items.Potion;

import se.yrgo.game.monster.Slime;
import se.yrgo.game.monster.Troll;
import se.yrgo.game.monster.Goblin;
import se.yrgo.game.monster.Skeleton;

/**
 * Enhetstester för DungeonGenerator.
 * <p>
 * Testerna verifierar att metoden skapar
 * en korrekt uppsättning rum med:
 * <ul>
 *     <li>rätt antal rum</li>
 *     <li>korrekta namn</li>
 *     <li>korrekta monster i varje rum</li>
 *     <li>korrekta items i varje rum</li>
 *     <li>korrekt ordning i listan</li>
 * </ul>
 */

public class DungeonGeneratorTest {

    @Test
void testDungeonRooms() {
        List<Room> dungeon = DungeonGenerator.Dungeon();

        assertEquals(4, dungeon.size());

        Room entrance = dungeon.get(0);
        assertEquals("The Entrance", entrance.getName());
        assertTrue(entrance.getMonster() instanceof Slime);
        assertTrue(entrance.getItem() instanceof Potion);

        Room stairwell = dungeon.get(1);
        assertEquals("The Stairwell", stairwell.getName());
        assertTrue(stairwell.getMonster() instanceof Skeleton);
        assertTrue(stairwell.getItem() instanceof Beer);

        Room oldCell = dungeon.get(2);
        assertEquals("An Old Cell", oldCell.getName());
        assertTrue(oldCell.getMonster() instanceof Goblin);
        assertTrue(oldCell.getItem() instanceof Potion);

        Room darkHallway = dungeon.get(3);
        assertEquals("The Dark Hallway", darkHallway.getName());
        assertTrue(darkHallway.getMonster() instanceof Troll);
        assertTrue(darkHallway.getItem() instanceof Beer);
    }}

