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
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int n, int groupSize, int hand[]) {
        if(n%groupSize!=0)
            return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        while(map.size()>0){
            int val = map.firstKey();
            for(int i=val;i<val+groupSize;i++){
                if(!map.containsKey(i))
                    return false;
                map.put(i,map.get(i)-1);
                if(map.get(i)==0)
                    map.remove(i);
            }
        }
        return true;
    }
}
