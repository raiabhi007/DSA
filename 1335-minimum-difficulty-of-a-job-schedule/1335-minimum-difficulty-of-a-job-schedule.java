class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
         int len = jobDifficulty.length;
        if (len < d) return -1;
        if (len == d) {
            int sum = 0;
            for (int jd : jobDifficulty) {
                sum += jd;
            }
            return sum;
        }
        int[][] dp = new int[len][d+1];
        for (int[] sub : dp)
            Arrays.fill(sub, 10000);
        int max = 0;
        for (int j = 0; j < len; j++) {
            max = Math.max(max, jobDifficulty[j]);
            dp[j][1] = max;        
        }
        for (int i = 2; i <= d; i++) {    
            for (int j = len-1; j >= i-1; j--) {
                int min = 10000; max = 0;
                for (int k = j; k >= 1; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    min = Math.min(min, dp[k-1][i-1] + max);
                }
                dp[j][i] = min;
            }
        }
        return dp[len-1][d];
    }
}