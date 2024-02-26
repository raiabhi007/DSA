class Solution {
    public int findTheWinner(int n, int k) {
        int xor = 0;
        for(int i=1;i<=n;i++){
            xor = xor^i;
        }
        HashSet<Integer> set = new HashSet<>();
        int idx = k;
        while(set.size()<n-1){
            if(!set.contains(idx)){
                xor = xor^idx;
                set.add(idx);
                System.out.println(idx);
            }else{
                int c = 0;
                while(c<k){
                    idx++;
                    if(idx>n) idx = idx%n;
                    if(!set.contains(idx)){
                        c++;
                    }
                }
            }
            if(idx>n) idx = idx%n;
        }
        return xor;
    }
}