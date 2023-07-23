class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return func(prices,0,0,fee,dp);
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