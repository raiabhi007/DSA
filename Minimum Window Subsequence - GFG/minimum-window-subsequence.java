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
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String s, String t) {
       
        int sIndex = 0, tIndex = 0, start = -1;
        int m = s.length(), n = t.length(), minLength = m;
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        
        while (sIndex < m) {
            if(ss[sIndex] == tt[tIndex]) { // char match
                if(tIndex++ == n - 1) { // tIndex exhausted, process it
                    int end = sIndex + 1; // mark end of candidate
                    // reset tIndex to 0 and backtrack sIndex to 1st match position
                    tIndex = 0;
                    sIndex = backtrack(ss, tt, sIndex);

                    // record the candidate
                    if (end - sIndex < minLength) {
                        minLength = end - sIndex;
                        start = sIndex;
                    }
                }
            }
            sIndex++;
        }
        return start == -1 ? "" : s.substring(start, start + minLength);
    }
    
    private static int backtrack(char[] ss, char[] tt, int sIndex) {
        for (int i = tt.length - 1; i >= 0; i--) {
            while(ss[sIndex--] != tt[i]);
        }
        return ++sIndex; // sIndex = 1st char match index - 1; ++ to reset
    }
}
