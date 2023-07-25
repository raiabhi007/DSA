//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        }
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public boolean compare(String s1,String s2){
        if(s1.length()!=1+s2.length()) return false;
        int first=0;
        int second=0;
        while(first<s1.length()){
            if(second<s2.length()&&s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }else
            first++;
        }
        return first==s1.length()&&second==s2.length();
    }
    public int longestChain(int N, String words[]){
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        int dp[] = new int[N];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i=0;i<N;i++){
            for(int prev_index=0;prev_index<i;prev_index++){
                if(compare(words[i],words[prev_index])&&1+dp[prev_index]>dp[i]){
                    dp[i] = 1+dp[prev_index];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}