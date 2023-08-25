class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++)
            Arrays.fill(dp[i],-1);
        return helper(s1,s2,s3,0,0,dp);
    }
    public boolean helper(String s1,String s2,String s3,int i,int j,int[][] dp){
        if(i==s1.length()&&j==s2.length()&&i+j==s3.length()) return true;
        if(i+j==s3.length()) return false;
        if(dp[i][j]!=-1) return dp[i][j]==0?false:true;
        boolean incS1 = false;
        if(i!=s1.length()&&s1.charAt(i)==s3.charAt(i+j))
            incS1 = helper(s1,s2,s3,i+1,j,dp);
        boolean incS2 = false;
        if(j!=s2.length()&&s2.charAt(j)==s3.charAt(i+j))
            incS2 = helper(s1,s2,s3,i,j+1,dp);
        boolean res=incS1||incS2;
        dp[i][j] = res==true?1:0;
        return res;
    }
}