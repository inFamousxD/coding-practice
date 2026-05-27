package models;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private final String passengerId;
    // deciding whether to remove this link - we can get passenger by booking anyway
//    private List<Booking> bookingList;

    public Passenger(String passengerId) {
        this.passengerId = passengerId;
//        this.bookingList = new ArrayList<Booking>();
    }

    public String getPassengerId() {
        return passengerId;
    }
}
