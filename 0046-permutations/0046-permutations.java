class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,ans);
        return ans;
    }
    void backtrack(int[] nums,int start,List<List<Integer>> ans){
        if(start==nums.length){
            ans.add(toList(nums));
            return;
        }
        for(int i=start;i<nums.length;i++){
           swap(start,i,nums);
           backtrack(nums,start+1,ans);
            swap(start,i,nums);
        }
    }
    void swap(int i,int j,int[] arr){
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