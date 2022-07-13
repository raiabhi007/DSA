class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permutations(0,nums,list,ans);
        return ans;
    }
    public void permutations(int idx,int[] nums,List<Integer> list,List<List<Integer>> ans){
        if(list.size()==nums.length){
            List ansList = new ArrayList<>(list);
            ans.add(ansList);
            return;
        }        
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                permutations(idx+1,nums,list,ans);
                list.remove(idx);
            }
        }
    }
}