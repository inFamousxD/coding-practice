package strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRateLimitLoader implements RateLimitLoader {
    // api key : policy for that api key
    private final Map<String, RateLimitPolicy> policies = new HashMap<>();

    private void fetchPolicies() {
        // mock create policies
        policies.put("123", new RateLimitPolicy("123", List.of(
                new RateLimitRule(60, 100),
                new RateLimitRule(3600, 4000)
        )));
    }

    public InMemoryRateLimitLoader() {
        this.fetchPolicies();
    }

    @Override
    public RateLimitPolicy getPolicy(String apiKey) {
        return policies.get(apiKey);
    }
}
