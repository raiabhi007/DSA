class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=1;i<=n;i++)
            arr[i] = nums[i-1];
        int dp[][] = new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int max = Integer.MIN_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = arr[i-1]*arr[ind]*arr[j+1]+dp[i][ind-1]+dp[ind+1][j];
                    max = Math.max(cost,max);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
    // public int helper(int i,int j, int[] arr,int[][] dp){
    //     if(i>j) return 0;
    //     int max = Integer.MIN_VALUE;
    //     if(dp[i][j]!=-1)
    //         return dp[i][j];
    //     for(int ind=i;ind<=j;ind++){
    //         int cost = arr[i-1]*arr[ind]*arr[j+1]+helper(i,ind-1,arr,dp)+helper(ind+1,j,arr,dp);
    //         max = Math.max(cost,max);
    //     }
    //     return dp[i][j]=max;
    // }
}