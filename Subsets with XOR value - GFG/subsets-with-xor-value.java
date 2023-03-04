//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int helper(int []arr,int n,int k){
        if(n==0){
            if(k==0)
            return 1;
            else 
            return 0;
        }
        int taken = helper(arr,n-1,k^arr[n-1]);
        int notTaken = helper(arr,n-1,k);
        return taken+notTaken;
    }
    static int subsetXOR(int arr[], int N, int K) {
            return helper(arr,N,K);
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] =s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.subsetXOR(arr,N,K));
        }
    }
}
// } Driver Code Ends