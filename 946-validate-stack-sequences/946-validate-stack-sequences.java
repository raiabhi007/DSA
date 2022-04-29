class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0,j=0;
        Stack<Integer> st = new Stack<>();
        while(i<pushed.length){
            if(pushed[i]==popped[j]){
                i++;
                j++;
            }
            while(!st.isEmpty()&&st.peek()==popped[j]){
                j++;
                st.pop();
            }
            if(i==pushed.length)
                break;
            st.push(pushed[i]);
            i++;
        }
         while(!st.isEmpty()&&st.peek()==popped[j]){
                j++;
                st.pop();
            }
        return i==j&&st.isEmpty();
    }
}