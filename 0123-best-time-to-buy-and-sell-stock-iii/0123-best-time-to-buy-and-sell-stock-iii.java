class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        return helper(prices,0,0,2,dp);
    }
    public int helper(int[] prices,int i,int buy,int t,int[][][] dp){
        if(i==prices.length) return 0;
        if(t==0) return 0;
        if(dp[i][buy][t-1]!=-1) return dp[i][buy][t-1];
        int profit = 0;
        if(buy==0){
            int temp1 = helper(prices,i+1,0,t,dp);
            int temp2 = -prices[i]+helper(prices,i+1,1,t,dp);
            profit = Math.max(temp1,temp2);
        }else{
            int temp1 = helper(prices,i+1,1,t,dp);
            int temp2 = prices[i]+helper(prices,i+1,0,t-1,dp);
            profit = Math.max(temp1,temp2);
        }
        return dp[i][buy][t-1]=profit;
    }
}