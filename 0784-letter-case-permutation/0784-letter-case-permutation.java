class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s,0,"",ans);
        return ans;
        
    }
    void backtrack(String s, int idx,String asf,List<String> ans){
        if(idx==s.length()){
            ans.add(asf);
            return;
        }
        if(s.charAt(idx)>='0'&&s.charAt(idx)<='9')
            backtrack(s,idx+1,asf+s.charAt(idx),ans);
        else{
            char ch = s.charAt(idx);
            char ch1 = Character.toUpperCase(ch);
            char ch2 = Character.toLowerCase(ch);
            backtrack(s,idx+1,asf+ch1,ans);
            backtrack(s,idx+1,asf+ch2,ans);
        }
    }
}