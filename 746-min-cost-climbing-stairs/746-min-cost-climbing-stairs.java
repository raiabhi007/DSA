class Solution {
    public int minCostClimbingStairs(int[] cost) {
       if(cost.length==2)
           return Math.min(cost[0],cost[1]);
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost,cost.length,dp),helper(cost,cost.length-1,dp));
    }
    public int helper(int[] cost,int n,int[] dp){
        if(n==1||n==2)
            return cost[n-1];
        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n] = cost[n-1]+Math.min(helper(cost,n-1,dp),helper(cost,n-2,dp));
    }
}