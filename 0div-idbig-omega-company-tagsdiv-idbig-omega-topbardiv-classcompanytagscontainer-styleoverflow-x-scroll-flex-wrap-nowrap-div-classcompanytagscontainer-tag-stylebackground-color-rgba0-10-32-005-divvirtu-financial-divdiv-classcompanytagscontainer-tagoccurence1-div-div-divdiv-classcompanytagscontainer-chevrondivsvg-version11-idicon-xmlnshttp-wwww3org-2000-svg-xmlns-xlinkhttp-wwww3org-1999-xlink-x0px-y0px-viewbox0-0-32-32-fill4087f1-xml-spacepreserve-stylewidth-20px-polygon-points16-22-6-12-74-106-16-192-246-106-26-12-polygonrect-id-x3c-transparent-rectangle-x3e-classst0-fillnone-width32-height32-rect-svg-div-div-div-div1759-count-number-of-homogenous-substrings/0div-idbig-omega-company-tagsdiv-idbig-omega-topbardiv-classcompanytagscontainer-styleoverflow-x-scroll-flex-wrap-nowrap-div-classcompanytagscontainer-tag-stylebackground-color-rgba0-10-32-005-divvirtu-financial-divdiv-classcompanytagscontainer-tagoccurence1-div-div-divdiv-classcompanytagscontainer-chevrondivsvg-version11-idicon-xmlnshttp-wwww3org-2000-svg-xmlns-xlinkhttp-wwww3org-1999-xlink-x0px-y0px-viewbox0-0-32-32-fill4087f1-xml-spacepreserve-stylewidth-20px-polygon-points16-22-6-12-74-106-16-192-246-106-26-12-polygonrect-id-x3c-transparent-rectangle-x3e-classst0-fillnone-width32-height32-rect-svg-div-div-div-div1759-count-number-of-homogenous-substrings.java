class Solution {
    public int countHomogenous(String s) {
    int cnt = 0, res = 0;
    for (int i = 0; i < s.length(); ++i) {
        if (i > 0 && s.charAt(i - 1) == s.charAt(i))
            ++cnt;
        else
            cnt = 1;
        res = (res + cnt) % 1000000007;
    }
    return res;
}
}