class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
    public void  helper(int[] arr, int idx, List<List<Integer>> ans){
        if(idx==arr.length){
            ans.add(toList(arr));
            return;
        }
        for(int j=idx;j<arr.length;j++){
            swap(idx,j,arr);
            helper(arr,idx+1,ans);
            swap(idx,j,arr);
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