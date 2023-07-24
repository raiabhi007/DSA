class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp,n);
        int[] hash = new int[n];
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0&&1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                }
            }
        }
        int a=-1;
        int lastIndex = -1;
        for(int i=0;i<n;i++){
            if(dp[i]>a){
                a = dp[i];
                lastIndex=i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }

        return ans;
    }
}