class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
       
       for(int i=idx;i<arr.length;i++){
           if(i>idx&&arr[i-1]==arr[i]) continue;
           
               if(target>=arr[i]){
                   list.add(arr[i]);
                   helper(arr,i+1,target-arr[i],ans,list);
                   list.remove(list.size()-1);
               }else
                   break;
               // helper(arr,i+1,target,ans,list);
           
       }
   } 
}