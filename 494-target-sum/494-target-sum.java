class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int TotalSum = 0;
        for(int i=0;i<n;i++)
            TotalSum+=nums[i];
        
        if(TotalSum<Math.abs(target)||(TotalSum+target)%2!=0)
            return 0;
        int s1 = (TotalSum+target)/2;
        int dp[][] = new int[n+1][s1+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s1;j++){
                if(i==0){
                    if(j==0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 0;
                }
                else if(j<nums[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = (dp[i-1][j-nums[i-1]]+dp[i-1][j])%1000000007;
            }
        }
        return dp[n][s1];
    }
}