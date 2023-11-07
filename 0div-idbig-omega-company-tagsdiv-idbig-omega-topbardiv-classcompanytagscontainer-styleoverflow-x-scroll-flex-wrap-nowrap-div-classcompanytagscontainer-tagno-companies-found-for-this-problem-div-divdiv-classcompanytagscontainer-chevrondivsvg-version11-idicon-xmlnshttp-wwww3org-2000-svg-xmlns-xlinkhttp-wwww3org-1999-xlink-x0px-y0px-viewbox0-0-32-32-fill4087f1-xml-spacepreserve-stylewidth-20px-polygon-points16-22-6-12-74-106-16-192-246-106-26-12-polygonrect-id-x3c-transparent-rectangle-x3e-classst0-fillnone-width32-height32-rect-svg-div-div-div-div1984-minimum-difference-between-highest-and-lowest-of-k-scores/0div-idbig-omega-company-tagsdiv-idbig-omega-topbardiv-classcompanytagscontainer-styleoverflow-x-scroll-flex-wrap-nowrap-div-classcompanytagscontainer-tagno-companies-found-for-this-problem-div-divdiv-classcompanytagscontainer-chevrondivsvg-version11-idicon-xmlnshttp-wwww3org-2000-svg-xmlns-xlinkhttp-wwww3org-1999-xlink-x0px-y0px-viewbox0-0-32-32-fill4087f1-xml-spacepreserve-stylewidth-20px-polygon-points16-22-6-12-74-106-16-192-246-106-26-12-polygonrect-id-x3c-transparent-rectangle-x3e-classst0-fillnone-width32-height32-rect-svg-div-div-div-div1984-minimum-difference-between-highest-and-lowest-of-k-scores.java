class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if(k==1) return 0;
        int j=0;
        int diff = Integer.MAX_VALUE;
        
        for(int i=0;i+k<=nums.length;i++){
            diff = Math.min(diff,nums[i+k-1]-nums[i]);
        }
        return diff;
        
    }
}