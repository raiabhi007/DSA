class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s,0,ans,"");
        return ans;
    }
    public void backtrack(String s,int idx,List<String> ans,String asf){
        //base case
        if(idx==s.length()){
            ans.add(asf);
            return;
        }
        char ch = s.charAt(idx);
        int c = ch - '0';
        if(c>=0&&c<=9){
            backtrack(s,idx+1,ans,asf+ch);
        }else if(ch>=97&&ch<=122){
            backtrack(s,idx+1,ans,asf+ch);
            ch =Character.toUpperCase(ch);;
            backtrack(s,idx+1,ans,asf+ch);
        }else{
            backtrack(s,idx+1,ans,asf+ch);
            ch = Character.toLowerCase(ch);
            backtrack(s,idx+1,ans,asf+ch);
        }
    }
}