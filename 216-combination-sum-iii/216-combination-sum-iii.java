class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(1,n,k,list,ans);
        return ans;
    }
    public void backtrack(int elem,int n,int k,List<Integer> list,List<List<Integer>> ans){
        if(list.size()==k){
            if(n==0)
                ans.add(new ArrayList<>(list));
            return;
        }
        if(list.size()>k)
            return;
        
        for(int i=elem;i<=n&&i<=9;i++){
            list.add(i);
            backtrack(i+1,n-i,k,list,ans);
            list.remove(list.size()-1);
        }
    }
}