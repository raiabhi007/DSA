class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0,candidates,0,target,list,ans);
        return ans;
    }
    public void backtrack(int idx,int[] arr,int sum,int target,List<Integer> list,List<List<Integer>> ans){
        if(target==sum){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>target)
            return;
        
       for (int i = idx; i < arr.length; i++){
        if (i > idx && arr[i]==arr[i-1]) continue;
        list.add(arr[i]);
        backtrack(i+1,arr,sum+arr[i],target,list,ans);
        list.remove(list.size()-1);
      }
    }
}