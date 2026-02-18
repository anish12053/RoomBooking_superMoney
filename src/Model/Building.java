package Model;

import java.util.*;

public class Building {

    private final String name;
    private final Map<String, Room> rooms = new HashMap<>();

    public Building(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        rooms.put(room.getName(), room);
    }

    public Collection<Room> getRooms() {
        return rooms.values();
    }
}
