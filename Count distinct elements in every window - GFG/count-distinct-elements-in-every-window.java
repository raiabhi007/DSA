//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
      ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
       ArrayList<Integer> list = new ArrayList<>();
       HashMap<Integer,Integer> hmap = new HashMap<>();
       
       for(int i=0;i<k;i++){
           Integer c = hmap.get(A[i]);
           if(hmap.get(A[i])==null)
           hmap.put(A[i],1);
           else
           hmap.put(A[i],++c);
       }
       
       list.add(hmap.size());
       for(int i=k;i<n;i++){
           Integer c = hmap.get(A[i-k]);
           
           if(hmap.get(A[i-k])==1)
           hmap.remove(A[i-k]);
           else
           hmap.put(A[i-k],--c);
           
          Integer a = hmap.get(A[i]); 
         if(!hmap.containsKey(A[i]))
         hmap.put(A[i],1);
         else
         hmap.put(A[i],++a);
         list.add(hmap.size());
       }
       return list;
    }
}

