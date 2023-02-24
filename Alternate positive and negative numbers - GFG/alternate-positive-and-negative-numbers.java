//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    void rearrange(int arr[], int n) {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                neg.add(arr[i]);
            }else{
                pos.add(arr[i]);
            }
        }
        boolean flag = false;
        int i = 0;
        for(i=0;i<n;i++){
            if(!flag && pos.size()!=0){
                arr[i] = pos.poll();
                flag = !flag;
            }else if(flag && neg.size()!=0){
                flag = !flag;
                arr[i] = neg.poll();
            }else
            break;
        }
        while(neg.size()!=0){
            arr[i++] = neg.poll();
        }
        while(pos.size()!=0)
        arr[i++] = pos.poll();
    }
}