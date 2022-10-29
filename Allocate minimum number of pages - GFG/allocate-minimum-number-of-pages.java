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

class Solution 
{
    static boolean isPossible(int[] arr,int students,int pages){
        int count = 0;
        int sumAllocated = 0;
        for(int i=0;i<arr.length;i++){
            if(sumAllocated+arr[i]>pages){
                count++;
                sumAllocated = arr[i];
                if(arr[i]>pages) return false;
            }else
            sumAllocated+=arr[i];
        }
        if(count<students)
        return true;
        return false;
    }
    public static int findPages(int[] arr,int N,int M)
    {
        if(M>N)
        return -1;
        int low = 0;
        int high  = 0;
        int res = 0;
        for(int i=0;i<N;i++){
            low = Math.min(low,arr[i]);
            high+=arr[i];
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(arr,M,mid)){
                res = mid;
                high = mid-1;
            }else
            low = mid+1;
        }
        //res is also an answer
        return low;
    }
};