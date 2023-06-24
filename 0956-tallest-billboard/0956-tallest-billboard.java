class Solution {
    Integer dp[][];

    public int tallestBillboard(int[] rods) {
        dp = new Integer[rods.length][100001];
        return getTallestPair(rods, 0, 0);
    }

    private int getTallestPair(int[] rods, int idx, int sum) {
        if (idx >= rods.length) {
            if (sum == 0) {
                return 0;
            }

            return Integer.MIN_VALUE;
        }

        if (dp[idx][sum + 5000] != null) {
            return dp[idx][sum + 5000];
        }

        int skip = getTallestPair(rods, idx + 1, sum);
        int leftBuild = rods[idx] + getTallestPair(rods, idx + 1, sum + rods[idx]);
        int rightBuild = getTallestPair(rods, idx + 1, sum - rods[idx]);

        return dp[idx][sum + 5000] = Math.max(skip, Math.max(leftBuild, rightBuild));
    }
}