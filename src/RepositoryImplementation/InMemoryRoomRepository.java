package RepositoryImplementation;
import Model.Room;
import Repository.RoomRepository;

import java.util.*;

public class InMemoryRoomRepository implements RoomRepository {

    private final Map<String, Room> roomStore = new HashMap<>();

    @Override
    public void save(Room room) {
        roomStore.put(room.getName(), room);
    }

    @Override
    public Room findByName(String name) {
        return roomStore.get(name);
    }

    @Override
    public Collection<Room> findAll() {
        return roomStore.values();
    }
}

