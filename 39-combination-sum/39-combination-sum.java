class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0,candidates,0,target,ans,list);
        return ans;
        
    }
    public void backtrack(int i,int[] arr,int sum,int tar,List<List<Integer>> ans,List<Integer> list){
        if(i==arr.length){
            if(sum==tar)
                ans.add(new ArrayList<>(list));
            return;
        }
        for(int j=(tar-sum)/arr[i];j>=1;j--){
            for(int k=0;k<j;k++)
                list.add(arr[i]);
            backtrack(i+1,arr,sum+arr[i]*j,tar,ans,list);
            for(int k=0;k<j;k++)
                list.remove(list.size()-1);
        }
        backtrack(i+1,arr,sum,tar,ans,list);
    }
}