package Model;

public class Booking {

    private final String roomName;
    private final TimeSlot timeSlot;
    private final String bookedBy;

    public Booking(String roomName, TimeSlot timeSlot, String bookedBy) {
        this.roomName = roomName;
        this.timeSlot = timeSlot;
        this.bookedBy = bookedBy;
    }

    public String getRoomName() { return roomName; }
    public TimeSlot getTimeSlot() { return timeSlot; }

    @Override
    public String toString() {
        return roomName + " (" + timeSlot + ") for " + bookedBy;
    }
}

