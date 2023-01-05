class Solution {
   public int findMinArrowShots(int[][] points) {
        // Sort on the basis of 1st index of Balloon's Diameter
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int balloonEnd = points[0][1];
        for(int i = 1; i<points.length; i++){
            // Compare till 1st index(balloonEnd) is not less then 0th index
            if(balloonEnd < points[i][0]){
            // Whenever found, Change the balloonEnd's value to find the range of new Arrow
                balloonEnd = points[i][1];
                count++;
            }
        }
        return count;
    }
}