class Solution {
    public int climbStairs(int n) {
        if(n==1||n==0)
            return 1;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]; 
        }
        return dp[n];
    }
    // public int helper(int n,int[] dp){
    //     if(n==0||n==1)
    //         return dp[n]=1;
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     return dp[n] = helper(n-1,dp)+helper(n-2,dp);
    // }
}