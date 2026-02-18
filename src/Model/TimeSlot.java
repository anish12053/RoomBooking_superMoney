package Model;

import java.time.LocalTime;
import java.util.Objects;

public class TimeSlot implements Comparable<TimeSlot> {

    private final LocalTime start;
    private final LocalTime end;

    public TimeSlot(String start, String end) {
        this.start = LocalTime.parse(start);
        this.end = LocalTime.parse(end);

        if (!this.start.isBefore(this.end)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
    }

    public boolean overlaps(TimeSlot other) {
        return !(this.end.compareTo(other.start) <= 0 ||
                this.start.compareTo(other.end) >= 0);
    }

    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }

    @Override
    public int compareTo(TimeSlot o) {
        return this.start.compareTo(o.start);
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TimeSlot)) return false;
        TimeSlot other = (TimeSlot) obj;
        return start.equals(other.start) && end.equals(other.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

}
