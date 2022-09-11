class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int dp[] = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            int tempMax = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    tempMax = Math.max(tempMax,dp[j]);
            }
            dp[i] = 1+tempMax;
            max = Math.max(dp[i],max);
        }
        return max;
    }
}