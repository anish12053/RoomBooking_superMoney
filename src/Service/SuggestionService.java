package Service;
import Model.Booking;
import Model.Room;
import Model.TimeSlot;
import Repository.BookingRepository;
import Repository.RoomRepository;
import Strategy.DefaultSuggestionStrategy;
import Strategy.SuggestionStrategy;

import java.util.*;

public class SuggestionService {

    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final SuggestionStrategy strategy;

    public SuggestionService(RoomRepository roomRepo,
                             BookingRepository bookingRepo) {
        this.roomRepository = roomRepo;
        this.bookingRepository = bookingRepo;
        this.strategy = new DefaultSuggestionStrategy();
    }

    public void suggest(String start, String end, int minCapacity) {

        TimeSlot slot = new TimeSlot(start, end);

        Map<String, List<Booking>> bookingMap = new HashMap<>();
        for (Room room : roomRepository.findAll()) {
            bookingMap.put(room.getName(),
                    bookingRepository.findByRoom(room.getName()));
        }

        List<Room> rooms =
                strategy.suggest(roomRepository.findAll(),
                        bookingMap, slot, minCapacity);

        System.out.println("Suggestions for " + slot +
                " (Min Capacity: " + minCapacity + "):");

        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room r : rooms) {
                System.out.println("- " + r.getName() +
                        " (Capacity: " + r.getCapacity() + ")");
            }
        }
    }
}

