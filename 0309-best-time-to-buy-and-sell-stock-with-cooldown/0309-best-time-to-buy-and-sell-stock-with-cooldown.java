class Solution {
    public int maxProfit(int[] prices) {
         int dp[][] = new int[prices.length+2][2];
        for(int i=prices.length-1;i>=0;i--){
            dp[i][0]= Math.max(dp[i+1][0],-prices[i]+dp[i+1][1]);
            dp[i][1]= Math.max(dp[i+1][1],prices[i]+dp[i+2][0]);
        }
        
        return dp[0][0];
    }
     public int helper(int prices[],int i,int buy,int[][]dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==0){
            int temp1 = helper(prices,i+1,0,dp);
            int temp2 = -prices[i]+helper(prices,i+1,1,dp);
             profit=Math.max(temp1,temp2);
        }else{
            int temp1 = helper(prices,i+1,1,dp);
            int temp2 = prices[i]+helper(prices,i+2,0,dp);
            profit=Math.max(temp1,temp2);
        }
        dp[i][buy] = profit;
        return profit;
        
    }
}