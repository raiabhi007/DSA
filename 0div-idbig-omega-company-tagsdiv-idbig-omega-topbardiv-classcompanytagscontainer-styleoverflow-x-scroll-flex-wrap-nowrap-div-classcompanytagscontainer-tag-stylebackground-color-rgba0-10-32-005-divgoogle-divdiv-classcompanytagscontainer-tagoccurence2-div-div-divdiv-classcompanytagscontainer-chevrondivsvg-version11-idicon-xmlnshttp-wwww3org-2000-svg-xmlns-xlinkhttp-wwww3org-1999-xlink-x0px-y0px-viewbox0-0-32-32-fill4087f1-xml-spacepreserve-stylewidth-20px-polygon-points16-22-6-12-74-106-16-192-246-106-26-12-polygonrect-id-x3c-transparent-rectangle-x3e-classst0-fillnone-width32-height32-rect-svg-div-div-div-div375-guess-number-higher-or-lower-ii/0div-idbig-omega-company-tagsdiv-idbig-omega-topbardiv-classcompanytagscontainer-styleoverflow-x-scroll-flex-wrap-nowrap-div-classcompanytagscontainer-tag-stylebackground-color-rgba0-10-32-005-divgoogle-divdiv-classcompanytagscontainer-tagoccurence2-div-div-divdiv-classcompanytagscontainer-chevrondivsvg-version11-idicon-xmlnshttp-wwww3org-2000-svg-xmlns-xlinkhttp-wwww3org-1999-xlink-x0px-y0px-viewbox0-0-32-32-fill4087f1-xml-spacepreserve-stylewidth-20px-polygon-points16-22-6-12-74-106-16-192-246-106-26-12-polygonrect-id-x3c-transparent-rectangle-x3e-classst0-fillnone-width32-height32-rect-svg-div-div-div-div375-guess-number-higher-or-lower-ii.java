class Solution {
    public int getMoneyAmount(int n) {
        int dp[][] = new int[n+2][n+2];
        
        for(int start=n;start>=1;start--){
            for(int end=start;end<=n;end++){
                if(start==end) continue;
                int maxi = Integer.MAX_VALUE;
                for(int i=start;i<=end;i++)
                maxi = Math.min(maxi,i+Math.max(dp[start][i-1],dp[i+1][end]));
                dp[start][end] = maxi;
            }
        }
        return dp[1][n];
    }
    public int helper(int start,int end,int[][]dp){
        if(start>=end) return 0;
        if(dp[start][end]>0) return dp[start][end];
        int maxi = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            maxi = Math.min(maxi,i+Math.max(helper(start,i-1,dp),helper(i+1,end,dp)));
        }
        return dp[start][end]=maxi;
    }
}