package store;

public class RedisRateLimitStore implements RateLimitStore {
    @Override
    public int incrementAndGet(String apiKey, long windowSeconds) {
        return 0;
    }
}
