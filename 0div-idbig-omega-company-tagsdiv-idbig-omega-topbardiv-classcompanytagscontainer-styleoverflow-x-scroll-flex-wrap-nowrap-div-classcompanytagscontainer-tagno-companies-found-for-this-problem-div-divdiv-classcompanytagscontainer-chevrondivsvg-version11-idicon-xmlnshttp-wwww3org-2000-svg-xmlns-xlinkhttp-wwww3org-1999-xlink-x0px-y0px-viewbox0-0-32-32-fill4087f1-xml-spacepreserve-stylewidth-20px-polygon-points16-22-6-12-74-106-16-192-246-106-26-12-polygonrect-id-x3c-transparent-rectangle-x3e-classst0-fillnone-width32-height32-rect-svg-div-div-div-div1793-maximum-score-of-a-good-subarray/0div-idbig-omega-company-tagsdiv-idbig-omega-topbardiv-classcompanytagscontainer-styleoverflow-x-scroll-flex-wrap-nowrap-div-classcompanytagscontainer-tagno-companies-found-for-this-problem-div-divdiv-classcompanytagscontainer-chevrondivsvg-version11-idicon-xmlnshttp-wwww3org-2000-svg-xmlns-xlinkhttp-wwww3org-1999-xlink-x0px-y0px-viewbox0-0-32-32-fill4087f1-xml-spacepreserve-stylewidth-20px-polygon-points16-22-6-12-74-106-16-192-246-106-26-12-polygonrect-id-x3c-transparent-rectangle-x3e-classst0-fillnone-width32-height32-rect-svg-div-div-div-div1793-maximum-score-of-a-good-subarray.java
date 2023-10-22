class Solution {
    public int maximumScore(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = nums.length;
        int max = nums[k];

        for(int i = 0; i < n; i++) {
           
            while(stack.peek() != -1 && nums[stack.peek()] >= nums[i]) {
                int currentHeight = nums[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                
                if(stack.peek() < k && i > k){
                    
                    max = Math.max(max, currentHeight * currentWidth);
                    
                }
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            int currentHeight = nums[stack.pop()];
            int currentWidth = n - stack.peek() - 1;
            if(stack.peek() < k){
                
                max = Math.max(max, currentHeight * currentWidth);
                
            }
        }
        return max;
    }
}