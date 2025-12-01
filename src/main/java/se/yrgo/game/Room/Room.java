package se.yrgo.game.Room;

import se.yrgo.game.monster.Monster;
import se.yrgo.game.items.Item;


public interface Room {
    String getName();
    String getDescription();

    Room getNextRoom();
    Room getPreviousRoom();

    void setNextRoom(Room nextRoom);

    Monster getMonster();
    void setMonster(Monster monster);
    void removeMonster(Monster monster);

    Item getItem();
    void setItem(Item item);
    void removeItem(Item item);

    @Override
    String toString();
}


