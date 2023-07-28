class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
       return helper(n,dp); 
    }
    
    public int helper(int n,int[] dp){
        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(i*i>n)
                break;
            int temp = helper(n-i*i,dp);
            ans = Math.min(temp,ans);
        }
        return dp[n]=ans+1;    
    }
}