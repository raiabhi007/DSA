//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends

class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        solve(arr,0,0,ans);
        return ans;
    }
    void solve(ArrayList<Integer> arr, int i,int sum,ArrayList<Integer> ans){
        if(arr.size()==i){
            ans.add(sum);
            return;
        }
        solve(arr,i+1,sum,ans);
        solve(arr,i+1,sum+arr.get(i),ans);
    }
}