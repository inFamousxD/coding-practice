package models;

public class Reservation {
    private final String reservationId;
    private final Show show;
    private final String personId;
    private final Seat seat;

    private ReservationStatus reservationStatus;

    public Reservation(String reservationId, Show show, Seat seat, String personId) {
        this.reservationId = reservationId;
        this.show = show;
        this.personId = personId;
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }
}
