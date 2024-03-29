class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
       int number1 = -1,number2=-1,count1 = 0,count2=0;
        for(int i=0;i<n;i++){
            if(number1==nums[i])
                count1++;
            else if(number2==nums[i])
                count2++;
            else if(count1==0){
                number1 = nums[i];
                count1 = 1;
            }else if(count2==0){
                number2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(number1==nums[i]){
                count1++;
            }else if(number2==nums[i])
                count2++;
        }
        if(count1>nums.length/3)
            ans.add(number1);
        if(count2>nums.length/3)
            ans.add(number2);
        return ans;
    }
}