//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int findPages(int[]A,int N,int M){
        if(M>N)
        return -1;
        int low = 0;
        int high = 0;
        for(int i=0;i<N;i++){
            low=Math.min(low,A[i]);
            high+=A[i];
        }
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(A,mid,M)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    static boolean isPossible(int arr[],int mid, int M){
        int tempPages=0;
        int totalStudents = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid)
            return false;
            tempPages+=arr[i];
            if(tempPages>mid){
                totalStudents++;
                tempPages = arr[i];
            }
        }
        return totalStudents<M;
    }
};