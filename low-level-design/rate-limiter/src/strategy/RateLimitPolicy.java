package strategy;

import java.util.List;

public class RateLimitPolicy {
    String apiKey;
    List<RateLimitRule> rules;

    public RateLimitPolicy(String apiKey, List<RateLimitRule> rules) {
        this.apiKey = apiKey;
        this.rules = rules;
    }

    public List<RateLimitRule> getRules() {
        return rules;
    }
}
