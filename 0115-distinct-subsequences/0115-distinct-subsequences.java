class Solution {
    public int numDistinct(String s, String t) {
        int dp[][]  = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length();i++)
        Arrays.fill(dp[i],-1);
        return helper(s,t,0,0,dp);
    }
    public int helper(String s, String t, int i,int j,int[][] dp){
        if(j==t.length())
            return 1;
        if(i==s.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int inc = 0;
        if(s.charAt(i)==t.charAt(j))
            inc+=helper(s,t,i+1,j+1,dp);
        int exc = helper(s,t,i+1,j,dp);
        return dp[i][j]=inc+exc;
    }
}