class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int presum[] = new int[n+1];
        int sum = 0;
        int total = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int compliment = sum-goal;
            if(compliment>=0)
                total+=presum[compliment];
            if(sum==goal) total++;
            presum[sum]+=1;
        }
        return total;
    }
}