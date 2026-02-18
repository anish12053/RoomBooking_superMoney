package Service;

import Factory.RoomFactory;
import Model.Room;
import Repository.RoomRepository;

import java.util.Collection;

public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void addRoom(String building, String name, int capacity) {
        Room room = RoomFactory.createRoom(name, capacity);
        roomRepository.save(room);
        System.out.println("Room '" + name + "' added to " + building + ".");
    }

    public Room getRoom(String name) {
        return roomRepository.findByName(name);
    }

    public Collection<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
