class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans,nums,0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,int[] nums,int start){
        if(start==nums.length){
            ans.add(toList(nums));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            swap(i,start,nums);
            backtrack(ans,nums,start+1);
            swap(i,start,nums);
        }
    }
     public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<Integer> toList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i:nums)
            list.add(i);
        return list;
    }
}