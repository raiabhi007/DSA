class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy==0){
                        dp[idx][buy][cap] = Math.max(dp[idx+1][0][cap],-prices[idx]+dp[idx+1][1][cap]);
                    }else
                        dp[idx][buy][cap] = Math.max(dp[idx+1][1][cap],prices[idx]+dp[idx+1][0][cap-1]);
                }
            }
        }
        return dp[0][0][k];
    }
    
    public int helper(int[] prices,int idx,int buy,int k,int[][][] dp){
        if(idx==prices.length) return 0;
        if(k==0) return 0;
        if(dp[idx][buy][k]!=-1) return dp[idx][buy][k];
        int profit=0;
        if(buy==0){
            int temp1 = helper(prices,idx+1,0,k,dp);
            int temp2 = -prices[idx]+helper(prices,idx+1,1,k,dp);
            profit = Math.max(temp1,temp2);
        }else{
            int temp1 = helper(prices,idx+1,1,k,dp);
            int temp2 = prices[idx]+helper(prices,idx+1,0,k-1,dp);
            profit = Math.max(temp1,temp2);
        }
        return dp[idx][buy][k]=profit;
    }
}