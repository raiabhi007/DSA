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

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] arr, int threshold) {
        int low = 1;
        int high = (int)Math.pow(10,9);
        int ans = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                int temp = arr[i]/mid;
                if(arr[i]%mid!=0)
                    temp+=1;
                sum+=temp;
            }
            if(sum<=threshold){
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        return ans;
    }
}