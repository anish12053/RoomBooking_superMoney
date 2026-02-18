package Service;

import Factory.BookingFactory;
import Model.Booking;
import Model.Room;
import Model.TimeSlot;
import Repository.BookingRepository;
import Repository.RoomRepository;

import java.util.List;

public class BookingService {

    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public BookingService(RoomRepository roomRepo,
                          BookingRepository bookingRepo) {
        this.roomRepository = roomRepo;
        this.bookingRepository = bookingRepo;
    }

    public void book(String roomName, String start,
                     String end, String person) {

        Room room = roomRepository.findByName(roomName);
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        TimeSlot slot = new TimeSlot(start, end);

        for (Booking b : bookingRepository.findByRoom(roomName)) {
            if (b.getTimeSlot().overlaps(slot)) {
                System.out.println("Booking Failed: " +
                        roomName + " is already booked during " +
                        b.getTimeSlot());
                return;
            }
        }

        Booking booking =
                BookingFactory.create(roomName, start, end, person);

        bookingRepository.save(roomName, booking);
        System.out.println("Booking Created: " + booking);
    }

    public void cancel(String roomName, String start, String end) {

        boolean removed =
                bookingRepository.delete(roomName,
                        new TimeSlot(start, end));

        if (removed)
            System.out.println("Booking Cancelled: " +
                    roomName + " (" + start + " - " + end + ")");
        else
            System.out.println("No such booking found.");
    }

    public void list(String roomName) {
        List<Booking> bookings =
                bookingRepository.findByRoom(roomName);

        System.out.println("Bookings for " + roomName + ":");

        if (bookings.isEmpty()) {
            System.out.println("(No bookings found)");
        } else {
            bookings.forEach(System.out::println);
        }
    }
}
