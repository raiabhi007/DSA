//{ Driver Code Starts
// Initial Template for Java

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

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends

class Solution {
	public static int totalFruits(int N, int[] tree) {
	 int[] cnt = new int[tree.length+10];
        int res = 0;
        int k = 2;
        for(int i=0, j=0; j<tree.length; j++) {
            if(cnt[tree[j]]++ == 0) {
                k--;
            }
            while(k < 0) {
                if(--cnt[tree[i++]] == 0) {
                    k++;
                }
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
	}
}