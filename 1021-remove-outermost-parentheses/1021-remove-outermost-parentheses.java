class Solution {
    public String removeOuterParentheses(String S) {
       String ans = "";
        int open = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                if(open!=0)
                    ans+=S.charAt(i);
                open++;
            }else{
                open--;
                if(open!=0)
                    ans+=S.charAt(i);
            }
        }
        return ans;
    }
}