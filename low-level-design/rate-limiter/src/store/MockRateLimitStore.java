package store;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MockRateLimitStore implements RateLimitStore {
    private final ConcurrentHashMap<String, AtomicInteger> store = new ConcurrentHashMap<>();

    @Override
    public int incrementAndGet(String key, long windowSeconds) {
        store.putIfAbsent(key, new AtomicInteger(0));
        return store.get(key).incrementAndGet();
    }
}
