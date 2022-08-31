class Solution {
    public int maxProfit(int k, int[] arr) {
        if(arr.length==0)
         return 0;   
        int n = arr.length;
        int[][] dp = new int[k+1][n];
        for(int t=1;t<=k;t++){
            int max = Integer.MIN_VALUE;
            for(int d=1;d<arr.length;d++){
                if(dp[t-1][d-1]-arr[d-1]>max)
                    max = dp[t-1][d-1] - arr[d-1];
                if(max+arr[d]>dp[t][d-1])
                    dp[t][d] = max + arr[d];
                else
                    dp[t][d] = dp[t][d-1];
            }
        }
        return dp[k][n-1];
    }
}