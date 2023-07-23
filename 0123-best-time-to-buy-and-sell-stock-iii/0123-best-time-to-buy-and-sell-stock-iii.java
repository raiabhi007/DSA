class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++)
                    dp[i][j][k] = -1;
            }
        }
        return func(prices,0,0,2,dp);
    }
    public int func(int[] prices,int idx,int buy,int cap,int[][][] dp){
        if(cap==0) return 0;
        if(idx==prices.length) return 0;
        if(dp[idx][buy][cap]!=-1)
            return dp[idx][buy][cap];
        if(buy==0){
            int op1 = func(prices,idx+1,0,cap,dp);
            int op2 = -prices[idx]+func(prices,idx+1,1,cap,dp);
            return dp[idx][buy][cap]=Math.max(op1,op2);
        }else{
            int op1 = func(prices,idx+1,1,cap,dp);
            int op2 = prices[idx]+func(prices,idx+1,0,cap-1,dp);
            return dp[idx][buy][cap]=Math.max(op1,op2);
        }
    }
}