package strategy;

public class RateLimitRule {
    long windowWidthInSeconds;
    int allowedRequestCount;

    public RateLimitRule(int windowWidthInSeconds, int allowedRequestCount) {
        this.allowedRequestCount = allowedRequestCount;
        this.windowWidthInSeconds = windowWidthInSeconds;
    }

    public int getAllowedRequestCount() {
        return allowedRequestCount;
    }

    public long getWindowWidthInSeconds() {
        return windowWidthInSeconds;
    }
}
