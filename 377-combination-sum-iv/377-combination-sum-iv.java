class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        for(int i=0;i<=target;i++)
            dp[i] = -1;
        dp[0] = 1;
        return solve(nums,target,dp);
    }
    public int solve(int[] nums,int target,int[] dp){
        if(target==0)
            return 1;
        if(dp[target]!=-1)
            return dp[target];
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target)
                ans+=solve(nums,target-nums[i],dp);
        }
        return dp[target] = ans;
    }
}