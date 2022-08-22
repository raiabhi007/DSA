class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1,dp);
    }
    public int helper(int[] nums,int i,int[] dp){
        if(i==0)
            return nums[i];
        if(i==1)
            return Math.max(nums[0],nums[1]);
        if(dp[i]!=-1)
            return dp[i];
        return dp[i]=Math.max(nums[i]+helper(nums,i-2,dp),helper(nums,i-1,dp));
            
    }
}