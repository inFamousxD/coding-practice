package services;

import models.*;

import java.util.Optional;
import java.util.UUID;

public class BookingService {
    private final SeatHoldService seatHoldService;

    public BookingService() {
        this.seatHoldService = SeatHoldService.getInstance();
    }

    public Booking reserveFlight(Flight flight, Seat seat, Passenger passenger) {
        // initiate seat hold
        boolean heldSeat = seatHoldService.holdSeat(seat, passenger);
        if (!heldSeat) {
            return null;
        }
        // after hold, create payment -> PENDING
        return new Booking(flight, passenger, seat);
    }

    public void cancelBooking(Booking booking, PaymentService paymentService) {
        if (booking.getStatus() == BookingStatus.SUCCESSFUL || booking.getStatus() == BookingStatus.PENDING) {
            this.seatHoldService.releaseSeat(booking.getSeat());
            if (booking.getStatus() == BookingStatus.SUCCESSFUL) paymentService.refund(booking, booking.getPayment().getMethod());
            booking.updateStatus(BookingStatus.CANCELLED);
        }
    }
}
