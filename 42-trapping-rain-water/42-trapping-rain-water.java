class Solution {
    public int trap(int[] height) {
       int L = 0;
       int R = height.length-1;
       int leftMax = height[0],rightMax = height[R];
       int res=0;
        while(L<=R){
            if(leftMax<rightMax){
                leftMax = Math.max(leftMax,height[L]);
                res+=(leftMax-height[L]);
                L++;
            }else{
                rightMax = Math.max(rightMax,height[R]);
                res+=(rightMax-height[R]);
                R--;
            }
        }
        return res;
    }
}