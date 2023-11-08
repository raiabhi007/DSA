class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx==fx&&sy==fy&&t==1)return false;
        int dif1 = Math.abs(sx-fx);
        int dif2 = Math.abs(sy-fy);
        if(dif1>t||dif2>t) return false;
        return true;
    }
}