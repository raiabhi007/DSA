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
            
            
            int[] nums = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.Solve(n, nums);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> Solve(int n, int[] nums) {
        int number1 = -1,number2=-1,count1 = 0,count2=0;
        for(int i=0;i<n;i++){
            if(number1==nums[i])
                count1++;
            else if(number2==nums[i])
                count2++;
            else if(count1==0){
                number1 = nums[i];
                count1 = 1;
            }else if(count2==0){
                number2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(number1==nums[i]){
                count1++;
            }else if(number2==nums[i])
                count2++;
        }
        if(count1>nums.length/3)
            ans.add(number1);
        if(count2>nums.length/3)
            ans.add(number2);
            if(ans.isEmpty())
            ans.add(-1);
        return ans;
    }
}
        
