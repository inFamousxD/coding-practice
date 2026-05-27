package models;

import java.util.List;

public class Theatre {
    private final List<Screen> seatList;

    public Theatre(List<Screen> seatList) {
        this.seatList = seatList;
    }

    public List<Screen> getSeatList() {
        return seatList;
    }
}
