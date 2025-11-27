package se.yrgo.game.Room;

import se.yrgo.game.monster.Monster;
import se.yrgo.game.items.Item;
import java.util.List;

public interface Room {
    String getName();
    String getDescription();

    Room getNextRoom();
    Room getPreviousRoom();

    void setNextRoom(Room nextRoom);

    List<Monster> getMonsters();
    void addMonster(Monster monster);
    void removeMonster(Monster monster);

    List<Item> getItems();
    void addItem(Item item);
    void removeItem(Item item);

    @Override
    String toString();
}
