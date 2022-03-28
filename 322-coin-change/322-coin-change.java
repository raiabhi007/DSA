class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
         Arrays.fill(dp,-1);
         dp[0] = 0;
        int ans = helper(coins,amount,dp);
       
        return (ans!=Integer.MAX_VALUE)?ans:-1;
    }
    public int helper(int[] coins,int amount,int dp[]){
        if(dp[amount]!=-1)
            return dp[amount];
        if(amount==0)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(amount>=coins[i]){
                int temp = helper(coins,amount-coins[i],dp);
                ans = Math.min(ans,temp);
            }
        }
        if(ans==Integer.MAX_VALUE)
            return dp[amount]=ans;
        else
            return dp[amount]=ans+1;
    }
}