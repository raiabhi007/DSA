class Solution {
    public int maxProfit(int k, int[] prices) {
         int[][][] dp = new int[prices.length][2][k+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=1;j++){
                for(int l=0;l<=k;l++){
                    dp[i][j][l]=-1;
                }
            }
        }
        return func(prices,0,0,k,dp);
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