class Solution {
    public String largestOddNumber(String S) {
        String ans = "";
        for(int i=0;i<S.length();i++){
            int num = S.charAt(i)-'0';
            if((num&1)!=0){
                ans = S.substring(0,i+1);
            }
        }
        return ans;
    }
}