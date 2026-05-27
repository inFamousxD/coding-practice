package strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RateLimitLoader {
    RateLimitPolicy getPolicy(String apiKey);
}
