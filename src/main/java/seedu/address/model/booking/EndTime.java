package seedu.address.model.booking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Booking's end time in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEndTime(String)}
 */
public class EndTime {

    public static final String MESSAGE_CONSTRAINTS = "End times must be in the format of YYYY-MM-DDTHH:MM (ISO_LOCAL_DATE_TIME).";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public final LocalDateTime endTime;

    /**
     * Constructs a {@code EndTime}.
     *
     * @param endTime A valid end time.
     */
    public EndTime(String endTime) {
        checkArgument(isValidEndTime(endTime), MESSAGE_CONSTRAINTS);
        this.endTime = LocalDateTime.parse(endTime, formatter);
    }

    /**
     * Returns true if a given string is a valid end time.
     */
    public static boolean isValidEndTime(String test) {
        try {
            LocalDateTime.parse(test, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return endTime.format(formatter);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof EndTime)) return false;
        EndTime that = (EndTime) other;
        return endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        return endTime.hashCode();
    }
}