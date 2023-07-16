class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0)
                    dp[i][j] = matrix[i][j];
                else if(j==0){
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                }else if(j==n-1)
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                else
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--)
            ans = Math.min(ans,dp[n-1][i]);
        return ans;
    }
}