//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int A[], int N, int target){
        Map<Integer, Integer> presum = new HashMap<>();
	//Prefix sum
        int sum = 0;
	//Answer
        int total = 0;
        for (int i = 0; i < A.length; i++){
            sum += A[i];
            if (presum.get(sum - target) != null){
                total += presum.get(sum - target);
            }
            if (sum == target) total++;
            //Also put this sum into the map as well
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
        }
        
        return total;
    }
}