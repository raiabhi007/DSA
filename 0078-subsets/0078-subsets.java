class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int end = (int)Math.pow(2,n)-1;
        for(int idx=0;idx<=end;idx++){
            List<Integer> list = new ArrayList<>();
            int temp = idx;
            int pos = 0;
            while(temp!=0){
                if((temp&1)==1){
                    list.add(nums[pos]);
                }
                temp=temp>>1;
                pos++;
            }
            ans.add(list);
        }
        return ans;
    }
}