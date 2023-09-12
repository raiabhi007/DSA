class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        int dp[][] = new int[n+1][n+2];
        Arrays.sort(satisfaction);
        for(int i=n-1;i>=0;i--){
            for(int time=n;time>=1;time--){
                if(i==n-1) dp[i][time]=0;
                int inc = time*satisfaction[i]+ dp[i+1][time+1];
                int exc = dp[i+1][time];
                dp[i][time] = Math.max(inc,exc);
            }
        }
        
        return dp[0][1];
        
    }
    public int helper(int[] satisfaction,int i,int time,int[][] dp){
        if(i==satisfaction.length) return 0;
        if(dp[i][time]!=-1) return dp[i][time];
        
        int inc = time*satisfaction[i] + helper(satisfaction,i+1,time+1,dp);
        int exc = helper(satisfaction,i+1,time,dp);
        return dp[i][time]=Math.max(inc,exc);
    }
}