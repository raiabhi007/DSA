class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[n-1] = 0;
        for(int i = n-2;i>=0;i--){
            int jumpCount  = Integer.MAX_VALUE;
            if(nums[i]!=0){
            for(int j=1;j<=nums[i];j++){
                if(i+j==nums.length)
                    break;
                jumpCount = Math.min(dp[i+j],jumpCount);
               }
                dp[i] = jumpCount+1;
            }else
                dp[i] = 100000;    
        }
        return dp[0];
    }
}