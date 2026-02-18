package Repository;

import Model.Room;

import java.util.Collection;

public interface RoomRepository {

    void save(Room room);

    Room findByName(String name);

    Collection<Room> findAll();
}
