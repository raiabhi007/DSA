class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
         int x = n-1;
        return (n&x) == 0;
    }
}