class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=n-1;
        int ans = 1;
        for(i=n-1;i>=1;i--){
            int count=1;
            int temp = k;
            int ele = nums[i];
            int j=i-1;
            while(j>=0&&temp>0){
            if(nums[j]+temp>=ele){
                count++;
                temp = temp-(ele-nums[j]);
            }else
                break;
            j--;
          }
            ans = Math.max(ans,count);
            if(ans>=i)
                break;
        }
        return ans;
    }
}