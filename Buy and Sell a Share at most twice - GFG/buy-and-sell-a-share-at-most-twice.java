//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] arr) {
        int[] dpl = new int[n];
        int leastsf = arr[0];
        for(int i=1;i<n;i++){
            if(leastsf>arr[i])
                leastsf = arr[i];
            dpl[i] = Math.max(dpl[i-1],arr[i]-leastsf);
        }
        int max = arr[n-1];
        int[] dpr = new int[n];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>max)
                max = arr[i];
            dpr[i] = Math.max(dpr[i+1],max-arr[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++)
            ans = Math.max(dpr[i]+dpl[i],ans);
        return ans;
    }
}
        
