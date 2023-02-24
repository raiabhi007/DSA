class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n % 2 == 0) {
                maxHeap.add(n);
                min = Math.min(min, n);
            }

            else {
                maxHeap.add(n * 2);
                min = Math.min(min, n * 2);
            }
        }

        int ans = Integer.MAX_VALUE;

        while (!maxHeap.isEmpty()) {
            int number = maxHeap.poll();
            ans = Math.min(ans, number - min);

            if (number % 2 != 0) break;

            min = Math.min(min, number / 2);
            maxHeap.add(number / 2);
        }

        return ans;
    }
}