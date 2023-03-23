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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    static int minCandy(int N, int ratings[]) {
        int candy[]=new int[N];
        Arrays.fill(candy,1);
        for(int i=1;i<N;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        for(int j=N-2;j>=0;j--){
            if(ratings[j]>ratings[j+1]){
                candy[j]=Math.max(candy[j],candy[j+1]+1);
            }
        }
         int ans=0;
            for(int k: candy){
                ans+=k;
            }
            return ans;
    }
}