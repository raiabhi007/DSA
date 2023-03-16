class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){
            if(st.isEmpty()||asteroids[i]>0){
                st.push(asteroids[i]);
            }else{
                if(st.peek()<0)
                    st.push(asteroids[i]);
                else{
                   
                    int temp2 = asteroids[i];
                    while(!st.isEmpty()){
                         int temp1 = st.pop();
                        if(temp1>Math.abs(temp2)){
                        st.push(temp1);
                        break;    
                    }else if(temp1<Math.abs(temp2)){
                            if(st.isEmpty()||st.peek()<0){
                                st.push(temp2);
                                 break;
                            }
                        }else 
                            break;
                    }                
                }
            }
        }
        if(st.isEmpty())
            return new int[0];
        int ans[] = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}