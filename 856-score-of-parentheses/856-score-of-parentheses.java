class Solution {
    public int scoreOfParentheses(String s) {
       Stack<Integer> st = new Stack<>();
        int n = s.length();
       for(int i=0;i<n;i++){
           if(s.charAt(i)=='('){
               st.push(-1);
           }else{
               if(st.peek()==-1){
                   st.pop();
                   st.push(1);
               }
               else{
                   int temp = 0;
                   while(st.peek()!=-1)
                       temp+=st.pop();
                   st.pop();
                   st.push(2*temp);
               }
           }
       }
        int ans = 0;
        while(st.size()>0)
            ans+=st.pop();
        return ans;
    }
}