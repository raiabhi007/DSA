class Solution {
    public String reverseParentheses(String s) {
      Stack<Character> st = new Stack<>();
        int n = s.length();
      for(int i=0;i<n;i++){
          char c = s.charAt(i);
          if(c==')'){
             Queue<Character> q = new LinkedList<>();
              while(st.peek()!='(')
                  q.add(st.pop());
              st.pop();
              while(!q.isEmpty())
                  st.push(q.remove());

          }else
              st.push(c);
      }  
        char[] ans = new char[st.size()];
        int i=st.size()-1;
        while(i>=0)
            ans[i--] = st.pop();
        return new String(ans);
    }
}