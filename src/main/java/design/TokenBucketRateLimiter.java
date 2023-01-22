package design;

public class TokenBucketRateLimiter {

    private int maxBucketSize;
    private int refillRate; // in seconds

    private double currentBucketSize;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(int maxBucketSize, int refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
    }

    boolean allowRequest(int tokens) {
        refill();
        if ( currentBucketSize > tokens) {
            currentBucketSize -= tokens;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double elapsedSeconds = (now - lastRefillTimestamp) / 1e9;
        double tokensToAdd = elapsedSeconds * refillRate;
        currentBucketSize = Math.min(tokensToAdd, maxBucketSize);
        lastRefillTimestamp = now;
    }
}
