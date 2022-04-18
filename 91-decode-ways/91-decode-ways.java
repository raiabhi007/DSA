class Solution {
    public int numDecodings(String s) {
        Integer dp[] = new Integer[s.length()+1];
        return s.length()=='0'?0:helper(0,s,dp);
    }
    public int helper(int p,String s,Integer[] dp){
        int n = s.length();
        if(p==n)
            return 1;
        if(s.charAt(p)=='0')
            return 0;
        if(dp[p]!=null)
            return dp[p];
        int res=0;
            res+=helper(p+1,s,dp);
        if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7'))
            res+=helper(p+2,s,dp);
        return dp[p]=res;
    }
}