class Solution {
    public int specialArray(int[] nums) {
         Arrays.sort(nums);
        for (int i = 0; i < nums.length - (i > 0 ? nums[i - 1] : 0); ++i) {
            if (nums[i] >= nums.length - i) {
                return nums.length - i;
            }
        }
        return -1;
    }
}