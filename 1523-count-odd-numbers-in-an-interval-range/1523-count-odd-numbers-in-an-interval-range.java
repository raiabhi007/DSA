class Solution {
    public int countOdds(int low, int high) {
        if((low&1)!=0||(high&1)!=0){
            return (high-low)/2 + 1;
        }else
            return (high-low)/2;
    }
}