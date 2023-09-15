class Solution {
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                for(int ways=1;ways<=k;ways++)
                    if(j>=ways)
                    dp[i][j] = (dp[i][j] + dp[i-1][j-ways]%mod)%mod;
            }
        }
        return dp[n][target];
    }
    public int helper(int n,int k,int target,int[][]dp){
        if(target==0&&n==0) return 1;
        if(target<0||n==0) return 0;
        if(dp[n][target]!=-1) return dp[n][target];
        int ans = 0;
        for(int i=1;i<=k;i++){
            ans = (ans+helper(n-1,k,target-i,dp)%mod)%mod;
        }
        return dp[n][target]=ans%mod;
    }
}