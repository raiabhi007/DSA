class Solution {
    int lowerBound(ArrayList<Integer> list,int key){
        int lb = 0;
        int low = 0;
        int high = list.size()-1;
        int mid;
        
        while(low<high){
            mid = (high+low)/2;
            if(key<=list.get(mid)){
                high = mid;
                lb = mid;
            }else
                low = mid+1;
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int len = 1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
                len++;
            }else{
                int idx = lowerBound(list,nums[i]);
                 list.set(idx,nums[i]);
            }
        }
        return len;
    }
}