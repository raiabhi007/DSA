class Solution {
    public int minStoneSum(int[] piles, int k) {
 //create a max priorityqueue       
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

//add all the piles elements to the priorityqueue
        for(int i = 0; i < piles.length; i++){
            pQueue.add(piles[i]);
        }

//do the required calculation
        for(int i = 0; i < k; i++){
            int temp = pQueue.peek()-(int)Math.floor(pQueue.peek()/2);
            pQueue.remove();
            pQueue.add(temp);
        }
// add the elemnet of priorityqueue        
        int ans = 0;
        while(pQueue.size()>0){
         ans += pQueue.remove();
        }
        return ans;
    }
}