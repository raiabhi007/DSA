class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(1,k,n,list,ans);
        return ans;
    }
    public void backtrack(int i,int k,int n,List<Integer> list, List<List<Integer>> ans){
        if(i==10){
            if(k==0&&n==0)
                ans.add(new ArrayList<>(list));
            return;
        }
        if(n>=i){
            list.add(i);
            backtrack(i+1,k-1,n-i,list,ans);
            list.remove(list.size()-1);
        }
        backtrack(i+1,k,n,list,ans);
    }
}