class Solution {
    public boolean judgeSquareSum(int c) {
       long low = 0;
        long high =  (long)Math.sqrt(c);
        while(low<=high){
            long mid = low*low + high*high;
            if(mid==(long)c){
                return true;
            }else if(mid>(long)c){
                high--;
            }else{
                low++;
            }
        }
        return false; 
    }
}