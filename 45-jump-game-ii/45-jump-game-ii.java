class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    public int helper(int[] nums,int i,int[] dp){
        if(i>=nums.length-1){
            return dp[nums.length-1] = 0;
        }
        if(nums[i]==0)
            return Integer.MAX_VALUE;
        if(dp[i]!=-1)
            return dp[i];
        int ans = Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            ans = Math.min(helper(nums,j+i,dp),ans);
        }
        if(ans==Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        return dp[i] = ans+1;
    }
}