class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++)
            totalSum+=nums[i];
        if(totalSum%2==1)
            return false;
        int sum = totalSum/2;
        boolean dp[][] = new boolean[nums.length+1][sum+1];
     dp[0][0] = true;
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(j>=nums[i-1]){
                    if(dp[i-1][j-nums[i-1]]==true)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][sum];
    }
}