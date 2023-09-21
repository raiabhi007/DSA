class Solution {
    public int numTrees(int n) {
       if(n<=1) return 1;
        
       int dp[] = new int[n+1];
       return helper(n,dp); 
    }
    
    int helper(int n,int dp[]){
        if(n<=1) return 1;
        if(dp[n]>0) return dp[n];
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans+=helper(i-1,dp)*helper(n-i,dp);
        }
        return dp[n]=ans;
    }
}