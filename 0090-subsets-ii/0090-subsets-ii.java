class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,nums,ans,list);
        return ans;
    }
    public void helper(int  idx,int[] nums,List<List<Integer>> ans,List<Integer> list){
        ans.add(new ArrayList<>(list));
        for(int i=idx;i<nums.length;i++){
            if(i>idx&&(nums[i-1]==nums[i])) continue;
            list.add(nums[i]);
            helper(i+1,nums,ans,list);
            list.remove(list.size()-1);
        }
    }
}