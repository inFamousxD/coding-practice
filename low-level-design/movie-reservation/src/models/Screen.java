package models;

import java.util.List;

public class Screen {
    private final List<Seat> seatList;

    public Screen(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }
}
