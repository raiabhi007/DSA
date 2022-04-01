// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}// } Driver Code Ends
class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
       long maxSum = 0;
       long curSum = 0;
       int s = 0;
       int start = -1;
       int end = -1;
       for(int i=0;i<n;i++){
           if(a[i]<0){
               curSum = 0;
               s = i+1;
           }
           else
           curSum+=a[i];
           if(curSum>maxSum){
               maxSum = curSum;
               start = s;
               end = i;
           }
           if(curSum==maxSum&&(i-s)>(start-end))
           end = i;
       }
      ArrayList<Integer> ans = new ArrayList<>();
      if(end==-1){
          ans.add(-1);
          return ans;
      }
      for(int i=start;i<=end;i++)
      ans.add(a[i]);
      
      return ans;
    }
}