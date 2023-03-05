//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int merge(int[] nums,int low,int mid,int high){
        int count = 0;
        int j = mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high&&nums[i]>(2 * (long) nums[j])){
                j++;
            }
            count+=(j-(mid+1));
        }
             ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low, right = mid+1; 
        while(left <= mid && right<=high) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]); 
            }
            else {
                temp.add(nums[right++]); 
            }
        }
        
        while(left<=mid) {
            temp.add(nums[left++]); 
        }
        while(right<=high) {
            temp.add(nums[right++]); 
        }
        
        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i - low); 
        }
        return count; 
    }
    int mergeSort(int[] arr,int low,int high){
        if(low>=high)
            return 0;
        int mid = (low+high)/2;
        int pair = 0;
        pair+=mergeSort(arr,low,mid);
        pair+=mergeSort(arr,mid+1,high);
        pair+=merge(arr,low,mid,high);
        return pair;
    }
    public int countRevPairs(int N, int arr[]) {
        return mergeSort(arr,0,N-1);
    }
}