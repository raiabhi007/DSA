class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,0,ans,list);
        return ans;
    }
    public void helper(int[] nums,int idx,List<List<Integer>> ans,List<Integer> list){
        ans.add(new ArrayList<>(list));
        for(int i=idx;i<nums.length;i++){
            if(i>idx&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            helper(nums,i+1,ans,list);
            list.remove(list.size()-1);
        }
    }
}