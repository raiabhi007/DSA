class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][n];
    
        for(int i=n-2;i>=0;i--){
            for(int j=i+2;j<n;j++){ 
                int ans = Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int temp = values[i]*values[k]*values[j]+dp[i][k]+dp[k][j];
                    ans = Math.min(ans,temp);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n-1];
    }
    public int helper(int i,int j,int values[],int[][] dp){
        if(i+1==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int temp = values[i]*values[k]*values[j]+helper(i,k,values,dp)+helper(k,j,values,dp);
            ans = Math.min(temp,ans);
        }
        return dp[i][j]=ans;
    }
}