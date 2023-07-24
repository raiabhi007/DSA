class Solution {
    public int lowerbound(ArrayList<Integer> list,int key){
        int low=0;
        int high = list.size()-1;
        while(low<high){
            int mid = (low+high)/2;
            if(list.get(mid)>=key){
                high = mid;
            }else
                low = mid+1;
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int len = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>list.get(len-1)){
                list.add(nums[i]);
                len++;
            }else{
                int lb = lowerbound(list,nums[i]);
                list.set(lb,nums[i]);
            }
        }
        return len;
    }
}