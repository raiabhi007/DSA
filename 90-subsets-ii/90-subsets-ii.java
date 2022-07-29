class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0,nums,list,ans);
        return ans;
    }
    public void backtrack(int i,int[] nums,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        
        for(int k=i;k<nums.length;k++){
           if(k>i&&nums[k]==nums[k-1]) continue;
            list.add(nums[k]);
            backtrack(k+1,nums,list,ans);
            list.remove(list.size()-1);
        }
    }
}