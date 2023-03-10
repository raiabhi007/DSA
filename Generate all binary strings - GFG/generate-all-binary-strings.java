//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
      List<String> list = new ArrayList<>();
      helper(n,list,"");
      return list;
  }
  public static void helper(int n, List<String> list, String asf){
      if(n==0){
          list.add(asf);
          return;
      }
      helper(n-1,list,asf+"0");
      if(asf.length()==0||asf.charAt(asf.length()-1)!='1')
      helper(n-1,list,asf+"1");
  }
}
     
     