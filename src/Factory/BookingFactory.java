package Factory;


import Model.Booking;
import Model.TimeSlot;

public class BookingFactory {

    public static Booking create(String roomName, String start,
                                 String end, String person) {
        return new Booking(roomName, new TimeSlot(start, end), person);
    }
}

