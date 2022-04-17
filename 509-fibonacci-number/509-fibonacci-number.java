class Solution {
    public int fib(int n) {
        return helper(n,new int[n+1]);
    }
    public int helper(int n,int[] arr){
      if(n==0||n==1)
          return n;
        if(arr[n]!=0)
            return arr[n];
        int ans = helper(n-1,arr) + helper(n-2,arr);
        arr[n] = ans;
        return ans;
    }
}