class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        boolean[] prime = new boolean[n+1];
        for(int i=2;i<n;i++){
            if(prime[i]==false){ 
                ans++;
                for(int j=i;j<n&&j>0;j+=i){
                    prime[j] = true;
                }
            }
        }
        return ans;
    }
}