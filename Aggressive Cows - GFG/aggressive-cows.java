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

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


// User function Template for Java
class Solution {
    public static boolean isPossible(int arr[],int cows,int  minDist){
        int countCows = 1;
        int lastPlacedCow = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-lastPlacedCow>=minDist){
                countCows++;
                lastPlacedCow = arr[i];
            }
        }
        if(countCows>=cows) return true;
        return false;
    }
    public static int solve(int n, int k, int[] arr) {
        if(k>n)
        return -1;
        Arrays.sort(arr);
        int low = 1,high=arr[n-1]-arr[0];
        while(low<=high){
            int mid = low +(high-low)/2;
            if(isPossible(arr,k,mid)){
                low = mid+1;
            }else
            high = mid-1;
        }
        return high;
    }
}