package Repository;

import Model.Booking;
import Model.TimeSlot;

import java.util.*;

public class InMemoryBookingRepository implements BookingRepository {

    private final Map<String, List<Booking>> bookingStore = new HashMap<>();

    @Override
    public void save(String roomName, Booking booking) {
        bookingStore.putIfAbsent(roomName, new ArrayList<>());
        bookingStore.get(roomName).add(booking);
        bookingStore.get(roomName)
                .sort(Comparator.comparing(Booking::getTimeSlot));
    }

    @Override
    public List<Booking> findByRoom(String roomName) {
        return bookingStore.getOrDefault(roomName, new ArrayList<>());
    }

    @Override
    public boolean delete(String roomName, TimeSlot slot) {
        List<Booking> bookings = bookingStore.get(roomName);
        if (bookings == null) return false;
        return bookings.removeIf(b -> b.getTimeSlot().equals(slot));
    }
}
