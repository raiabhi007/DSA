class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==0)
                        dp[i][buy][cap] = Math.max(dp[i+1][0][cap],-prices[i]+dp[i+1][1][cap]);
                        else
                        dp[i][buy][cap] = Math.max(dp[i+1][1][cap],prices[i]+dp[i+1][0][cap-1]);   
                }
            }
        }
        return dp[0][0][2];
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