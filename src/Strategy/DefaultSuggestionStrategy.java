package Strategy;

import Model.Booking;
import Model.Room;
import Model.TimeSlot;

import java.util.*;

public class DefaultSuggestionStrategy implements SuggestionStrategy {

    @Override
    public List<Room> suggest(Collection<Room> rooms,
                              Map<String, List<Booking>> bookings,
                              TimeSlot slot,
                              int minCapacity) {

        List<Room> result = new ArrayList<>();

        for (Room room : rooms) {
            if (room.getCapacity() < minCapacity) continue;

            List<Booking> roomBookings =
                    bookings.getOrDefault(room.getName(), new ArrayList<>());

            boolean available = true;
            for (Booking b : roomBookings) {
                if (b.getTimeSlot().overlaps(slot)) {
                    available = false;
                    break;
                }
            }

            if (available) result.add(room);
        }

        result.sort(Comparator.comparingInt(Room::getCapacity));
        return result;
    }
}

