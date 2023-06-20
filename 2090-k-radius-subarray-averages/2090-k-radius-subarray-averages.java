class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long sum = 0; int[] avgs = new int[n];
        for(int i = 0; i < n; i++){
            if(k-i == -k){
                sum += nums[i];
                break;
            }
            else{
                sum += nums[i];
            }
        }
        
        int total = (2*k)+1;
        for(int i = 0; i < n; i++){
            if((i - k) < 0 || (i+k) > (n-1)){
                avgs[i] = -1;
            }
            else{
                if((i-k) == 0){
                    avgs[i] = (int)(sum/total);
                }
                else{
                    sum = sum + nums[i+k] - nums[i-k-1];
                    avgs[i] = (int)(sum / total);
                }
            }
        }
        return avgs;
    }
}