// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends
class GFG 
{ 
    static int largestSum(int arr[], int N){
      int maxSum = arr[0];
      int curSum = arr[0];
      
      for(int i=1;i<N;i++){
          if(arr[i-1]<arr[i])
              curSum+=arr[i];
              else
              curSum = arr[i];
          if(curSum>maxSum)
          maxSum = curSum;
      }
      return maxSum;
    }
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int N=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int arr[]=new int[N];
		    for(int i=0;i<N;i++)
		    {
		        arr[i]=Integer.parseInt(a1[i]);
		    }
		    GFG ob=new GFG();
		    int ans=ob.largestSum(arr,N);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends