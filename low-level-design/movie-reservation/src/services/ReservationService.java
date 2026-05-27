package services;

import models.Reservation;
import models.Seat;
import models.Show;

import java.util.UUID;

public class ReservationService {
    private final SeatHoldService seatHoldService = SeatHoldService.getSeatHoldServiceInstance();

    public Reservation reserveSeat(Show show, Seat seat, String personId) {
        boolean didHold = seatHoldService.holdSeat(seat, personId);
        if (!didHold) return null;

        return new Reservation(UUID.randomUUID().toString(), show, seat, personId);
    }
}
