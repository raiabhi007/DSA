class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates,0,target,ans,list);
        return ans;
    }
    public void helper(int[] arr,int idx,int target,List<List<Integer>> ans,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(arr.length==idx) return;
        int itr=0;
        for(int sum=arr[idx];sum<=target;sum+=arr[idx]){
            list.add(arr[idx]);
            helper(arr,idx+1,target-sum,ans,list);
            itr++;
        }
        while(itr-->0)
            list.remove(list.size()-1);
        helper(arr,idx+1,target,ans,list);
    }
}