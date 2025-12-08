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
 * Utility klass som genererar en fördefinierad dungeon med fyra rum.
 * <p>
 * Varje rum får:
 * <ul>
 *     <li>ett namn</li>
 *     <li>en miljöbeskrivning</li>
 *     <li>ett monster</li>
 *     <li>ett item</li>
 * </ul>
 * <p>
 * Rummen returneras i en specifik ordning:
 * <ol>
 *     <li>The Entrance</li>
 *     <li>The Stairwell</li>
 *     <li>An Old Cell</li>
 *     <li>The Dark Hallway</li>
 * </ol>
 * Denna klass är tänkt att användas som startpunkt för spelets dungeon layout.
 */

public class DungeonGenerator {
    /**
     * Skapar en dungeon bestående av fyra rum med färdig-konfigurerade monster och items.
     * <p>
     * Varje rum skapas som en Room1 instans och får:
     * <ul>
     *     <li>ett specifikt monster (Slime, Skeleton, Goblin, Troll)</li>
     *     <li>ett specifikt item (Potion eller Beer)</li>
     * </ul>
     *
     * @return en lista av {@link Room}-objekt i korrekt ordning
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



