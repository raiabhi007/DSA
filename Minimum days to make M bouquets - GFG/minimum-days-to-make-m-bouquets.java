//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int m, int k, int[] bloomDay) 
  {
        //  m*k= Number of flowers required that is should be <= n (bloomDay.length)
        //  k: is also the length of the subarray (flowers for bouquet)
        
        if (m*k> bloomDay.length)
            return -1;
        int ans=-1;
        
        /*  Main Idea: m subarrays (bouquets) of size k, and we need to minimize the maximum value in these sub-arrays
         -> if above condition (m*k> len) is false, we are guaranteed an answer. 
            Also, we know the answer lies between the maximum and minimum value in our bloom-array, and since the answer is guaranteed we can check the feasibility (which means searching will be involved) and depending on that change our search space.
         -> So we might be able to use Binary Search instead of checking for each element of the array.
         
         Let's think*/
         int low=0;
         int high= (int)Math.pow(10,9); // Also can find the max and min values from the array
        
        while (low<=high)
        {
            int mid= low+ (high-low)/2; // Possible result
            
            // Check if it is possible?
            if (isPossible(bloomDay, mid, m, k)){   
                ans= mid;
                high= mid-1; // Lets check for a lesser possible answer
            }
            else
                low= mid+1; // Looks like we can not have m bouquets for this mid
            
        }
        return ans;
       
    }
    // Check for a possible answer (mid): Going through the array and checking if for an assumed answer, can we make more than or equal to required bouquets 
	// [Essentially finding the count of subarrays of size k with all elements less than or equal to mid]
    public static boolean isPossible(int arr[], int mid, int bouquets, int k) 
    {   
        int flowers=0;
        int boqs=0;

        for (int i=0; i<arr.length; i++)
        {
            if (arr[i]>mid) // Implies flower hasn't bloomed so can not be a part of subarray, so count set to 0
                flowers=0; // Since adjacent
            
            else 
            // We need to check if the number of flowers is k(indicates size of curr subarray)
            {
                flowers++; // Count of elements/ flowers in subarray/ bouquets (adjacent)
                if (flowers==k)
                    {
                    boqs++; // Count of bouquets
                    flowers=0; 
                }
                else
                    continue;
            }          
        }
        if (boqs>= bouquets) // We can make m bouquets
            return true;
        else 
            return false;
    }
}