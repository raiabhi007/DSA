class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][m] = 1;
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s.charAt(i)==t.charAt(j))
                    dp[i][j] = dp[i+1][j+1]+dp[i+1][j];
                else
                    dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }
    public int helper(int i,int j,String s,String t,int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s.charAt(i)==t.charAt(j)){
            int inc = helper(i+1,j+1,s,t,dp);
            int exc = helper(i+1,j,s,t,dp);
            return dp[i][j]=inc+exc;
        }
        return dp[i][j]=helper(i+1,j,s,t,dp);
    }
}