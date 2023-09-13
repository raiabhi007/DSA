class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][] = new int[n+1][k+1];
        return helper(k,n,dp);
    }
    public int helper(int k,int n,int[][] dp){
        if(n==0||k==0) return 0;
        if(n==1) return 1;
        if(k==1) return n;
        if(dp[n][k]>0) return dp[n][k];
        
        int ans = Integer.MAX_VALUE;
        // for(int i=1;i<=n;i++){
        //     int survive = helper(k,n-i,dp);
        //     int drop = helper(k-1,i-1,dp);
        //     int temp = Math.max(survive,drop);
        //     ans = Math.min(ans,temp);
        // }
        int low = 1,high = n;
        while(low<high){
            int mid = (low+high)/2;
            int drop = helper(k-1,mid-1,dp);
            int survive = helper(k,n-mid,dp);
            int temp = Math.max(drop,survive);
            ans = Math.min(ans,temp);
            if(drop==survive)
                break;
            else if(drop<survive)
                low = mid+1;
            else
               high = mid; 
        }
        return dp[n][k]=1+ans;
    }
}