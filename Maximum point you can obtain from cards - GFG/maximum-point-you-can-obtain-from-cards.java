//{ Driver Code Starts
// Initial Template for Java

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
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long maxScore(int cardPoints[], int N, int k) {
         int len = cardPoints.length;
        int l=0,r=len-k;
        int total = 0;
        for(int i=r;i<len;i++){
            total+=cardPoints[i];
        }
        int res = total;
        while(r<len){
            total+=(cardPoints[l]-cardPoints[r]);
            res = Math.max(res,total);
            l++;
            r++;
        }
        return res;
    }
}
