class Solution {
    public String pushDominoes(String dominoes) {
         char[] a = dominoes.toCharArray();
        for (int i = 0, L = -1, R = -1; i <= dominoes.length(); i++)
            if (i == a.length || a[i] == 'R') {
                if (R > L)
                    while (R < i)
                        a[R++] = 'R';
                R = i;
            } else if (a[i] == 'L')
                if (L > R || R == -1)
                    while (++L < i)
                        a[L] = 'L';
                else { 
                    L = i;
                    for (int lo = R + 1, hi = L - 1; lo < hi; ) {
                        a[lo++] = 'R';
                        a[hi--] = 'L';
                    }
                }
        return new String(a);
    }
}