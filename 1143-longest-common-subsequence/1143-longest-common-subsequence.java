class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] =new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++)
            Arrays.fill(dp[i],-1);
         
        return lcs(text1,text2,0,0,dp);
    }
    public int lcs(String s,String t,int i,int j,int[][] dp){
        if(i==s.length()||j==t.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return dp[i][j]=1+lcs(s,t,i+1,j+1,dp);
        int first = lcs(s,t,i+1,j,dp);
        int second = lcs(s,t,i,j+1,dp);
        return dp[i][j]=Math.max(first,second);
    }
}