class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int ans1 = robHelper(nums,0,nums.length-2);
        int ans2 = robHelper(nums,1,nums.length-1);
        
        return Math.max(ans1,ans2);
    }
    public int robHelper(int[] nums,int i,int j){
        if(i==j)
            return nums[i];
        int dp[] = new int[nums.length];
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i],nums[i+1]);
        
        for(int k=i+2;k<=j;k++)
            dp[k] = Math.max(dp[k-1],dp[k-2]+nums[k]);
        return dp[j];
    }
}