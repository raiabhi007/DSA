class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return robHelper(0,nums,dp);
    }
    public int robHelper(int i,int[] nums,int[]dp){
        if(i>=nums.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        return dp[i]=Math.max(nums[i]+robHelper(i+2,nums,dp),robHelper(i+1,nums,dp));
    }
}