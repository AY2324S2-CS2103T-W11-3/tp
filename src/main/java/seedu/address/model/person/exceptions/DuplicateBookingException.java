package seedu.address.model.person.exceptions;

/**
 * Signals that the operation will result in duplicate Booking (Booking are considered duplicates if they have the same
 * identity).
 */

public class DuplicateBookingException extends RuntimeException {
    public DuplicateBookingException() {
        super("Operation would result in duplicate bookings");
    }
}