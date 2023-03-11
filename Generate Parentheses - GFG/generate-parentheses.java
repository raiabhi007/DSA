//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n){
        List<String> ans = new ArrayList<>();
        helper(n,n,ans,"");
        return ans;
    }
    void helper(int open, int close, List<String> ans, String asf){
        if(open>close)
        return;
        if(open==0&&close==0){
            ans.add(asf);
            return;
        }
        if(open!=0){
            helper(open-1,close,ans,asf+"(");
        }
        helper(open,close-1,ans,asf+")");
    }
}