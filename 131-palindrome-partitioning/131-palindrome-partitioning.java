class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        backtrack(s,0,list,ans);
        return ans;
    }
    public void backtrack(String s,int idx,List<String> list, List<List<String>> ans){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx+1;i<=s.length();i++){
            if(isPalindrome(s.substring(idx,i))){
                list.add(s.substring(idx,i));
                backtrack(s,i,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int i=0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}