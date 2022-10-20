class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates,0,0,target,list,ans);
        return ans;
    }
    void backtrack(int[] arr,int idx,int sum,int tar,List<Integer> list,List<List<Integer>> ans){
        if(sum==tar){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>tar)
            return;
        for(int i=idx;i<arr.length;i++){
            if(i>idx&&arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            backtrack(arr,i+1,sum+arr[i],tar,list,ans);
            list.remove(list.size()-1);
        }
    }
}