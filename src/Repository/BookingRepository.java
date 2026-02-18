package Repository;
import Model.Booking;
import Model.TimeSlot;

import java.util.List;

public interface BookingRepository {

    void save(String roomName, Booking booking);

    List<Booking> findByRoom(String roomName);

    boolean delete(String roomName, TimeSlot slot);
}

