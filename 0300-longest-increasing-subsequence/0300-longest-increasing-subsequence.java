class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int ans = 1;
        for(int i=1;i<n;i++){
            int maxi = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j])
                maxi = Math.max(maxi,dp[j]);
            }
            dp[i]=maxi+1;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}