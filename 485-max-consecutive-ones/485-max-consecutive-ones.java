class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i=0;
        while(i<nums.length){
            if(nums[i]==1){
                int j=i;
                while(i<nums.length&&nums[i]==1){
                    i++;
                }
                max = Math.max(max,i-j);
            }else
                i++;
        }
        return max;
    }
}