package store;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MockSlidingWindowCounter implements SlidingWindowRateLimitStore {
    private final ConcurrentHashMap<String, AtomicInteger> store = new ConcurrentHashMap<>();

    @Override
    public int getCount(String key) {
        AtomicInteger count = store.get(key);
        return count == null ? 0 : count.get();
    }

    @Override
    public int incrementAndGet(String key, long windowSeconds) {
        store.putIfAbsent(key, new AtomicInteger(0));
        return store.get(key).incrementAndGet();
    }
}
