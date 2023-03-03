class Solution {
    public int strStr(String S, String pat) {
        if(S.length()<pat.length())
            return -1;
        int d = 256;
        int q = 101;
    int m = pat.length();
    int n = S.length();
    int i, j;
    int p = 0;
    int t = 0;
    int h = 1;
    for (i=0;i<m-1;i++)
      h=(h*d)%q;
    // Calculate hash value for pattern and text
    for (i=0;i<m;i++) {
      p = (d*p+pat.charAt(i))%q;
      t = (d*t+S.charAt(i))%q;
    }
    // Find the match
    for (i=0;i<= n-m;i++) {
      if (p==t) {
        for (j=0;j<m;j++) {
          if (S.charAt(i + j) != pat.charAt(j))
            break;
        }
        if (j == m)
          return i;
      }
      if (i<n-m) {
        t = (d*(t-S.charAt(i)*h)+S.charAt(i + m)) % q;
        if (t<0)
          t = (t+q);
         }
       }
        return -1;
    }
}