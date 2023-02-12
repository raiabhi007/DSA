//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends

class Solution {
    static ArrayList<Integer> factorial(int N){
        ArrayList <Integer> arr= new ArrayList <>();
        arr.add(1);
        for(int i=1; i<=N; i++){
            int carry=0;
         
            for(int j=arr.size()-1; j>=0; j--){
                int val=arr.get(j)*i+carry;
                arr.set(j,val%10);
                carry=val/10;
            }
            while(carry!=0){
                arr.add(0,carry%10);
                carry=carry/10;
            }
        }
        return arr;
    }
}