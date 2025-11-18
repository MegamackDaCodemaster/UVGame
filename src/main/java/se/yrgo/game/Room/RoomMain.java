package se.yrgo.game.Room;

public class RoomMain {
    public static void main(String[] args) {
        Room floor1 = new Room("Floor 1", "The dusty entrance level.");
        Room floor2 = new Room("Floor 2", "A dim room with old paintings.");
        Room floor3 = new Room("Floor 3", "top of the tower - Last Boss Room .");

        floor1.setNextRoom(floor2);
        floor2.setNextRoom(floor3);

        Room current = floor1;

        while (current != null) {
            System.out.println(current);
            current = current.getNextRoom();
        }
    }
}
