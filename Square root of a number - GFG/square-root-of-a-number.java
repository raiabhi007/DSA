//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
     long floorSqrt(long x)
	 {
		long low=1;
		long high = x;
		long ans = -1;
		while(low<=high){
		long mid = (low+high)/2;
		long mqr = mid*mid;
		if(mqr == x)
		return mid;
		else if(mqr>x)
		    high = mid-1;
		    else{
		     low = mid+1;
		     ans = mid;
		    }
		} 
		return ans;    
	 }
}
