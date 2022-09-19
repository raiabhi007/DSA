class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)){
                continue;
            }else{
                int tempAns = 0;
                int prev = nums[i];
                while(set.contains(prev)){
                    tempAns++;
                    prev++;
                }
                ans = Math.max(ans,tempAns);
            }
        }
        return ans;
    }
}