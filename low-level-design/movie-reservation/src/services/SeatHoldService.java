package services;

import models.Seat;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class SeatHold {
    public final Seat seat;
    public final String personId;
    public final LocalDateTime holdExpiry;

    SeatHold(Seat seat, String personId) {
        this.seat = seat;
        this.personId = personId;
        this.holdExpiry = LocalDateTime.now();
    }

    public LocalDateTime getHoldExpiry() {
        return holdExpiry;
    }
}

public class SeatHoldService {
    public static volatile SeatHoldService instance;

    private final Map<String, SeatHold> seatHoldMap = new ConcurrentHashMap<>();
    private final Map<String, ReentrantLock> seatLock = new ConcurrentHashMap<>();

    private SeatHoldService() {}

    public static SeatHoldService getSeatHoldServiceInstance() {
        if (instance == null) {
            synchronized (SeatHoldService.class) {
                if (instance == null) {
                    instance = new SeatHoldService();
                }
            }
        }

        return instance;
    }

    boolean holdSeat(Seat seat, String personId) {
        ReentrantLock lock = seatLock.computeIfAbsent(seat.getSeatId(), id -> new ReentrantLock());
        try {
            lock.lock();
            SeatHold seatHold = seatHoldMap.get(seat.getSeatId());
            if (seatHold == null || seatHold.getHoldExpiry().isBefore(LocalDateTime.now())) {
                seatHold = new SeatHold(seat, personId);
                seatHoldMap.put(seat.getSeatId(), seatHold);
                return true;
            }
        } finally {
            lock.unlock();
        }
        return false;
    }

    void releaseSeat(Seat seat) {
        seatHoldMap.remove(seat.getSeatId());
    }
}
