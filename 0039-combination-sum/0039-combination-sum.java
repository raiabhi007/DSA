class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates,0,0,target,list,ans);
        return ans;
    }
    void backtrack(int[] arr,int i,int sum,int tar,List<Integer> list,List<List<Integer>> ans){
        if(i==arr.length){
            if(sum==tar){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int j=(tar-sum)/arr[i];j>=1;j--){
            for(int k=0;k<j;k++)
                list.add(arr[i]);
            backtrack(arr,i+1,sum+arr[i]*j,tar,list,ans);
            for(int k=0;k<j;k++)
                list.remove(list.size()-1);
        }
        backtrack(arr,i+1,sum,tar,list,ans);
    }
}