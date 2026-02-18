package Strategy;

import Model.Booking;
import Model.Room;
import Model.TimeSlot;

import java.util.*;

public interface SuggestionStrategy {

    List<Room> suggest(Collection<Room> rooms,
                       Map<String, List<Booking>> bookings,
                       TimeSlot slot,
                       int minCapacity);
}
