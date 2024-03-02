class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=n-1;
        int k=n-1;
        int[] ans = new int[n];
       for(int a=0;a<n;a++)
    nums[a] = nums[a]*nums[a];   

        while(k>=0){
         while(j>=i){
           if(nums[i]>nums[j])
               ans[k--] = nums[i++];
           else
               ans[k--] = nums[j--];
          }
        }
        return ans;
    }
    
}