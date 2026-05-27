package models;

public class Seat {
    private final String seatId;
    private final SeatType seatType;
    private final Double cost;

    public Seat(String seatId, SeatType seatType, Double cost) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.cost = cost;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public Double getCost() {
        return cost;
    }
}
