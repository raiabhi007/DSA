class Solution {
    public int maxProfit(int k, int[] prices) {
         int[][][] dp = new int[prices.length+1][2][k+1];
        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy==0)
                        dp[i][0][cap] = Math.max(dp[i+1][0][cap],-prices[i]+dp[i+1][1][cap]);
                    else
                        dp[i][1][cap] = Math.max(dp[i+1][1][cap],prices[i]+dp[i+1][0][cap-1]);
                }
            }
        }
        return dp[0][0][k];
    }
    public int func(int[] prices,int idx,int buy,int k,int[][][] dp){
        if(k==0) return 0;
        if(idx==prices.length) return 0;
        if(dp[idx][buy][k]!=-1)
            return dp[idx][buy][k];
        if(buy==0){
            int op1 = func(prices,idx+1,0,k,dp);
            int op2 = -prices[idx]+func(prices,idx+1,1,k,dp);
            return dp[idx][buy][k]=Math.max(op1,op2);
        }else{
            int op1 = func(prices,idx+1,1,k,dp);
            int op2 = prices[idx]+func(prices,idx+1,0,k-1,dp);
            return dp[idx][buy][k]=Math.max(op1,op2);
        }
    }
}