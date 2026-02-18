package Factory;


import Model.Room;

public class RoomFactory {

    public static Room createRoom(String name, int capacity) {
        return new Room(name, capacity);
    }
}
