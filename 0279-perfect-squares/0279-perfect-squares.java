class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            int ans = Integer.MAX_VALUE;
            int temp = (int)Math.sqrt(i)+1;
            for(int j=temp;j>=1;j--){
                if(j*j>i) continue;
                ans = Math.min(ans,dp[i-j*j]);   
            }
            dp[i] = 1+ans;
        }
        return dp[n];
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