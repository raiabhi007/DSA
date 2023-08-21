class Solution {
    public boolean checkPowersOfThree(int n) {
        return helper(0,n);
    }
    public boolean helper(int p,int n){
        if(n==0) return true;
        if(n<0) return false;
        int power = (int)Math.pow(3,p);
        if(power>n) return false;
        return helper(p+1,n-power)||helper(p+1,n);
    }
}