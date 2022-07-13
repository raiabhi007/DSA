class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinations(1,n,k,list,ans);
        return ans;
    }
    private void combinations(int i,int n,int k,List<Integer> list,List<List<Integer>> ans){
        if(i>n){
            if(list.size()==k)
                ans.add(new ArrayList(list));
            return;
        }
        
        list.add(i);
        combinations(i+1,n,k,list,ans);
        list.remove(list.size()-1);
        combinations(i+1,n,k,list,ans);
    }
}