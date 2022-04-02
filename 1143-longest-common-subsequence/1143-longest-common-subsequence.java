class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length();j++){
                dp[i][j] = -1;
            }
        }
         return LCS(text1,text2,text1.length(),text2.length(),dp);
        
    }
    int LCS(String text1,String text2,int m,int n,int dp[][]){
        if(m==0||n==0)
            return dp[m][n] = 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        if(text1.charAt(m-1)==text2.charAt(n-1))
            return dp[m][n] = 1+LCS(text1,text2,m-1,n-1,dp);
        
        return dp[m][n] = Math.max(LCS(text1,text2,m-1,n,dp),LCS(text1,text2,m,n-1,dp));
    }
}