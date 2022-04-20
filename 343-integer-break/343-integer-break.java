class Solution {
    public int integerBreak(int n) {
        if(n==2||n==3)
            return n-1;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[2] = 2;
        dp[3] = 3;
        int ans = helper(n,dp);
        return ans;
        
       
    }
    public int helper(int n,int[] dp){
         if(n==2||n==3)
        return n;
        if(dp[n]!=-1)
            return dp[n];
         int ans = Integer.MIN_VALUE;
        for(int i=2;i<n-1;i++){
            int temp = (i*helper(n-i,dp));
            ans = Math.max(ans,temp);
        }
        ans = Math.max(ans,n);
        return dp[n]=ans;
    }
}