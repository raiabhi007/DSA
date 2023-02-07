class Solution {
    public int totalFruit(int[] tree) {
        int[] cnt = new int[tree.length];
        int res = 0;
        int k = 2;
        for(int i=0, j=0; j<tree.length; j++) {
            if(cnt[tree[j]]++ == 0) {
                k--;
            }
            while(k < 0) {
                if(--cnt[tree[i++]] == 0) {
                    k++;
                }
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}