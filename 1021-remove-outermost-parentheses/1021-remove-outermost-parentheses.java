class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st =  new Stack<>();
        String ans = "";
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(ch);
                if(st.size()>1)
                    ans = ans+'(';
            }
            else{
                if(st.size()>1)
                    ans = ans+')';
                st.pop();
            }
        }
        return ans;
    }
}