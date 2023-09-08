//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    static int st[];
    
    public static int[] constructST(int arr[], int n)
    {
        st = new int[4*n];
        constructSTHelper(0,n-1,0,arr);
        return st;
    }
    public static int constructSTHelper(int ss,int se,int si,int[] arr){
        if(ss==se){
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = (ss+se)/2;
        int l=constructSTHelper(ss,mid,2*si+1,arr);
        int r=constructSTHelper(mid+1,se,2*si+2,arr);
        st[si] = Math.min(l,r);
        return st[si];
    }
    
    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r){
      return getMin(l,r,0,n-1,0);
    }
    public static int getMin(int qs,int qe,int ss,int se,int si){
        if(se<qs||ss>qe) return Integer.MAX_VALUE;
        if(qs<=ss&&qe>=se) return st[si];
        int mid = (ss+se)/2;
        int l = getMin(qs,qe,ss,mid,2*si+1);
        int r = getMin(qs,qe,mid+1,se,2*si+2);
        return Math.min(l,r);
    }
    
    
}