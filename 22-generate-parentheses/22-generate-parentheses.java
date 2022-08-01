class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n,n,ans,"");
        return ans;
    }
    public void backtrack(int left,int right,List<String> ans,String asf){
        if(left>right)
            return;
        if(left>0)
            backtrack(left-1,right,ans,asf+"(");
        if(right>0)
            backtrack(left,right-1,ans,asf+")");
        if(left==0&&right==0)
            ans.add(asf);
    }
}