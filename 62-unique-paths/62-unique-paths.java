class Solution {
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                dp[i][j] = -1;
         }
        dp[m-1][n-1] = 1;
        int ans =helper(0,0,m,n,dp); 
        return ans;
    }
    public int helper(int i,int j,int m,int n,int[][] dp){
        if(i<0||j<0||i==m||j==n)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans = 0;
        ans+=helper(i+1,j,m,n,dp);
        ans+=helper(i,j+1,m,n,dp);
        return dp[i][j] = ans;
    }
}