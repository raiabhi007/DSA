class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int temp = 1;
                int element = nums[i]+1;
                while(set.contains(element)){
                    element++;
                    temp++;
                } 
                ans = Math.max(ans,temp);
            }
        }
        return ans;
    }
}