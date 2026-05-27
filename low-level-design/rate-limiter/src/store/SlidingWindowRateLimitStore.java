package store;

public interface SlidingWindowRateLimitStore extends RateLimitStore {
    int getCount(String key);
}
