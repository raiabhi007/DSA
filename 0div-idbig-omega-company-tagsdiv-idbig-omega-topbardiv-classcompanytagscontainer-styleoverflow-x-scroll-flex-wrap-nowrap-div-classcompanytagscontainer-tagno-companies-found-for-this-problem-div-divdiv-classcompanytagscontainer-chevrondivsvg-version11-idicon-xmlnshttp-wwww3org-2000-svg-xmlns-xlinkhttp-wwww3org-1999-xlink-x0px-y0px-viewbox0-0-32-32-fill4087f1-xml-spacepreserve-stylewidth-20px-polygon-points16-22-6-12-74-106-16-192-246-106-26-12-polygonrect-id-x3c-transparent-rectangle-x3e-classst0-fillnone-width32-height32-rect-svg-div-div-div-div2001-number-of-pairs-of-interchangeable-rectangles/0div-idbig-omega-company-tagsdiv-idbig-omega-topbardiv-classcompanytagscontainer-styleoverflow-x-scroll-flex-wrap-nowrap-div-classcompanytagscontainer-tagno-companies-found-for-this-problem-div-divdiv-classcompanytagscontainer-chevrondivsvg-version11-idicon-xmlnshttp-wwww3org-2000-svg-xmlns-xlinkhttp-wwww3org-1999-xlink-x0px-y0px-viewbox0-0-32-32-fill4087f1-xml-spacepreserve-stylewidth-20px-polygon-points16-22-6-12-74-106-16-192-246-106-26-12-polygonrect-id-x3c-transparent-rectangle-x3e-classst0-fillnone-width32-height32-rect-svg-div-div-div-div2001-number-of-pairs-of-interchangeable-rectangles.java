class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Long> map = new HashMap<>();
        long ans = 0;
        double w = rectangles[0][0];
        double h = rectangles[0][1];
        long a = (long)1;
        map.put(w/h,a);
        
        for(int i=1;i<rectangles.length;i++){
            w = rectangles[i][0];
            h = rectangles[i][1];
            double diff = (w/h);
            System.out.println(diff);
            if(map.containsKey(diff)){
               ans+=map.get(diff);
                map.put(diff,map.get(diff)+1);
                
            }else
                map.put(diff,a);
        }
        return ans;
    }
}