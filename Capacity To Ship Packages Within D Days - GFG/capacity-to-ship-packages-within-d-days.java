//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] weights, int N, int days) {
         int low = 1;
        int high = 0;
        for(int i=0;i<weights.length;i++)
            high+=weights[i];
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(weights,days,mid)){
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        return ans;
    }
     public static boolean isPossible(int arr[], int days,int minCapacity){
        int minDays = 1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(minCapacity<arr[i])
                return false;
            if(sum+arr[i]>minCapacity){
                sum = arr[i];
                minDays++;
            }else
                sum+=arr[i];
        }
        if(minDays<=days)
            return true;
        return false;
    }
};