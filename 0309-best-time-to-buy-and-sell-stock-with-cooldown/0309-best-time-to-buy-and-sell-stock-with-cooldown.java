class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=1;j++){
                for(int k=0;k<=1;k++)
                    dp[i][j][k] = -1;
            }
        }
        return func(prices,0,0,0,dp);
    }
    public int func(int[] prices,int idx,int buy,int cooldown,int[][][]dp){
        if(idx==prices.length) return 0;
        if(dp[idx][buy][cooldown]!=-1) return dp[idx][buy][cooldown];
        
        if(cooldown==1){
            return dp[idx][buy][cooldown]=func(prices,idx+1,buy,0,dp);
        }else if(buy==0){
            int op1 = func(prices,idx+1,0,0,dp);
            int op2 = -prices[idx]+func(prices,idx+1,1,0,dp);
            return dp[idx][buy][cooldown]=Math.max(op1,op2);
        }else{
            int op1 = func(prices,idx+1,1,0,dp);
            int op2 = prices[idx]+func(prices,idx+1,0,1,dp);
            return dp[idx][buy][cooldown]=Math.max(op1,op2);
        }
    }
}