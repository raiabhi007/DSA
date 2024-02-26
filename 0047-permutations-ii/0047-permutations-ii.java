class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
    public void helper(int nums[],int idx,List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(toList(nums));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(i,idx,nums);
            helper(nums,idx+1,ans);
            swap(i,idx,nums);
        }
    }
    public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     public List<Integer> toList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i:nums)
            list.add(i);
        return list;
    }
}