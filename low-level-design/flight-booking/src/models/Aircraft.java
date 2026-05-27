package models;

import java.util.List;

public class Aircraft {
    private final String aircraftId;
    private final List<Seat> seats;

    public Aircraft(String aircraftId, List<Seat> seats) {
        this.aircraftId = aircraftId;
        this.seats = seats;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
