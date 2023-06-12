class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();   
        if (nums.length == 0) { 
            return ans;        
        }
        
        int start = nums[0], end = nums[0];
        for (int n : nums) {
            if (n == start) {
                continue;
            } else if (n == end + 1) {
                end = n;
            } else {
                String interval = (start != end)?
                (start + "->" + end) : (end + "");
                ans.add(interval);  
                start = end = n;
            }
        }
        
        String interval = (start != end)?
        (start + "->" + end) : (end + "");
        ans.add(interval);  

        return ans;     
    }
}