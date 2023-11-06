class Solution {
    public int bestClosingTime(String customers) {
        int penY = 0;
        int penN = 0;
        int n = customers.length();
        for(int i=n-1;i>=0;i--){
            if(customers.charAt(i)=='Y')
                penY++;
        }
        int maxScore = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            int temp = n - (penY+penN);
            if(maxScore<temp){
                ans = i;
                maxScore = temp;
            }
            if(customers.charAt(i)=='Y'){
                penY--;
            }
            if(customers.charAt(i)=='N')
                penN++;
            if(i==n-1){
                temp = n-(penY+penN);
                if(maxScore<temp){
                    ans = n;
                    maxScore = temp;
                }
            }
        }
        return ans;
    }
}