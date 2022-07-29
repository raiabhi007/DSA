class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0,nums,list,ans);
        return ans;
    }
    public void backtrack(int i,int[] nums,List<Integer> list,List<List<Integer>> ans){
        if(i==nums.length){
            if(!ans.contains(list))
            ans.add(new ArrayList<>(list));
            return;
        }
        backtrack(i+1,nums,list,ans);
        list.add(nums[i]);
        backtrack(i+1,nums,list,ans);
        list.remove(list.size()-1);
    }
}