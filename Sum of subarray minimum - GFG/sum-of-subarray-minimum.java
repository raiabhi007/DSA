//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.sumSubarrayMins(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int sumSubarrayMins(int n, int[] arr) {
         int [] prevsmaller=new int[n];
        int [] nextsmaller=new int[n];
        final int mod=1000000007;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            prevsmaller[i]=-1;
            nextsmaller[i]=n;
        }
        // finding the next smaller element
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                nextsmaller[i]=stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        // finding the previous smaller element
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){  // here we havent used = sign because it was failing for case [71,55,82,55]. In case of duplicate numbers we consider the first in occurence number as our answer
                stack.pop();
            }
            if(!stack.isEmpty()){
                prevsmaller[i]=stack.peek();
            }
            stack.push(i);
        }
        long res=0;
        for(int i=0;i<n;i++){
            long left= (long)i -prevsmaller[i];
            long right=nextsmaller[i]-(long)i;
            res=(res+ (arr[i]*left*right)%mod)%mod;
        }
        return (int) res;
    }
}
