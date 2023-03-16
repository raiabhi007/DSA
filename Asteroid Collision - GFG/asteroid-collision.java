//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
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
