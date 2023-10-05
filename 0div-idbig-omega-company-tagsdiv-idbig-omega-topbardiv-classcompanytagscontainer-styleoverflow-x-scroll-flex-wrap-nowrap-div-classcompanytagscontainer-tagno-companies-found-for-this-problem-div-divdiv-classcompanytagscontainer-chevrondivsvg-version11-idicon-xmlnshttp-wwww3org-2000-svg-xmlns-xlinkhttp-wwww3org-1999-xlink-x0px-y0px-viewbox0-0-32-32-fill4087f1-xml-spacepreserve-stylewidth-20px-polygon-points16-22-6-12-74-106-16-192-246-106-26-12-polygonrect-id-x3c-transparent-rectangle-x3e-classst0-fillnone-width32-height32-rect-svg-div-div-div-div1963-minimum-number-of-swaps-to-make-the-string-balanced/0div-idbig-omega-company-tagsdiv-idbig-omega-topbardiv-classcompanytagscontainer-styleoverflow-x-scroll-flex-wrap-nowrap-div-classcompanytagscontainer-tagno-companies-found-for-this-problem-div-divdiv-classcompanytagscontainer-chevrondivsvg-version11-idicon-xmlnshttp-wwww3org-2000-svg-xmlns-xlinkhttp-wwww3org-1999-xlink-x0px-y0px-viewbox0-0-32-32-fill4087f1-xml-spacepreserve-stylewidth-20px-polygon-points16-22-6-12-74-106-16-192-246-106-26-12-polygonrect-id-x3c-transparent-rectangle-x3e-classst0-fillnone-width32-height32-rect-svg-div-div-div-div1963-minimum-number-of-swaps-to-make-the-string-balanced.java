class Solution {
    public int minSwaps(String s) {
       int extraClosingBracket = 0;
       int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                extraClosingBracket++;
                max = Math.max(extraClosingBracket,max);
            }else
                extraClosingBracket--;
        }
        return (max+1)/2;
    }
}