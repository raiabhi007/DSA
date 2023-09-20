//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] nums, int n) {
         if(nums.length<=2) return nums.length;
        int ans = 2;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                ans = Math.max(ans,2+helper(i,nums[j]-nums[i],nums));
            }
        }
        return ans;
    }
    public int helper(int index,int diff,int[] arr){
        if(index<0) return 0;
        int ans = 0;
        
        for(int j=index-1;j>=0;j--){
            if(arr[index]-arr[j]==diff){
                ans = Math.max(ans,1+helper(j,diff,arr));
            }
        }
        return ans;
    }
}
