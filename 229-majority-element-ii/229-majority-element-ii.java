class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                Integer c = map.get(nums[i]);
                map.put(nums[i],++c);
            }else
                map.put(nums[i],1);
        }
        for(int i:map.keySet()){
            if(map.get(i)>nums.length/3)
                ans.add(i);
        }
        return ans;
    }
}