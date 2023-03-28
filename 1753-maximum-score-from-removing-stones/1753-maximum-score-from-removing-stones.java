class Solution {
    public int maximumScore(int a, int b, int c) {
        int m1=Math.max(Math.max(a,b),c);
        int m3=Math.min(Math.min(a,b),c);
        int m2=a+b+c-m1-m3;
        if(m1-m2>=m3) return m2+m3;
        else return m3+(m1+m2-m3)/2;
    }
}