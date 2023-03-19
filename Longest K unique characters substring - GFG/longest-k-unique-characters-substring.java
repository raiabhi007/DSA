//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = -1;
        while(j<n){
            char rightChar = s.charAt(j);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            if(map.size()==k)
            ans = Math.max(ans,j-i+1);
            
            while(map.size()>k){
                char leftChar = s.charAt(i);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0)
                map.remove(leftChar);
                i++;
            }
            j++;
        }
        return ans;
    }
}