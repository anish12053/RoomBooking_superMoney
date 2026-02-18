package Manager;

import Repository.BookingRepository;
import Repository.InMemoryBookingRepository;
import Repository.InMemoryRoomRepository;
import Repository.RoomRepository;
import Service.BookingService;
import Service.RoomService;
import Service.SuggestionService;

public class MeetingRoomManager {

    private static final MeetingRoomManager INSTANCE =
            new MeetingRoomManager();

    private final RoomRepository roomRepository =
            new InMemoryRoomRepository();

    private final BookingRepository bookingRepository =
            new InMemoryBookingRepository();

    private final RoomService roomService =
            new RoomService(roomRepository);

    private final BookingService bookingService =
            new BookingService(roomRepository, bookingRepository);

    private final SuggestionService suggestionService =
            new SuggestionService(roomRepository, bookingRepository);

    private MeetingRoomManager() {}

    public static MeetingRoomManager getInstance() {
        return INSTANCE;
    }

    public RoomService getRoomService() { return roomService; }
    public BookingService getBookingService() { return bookingService; }
    public SuggestionService getSuggestionService() { return suggestionService; }
}

