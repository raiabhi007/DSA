class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                st.push(i);
            }
            else if(chars[i]==')'){
                if(st.isEmpty())
                    chars[i] = '.';
                else
                    st.pop();
            }                
        }
        while(!st.isEmpty())
            chars[st.pop()] = '.';
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='.')
                continue;
            else
                ans.append(chars[i]);
        }
        return ans.toString();
    }
}