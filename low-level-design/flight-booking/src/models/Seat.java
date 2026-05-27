package models;

public class Seat {
    private final String seatId;
    private final SeatType seatType;
    private SeatStatus seatStatus;
    private final Double cost;

    public Seat(String seatId, SeatType seatType, Double cost) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.cost = cost;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus status) {
        this.seatStatus = status;
    }

    public Double getCost() {
        return cost;
    }
}
