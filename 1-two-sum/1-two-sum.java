class Solution {
    public int[] twoSum(int[] nums, int target) {
         int[] ans = new int[2];
    Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (hmap.containsKey(target - nums[i])) {
            ans[1] = i;
            ans[0] = hmap.get(target - nums[i]);
            return ans;
        }
        hmap.put(nums[i], i);
    }
    return ans;
    }
}