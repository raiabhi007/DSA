class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum^nums[i];
        }
        int temp = sum;
        int pos = 0;
        while(temp!=0){
            if((temp&1)>0){
                break;
            }
            pos++;
            temp = temp>>1;
        }
        int filter=0;
        for(int i=0;i<n;i++){
            if((nums[i]&(1<<pos))>0){
                filter = filter^nums[i];
            }
        }
        int[] ans = new int[2];
        ans[0] = filter;
        ans[1] = sum^filter;
        return ans;
    }
}