class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                for(int j=i+1;j<n-2;j++){
                    if(j==i+1||(j>i+1&&nums[j]!=nums[j-1])){
                    int k = j+1;
                    int l = n-1;
                    while(k<l){                        
                        long sum = (long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l];
                        if(sum==(long)target){
                            list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            while(k<l&&nums[k]==nums[k+1]) k++;
                            while(k<l&&nums[l]==nums[l-1]) l--;
                            k++;
                            l--;
                          }
                        else if(sum>target)
                            l--;
                        else
                            k++;
                        }
                    }
                }
            }
        }
        return list;
    }
}