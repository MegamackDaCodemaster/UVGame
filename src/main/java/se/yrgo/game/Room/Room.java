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

    Monster getMonster();
    void addMonster(Monster monster);
    void removeMonster(Monster monster);

    Item getItem();
    void addItem(Item item);
    void removeItem(Item item);

    @Override
    String toString();
}
