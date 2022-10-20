class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> list = new ArrayList<>();
       backtrack(nums,0,list,ans);
       return ans; 
    }
    void backtrack(int[] nums,int i,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        
        for(int k=i;k<nums.length;k++){
            if(k>i&&nums[k]==nums[k-1])
                continue;
            list.add(nums[k]);
            backtrack(nums,k+1,list,ans);
            list.remove(list.size()-1);
        }
    }
}