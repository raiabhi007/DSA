class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int j=0;
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty()&&dq.peekFirst()<i-k+1)
                dq.pollFirst();
            while(!dq.isEmpty()&&nums[i]>nums[dq.peekLast()])
                dq.pollLast();
            dq.offer(i);
            if(i>=k-1)
                ans[j++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}