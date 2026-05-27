package models;

public class Booking {
    private final Flight flight;
    private final Passenger passenger;
    private BookingStatus bookingStatus;
    private final Seat seat;
    private Payment payment;

    public Booking(Flight f, Passenger p, Seat seat) {
        this.flight = f;
        this.passenger = p;
        this.bookingStatus = BookingStatus.PENDING;
        this.seat = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public BookingStatus getStatus() {
        return bookingStatus;
    }

    public void updateStatus(BookingStatus status) {
        this.bookingStatus = status;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}
