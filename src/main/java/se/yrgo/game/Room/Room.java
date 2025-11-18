package se.yrgo.game.Room;

public class Room {
    private String name;
    private String description;
    private Room nextRoom;     // the room above / after this one
    private Room previousRoom; // optional: the room below / before this one

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
        if (nextRoom != null) {
            nextRoom.previousRoom = this;
        }
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}

