class Solution {
     public int numWays(int steps, int arrLen) {
        int MOD = (int)1e9+7;
        arrLen = Math.min(arrLen, steps);
        int[][] dp = new int[steps + 1][arrLen];

        dp[0][0] = 1;

        for (int step = 1; step <= steps; step++) {
            for (int pos = 0; pos < arrLen; pos++) {
                dp[step][pos] = dp[step - 1][pos];

                if (pos - 1 >= 0) {
                    dp[step][pos] = (dp[step][pos] + dp[step - 1][pos - 1]) % MOD;
                }
                if (pos + 1 < arrLen) {
                    dp[step][pos] = (dp[step][pos] + dp[step - 1][pos + 1]) % MOD;
                }
            }
        }
        return dp[steps][0];
    }
}