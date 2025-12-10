package se.yrgo.game.Room;

import se.yrgo.game.monster.Monster;
import se.yrgo.game.items.Item;

/**
 * En implementation av interfacet Room.
 * Room1 representerar ett rum som kan kopplas till nästa rum,
 * samt innehålla ett Monster och/eller ett Item.
 */

public class Room1 implements Room {

    private String name;
    private String description;

    private Room nextRoom;
    private Room previousRoom;

    // ---MONSTER & ITEM---
    private Monster monster;
    private Item item;

    public Room1(String name, String description) {
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

    @Override
    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
        if (nextRoom instanceof Room1) {
            ((Room1) nextRoom).previousRoom = this;
        }
    }

    // ---- Monster ----
    @Override
    public Monster getMonster() {
        return monster;
    }

    public void addMonster(Monster monster) {

    }

    @Override
    public void removeMonster(Monster monster) {

    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    // ---- Item ----
    @Override
    public Item getItem() {
        return item;
    }

    public void addItem(Item item) {

    }

    @Override
    public void removeItem(Item item) {

    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
