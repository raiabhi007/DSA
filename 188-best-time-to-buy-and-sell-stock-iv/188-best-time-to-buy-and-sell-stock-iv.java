class Solution {
    public int maxProfit(int k, int[] arr) {
        if(arr.length==0)
         return 0;   
        int n = arr.length;
        int[][] dp = new int[k+1][n];
        for(int t=1;t<=k;t++){
            for(int d=1;d<arr.length;d++){
                int max = dp[t][d-1];
                for(int pd=0;pd<d;pd++){
                    int ptillm1 = dp[t-1][pd];
                    int ptth = arr[d] - arr[pd];
                    if(ptillm1+ptth>max)
                        max = ptillm1 + ptth;
                }
                dp[t][d] = max;
            }
        }
        return dp[k][n-1];
    }
}