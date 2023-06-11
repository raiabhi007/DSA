class Solution {
    int mod = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3001][1001];
        for(int i=0;i<3001;i++){
            for(int j=0;j<1001;j++)
                dp[i][j] = -1;
        }
        return helper(startPos,endPos,k,dp)%mod;
    }
    
    public int helper(int s,int e,int k,int[][] dp){
        if(k==0){
            if(s==e)
                return 1;
            return 0;
        }
        if(dp[s+1000][k]!=-1){
            return dp[s+1000][k]%mod;
        }
        int left = helper(s-1,e,k-1,dp)%mod;
        int right = helper(s+1,e,k-1,dp)%mod;
        return dp[s+1000][k] = (left+right)%mod;
    }
}