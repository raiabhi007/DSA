// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends
class Solution{
    static int circularSubarraySum(int a[], int n) {
        int minStraightSum = Integer.MAX_VALUE;
        int maxStraightSum = Integer.MIN_VALUE;
        int arraySum = 0;
        
        int tempMinSum = 0;
        int tempMaxSum = 0;
        
        for(int i=0;i<n;i++){
            arraySum+=a[i];
            tempMaxSum+=a[i];
            if(tempMaxSum>maxStraightSum)
            maxStraightSum = tempMaxSum;
            if(tempMaxSum<0)
            tempMaxSum = 0;
            
            tempMinSum+=a[i];
            if(tempMinSum<minStraightSum)
            minStraightSum = tempMinSum;
            if(tempMinSum>0)
            tempMinSum = 0;
        }
        if(arraySum==minStraightSum)
        return maxStraightSum;
        
        return Math.max(maxStraightSum,(arraySum-minStraightSum));
        
    }
    
}

