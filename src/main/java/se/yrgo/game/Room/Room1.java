package se.yrgo.game.Room;

import se.yrgo.game.monster.Monster;
import se.yrgo.game.items.Item;
import java.util.ArrayList;
import java.util.List;

public class Room1 implements Room {

    private String name;
    private String description;

    private Room nextRoom;
    private Room previousRoom;

    private List<Monster> monsters = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public Room1(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public Room getNextRoom() { return nextRoom; }

    @Override
    public Room getPreviousRoom() { return previousRoom; }

    @Override
    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
        if (nextRoom instanceof Room1) {
            ((Room1) nextRoom).previousRoom = this;
        }
    }

    // ---- Monster handling ----
    @Override
    public List<Monster> getMonster() {
        return monsters;
    }

    @Override
    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    @Override
    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }

    // ---- Item handling ----
    @Override
    public List<Item> getItem() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
