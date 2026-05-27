package store;

public interface RateLimitStore {
    int incrementAndGet(String key, long windowSeconds);
}
