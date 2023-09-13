class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int l=0;l<=k;l++)
                    dp[i][j][l] = -1;
            }
        }
        return helper(prices,0,0,k,dp);
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