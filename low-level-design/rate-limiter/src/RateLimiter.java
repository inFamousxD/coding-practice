import store.RateLimitStore;
import strategy.RateLimitLoader;
import strategy.RateLimitPolicy;
import strategy.RateLimitRule;

public class RateLimiter {
    public static volatile RateLimiter instance;

    private final RateLimitLoader policyLoader;
    private final RateLimitStore store;

    private RateLimiter(RateLimitLoader loader, RateLimitStore store) {
        this.policyLoader = loader;
        this.store = store;
    }

    private long getCurrentWindowStart(long windowSeconds) {
        long now = System.currentTimeMillis() / 1000;
        return (now / windowSeconds) * windowSeconds;
    }

    public static RateLimiter getInstance(RateLimitLoader loader, RateLimitStore store) {
        if (instance == null) {
            synchronized (RateLimiter.class) {
                if (instance == null) instance = new RateLimiter(loader, store);
            }
        }

        return instance;
    }

    public boolean allowRequest(String apiKey) {
        // load policy for api key
        RateLimitPolicy policies = policyLoader.getPolicy(apiKey);
        // for each rule, build db key, call incr
        for (RateLimitRule rule: policies.getRules()) {
            long window = rule.getWindowWidthInSeconds();
            int requests = rule.getAllowedRequestCount();

            String key = "key:" + apiKey + ":" + window + ":" + getCurrentWindowStart(window);
            int requestsLogged = store.incrementAndGet(key, window);

            if (requestsLogged > requests) return false;
        }
        // decide
        return true;
    }
}
