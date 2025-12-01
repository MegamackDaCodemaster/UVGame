package se.yrgo.game.Room;

import se.yrgo.game.monster.Monster;
import se.yrgo.game.items.Item;

public class RoomGenerator implements Room {
    private String name;
    private String description;

    private Room nextRoom;
    private Room previousRoom;

    private Monster monster;
    private Item item;

    public RoomGenerator(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public Room getNextRoom() {
        return nextRoom;
    }
    @Override
    public Room getPreviousRoom() {
        return previousRoom;
    }

}
