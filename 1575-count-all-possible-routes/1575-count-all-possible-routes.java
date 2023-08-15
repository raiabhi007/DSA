class Solution {
    int mod = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n  = locations.length;
        int dp[][] = new int[n+1][fuel+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=fuel;j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(locations,start,finish,fuel,dp);
    }
    public int helper(int[] arr,int start,int finish,int fuel,int[][] dp){
        if(fuel<0) return 0;
        int ans = 0;
        if(dp[start][fuel]!=-1) return dp[start][fuel];
        if(start==finish) ans++;
   
        for(int i=0;i<arr.length;i++){
            if(i==start) continue;
            ans = (ans+helper(arr,i,finish,fuel-Math.abs(arr[start]-arr[i]),dp))%mod;
        }
        return dp[start][fuel]=ans;
    }
}