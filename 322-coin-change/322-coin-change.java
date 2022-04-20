class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        int res = coinChangeHelper(coins,amount,dp);
        return res==Integer.MAX_VALUE?-1:res;
    }
    public int coinChangeHelper(int[] coins,int amount,int[] dp){
         if(dp[amount]!=-1)
           return dp[amount];
        
        int res = Integer.MAX_VALUE;
       for(int i=0;i<coins.length;i++){
           if(amount-coins[i]>=0){
           int temp = coinChangeHelper(coins,amount-coins[i],dp);
           res = Math.min(res,temp);
           }
       }
        if(res==Integer.MAX_VALUE)
        return dp[amount]=res;
        else
        return dp[amount] = res+1;
    }
}