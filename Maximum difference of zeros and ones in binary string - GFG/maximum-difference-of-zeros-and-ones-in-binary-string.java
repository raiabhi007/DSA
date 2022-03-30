// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}// } Driver Code Ends

class Solution {
    int maxSubstring(String S) {
        int diff = -1;
        int ones = 0;
        int zeroes = 0;
        int maxDifference = -1;
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='0')
            zeroes+=1;
            else
            ones+=1;
            diff = zeroes - ones;
            if(diff>maxDifference)
            maxDifference = diff;
            if(ones>zeroes){
            ones = 0;
            zeroes = 0;
            }
        }
        return maxDifference;
    }
}