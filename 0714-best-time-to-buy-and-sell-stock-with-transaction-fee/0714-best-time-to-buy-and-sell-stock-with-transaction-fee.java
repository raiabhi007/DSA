class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length+1][2];
        for(int i=prices.length-1;i>=0;i--){
           for(int buy=0;buy<=1;buy++){
               if(buy==0)
                   dp[i][buy] = Math.max(dp[i+1][0],-prices[i]-fee+dp[i+1][1]);
               else
                   dp[i][buy] = Math.max(dp[i+1][1],prices[i]+dp[i+1][0]);
           }
        }
        return dp[0][0];
    }
    public int func(int[] prices,int idx,int buy,int fee,int[][] dp){
        if(idx==prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        
        if(buy==0){
            int op1 = func(prices,idx+1,0,fee,dp);
            int op2 = -prices[idx]-fee+func(prices,idx+1,1,fee,dp);
            return dp[idx][buy]=Math.max(op1,op2);
        }else{
            int op1 = func(prices,idx+1,1,fee,dp);
            int op2 = prices[idx]+func(prices,idx+1,0,fee,dp);
            return dp[idx][buy]=Math.max(op1,op2);
        }
    }
}