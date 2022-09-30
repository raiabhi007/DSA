class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
         List<int[]> height = new ArrayList<>();
        
        for(int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        
        // Sort based on x coordinates 
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });
        List<List<Integer>> res=new ArrayList<>();
         // Create Prioity Queue
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        
        for(int[] h:height) {
            // check if height is negative add height to priority queue
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                // check if height is positive remove from proirty queue
                pq.remove(h[1]);
            }
            // max in priority queue
            int cur = pq.peek();
            // if after adding or removing of height from priority queue 
            // if peek changes then we need to add in output
            if(prev != cur) {
                List<Integer> list=new ArrayList<>();
                list.add(h[0]);
                list.add(cur);

                res.add(list);
                prev = cur;
            }
        }
        return res;
    }
}