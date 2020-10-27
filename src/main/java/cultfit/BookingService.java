package cultfit;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private static List<List<Booking>> bookings;

    public BookingService() {
        bookings = new ArrayList<List<Booking>>();
    }

    public synchronized static Error book(FitnessProgram program, int userId) {
        if (program == null || userId < 1) {
            return new Error("Wrong Program or userId", true);
        }
        Error err = isValidBooking(program, userId);

        if (!err.isError()) {
            Booking booking = new Booking(
                    program.getType(), program.getId(), userId
            );
            List<Booking> programBookings = getBookings(program);
            programBookings.add(booking);
        }
        return err;
    }

    public static Error cancel(FitnessProgram program, int userId) {
        if (program == null || userId < 1) {
            return new Error("Wrong Program or userId", true);
        }

        List<Booking> programBookings = getBookings(program);
        for (int i = 0; i < programBookings.size(); i++) {
            Booking booking = programBookings.get(i);
            if (booking.getUserId() == userId) {
                if (booking.getStatus() != BookingStatus.CANCELLED) { // can cancel both waiting and completed bookings
                    booking.setStatus(BookingStatus.CANCELLED);
                    moveFromWaitingToCompleted(programBookings);
                    return new Error("Cancelled booking for "+program.getType() + " class for user id="+userId, false);
                } else {
                    return new Error("Booking is already cancelled for "+program.getType() + " class for user id="+userId, true);
                }
            }
        }
        return new Error("No Booking found for "+program.getType() + " class for user id="+userId, true);
    }

    private static void moveFromWaitingToCompleted(List<Booking> programBookings) {
        for (int i = 0; i < programBookings.size(); i++) {
            Booking booking = programBookings.get(i);
            if (booking.getStatus() == BookingStatus.WAITING) {
                booking.setStatus(BookingStatus.COMPLETED);
                System.out.println("Booking status changed to completed for user = "+booking.userId + ". Send Notification!");
                break;
            }
        }
        System.out.println("No booking found in WAITING list");
    }

    private static Error isValidBooking(FitnessProgram program, int userId) {
        List<Booking> programBookings = getBookings(program);
        int bookingSize = getBookingSize(programBookings);
        // check for size
        if (bookingSize >= program.getSize()) {
            Booking booking = new Booking(
                    program.getType(), BookingStatus.WAITING, program.getId(), userId
            );
            programBookings = getBookings(program);
            programBookings.add(booking);
            return new Error(program.getType() + " class is Full. Added to waiting list.", true);
        }
        // check for duplicate booking from same user
        for (int i = 0; i < programBookings.size(); i++) {
            if (programBookings.get(i).getUserId() == userId) {
                return new Error("Already made a booking previously for "+program.getType() + " class for user id="+userId, true);
            }
        }
        return new Error("Successfully booked "+program.getType() + " class for user id="+userId, false);
    }

    private static int getBookingSize(List<Booking> programBookings) {
        int count = 0;
        for (int i = 0; i < programBookings.size(); i++) {
            Booking booking = programBookings.get(i);
            if (booking.getStatus().equals(BookingStatus.COMPLETED)) {
                count++;
            }
        }
        return count;
    }

    public void addProgram() {
        bookings.add(new ArrayList<Booking>());
    }

    private static List<Booking> getBookings(FitnessProgram program) {
        return bookings.get(program.getId() - 1);
    }

}
