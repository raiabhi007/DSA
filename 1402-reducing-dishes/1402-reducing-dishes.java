class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        int dp[][] = new int[n][n+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        Arrays.sort(satisfaction);
        return helper(satisfaction,0,1,dp);
        
    }
    public int helper(int[] satisfaction,int i,int time,int[][] dp){
        if(i==satisfaction.length) return 0;
        if(dp[i][time]!=-1) return dp[i][time];
        
        int inc = time*satisfaction[i] + helper(satisfaction,i+1,time+1,dp);
        int exc = helper(satisfaction,i+1,time,dp);
        return dp[i][time]=Math.max(inc,exc);
    }
}