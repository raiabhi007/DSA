class Solution {
    String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        helper(digits,0,ans,"");
        return ans;
    }
    public void helper(String digits,int idx,List<String> ans,String temp){
        if(idx==digits.length()){
            ans.add(temp);
            return;
        }
        int index = (int)digits.charAt(idx)-'0';
        for(int i=0;i<str[index].length();i++){
            helper(digits,idx+1,ans,temp+str[index].charAt(i));
        }
    }
}