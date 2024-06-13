class Solution {
    public void nextPermutation(int[] nums) {
        int mark = -1;
        int n = nums.length;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                mark = i-1;
                break;
            }
        }
        if(mark==-1){
            reverse(nums,0,n-1);
            return;
        }
        int idx = n-1;
        for(int i=n-1;i>mark;i--){
            if(nums[i]>nums[mark]){
                idx = i;
                break;
            }
        }
        swap(nums,mark,idx);
        reverse(nums,mark+1,n-1);
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}