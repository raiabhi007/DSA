//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.maxOdd(s));
        }
    }
}
// } Driver Code Ends


class Solution {

    String maxOdd(String S) {
        String ans = "";
        for(int i=0;i<S.length();i++){
            int num = S.charAt(i)-'0';
            if((num&1)!=0){
                ans = S.substring(0,i+1);
            }
        }
        return ans;
    }
}