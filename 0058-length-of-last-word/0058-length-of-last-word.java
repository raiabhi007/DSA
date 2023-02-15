class Solution {
    public int lengthOfLastWord(String s) {
         int counter = 0;
        String tmp = s.trim();
        int len = tmp.length();
        for(int i = len-1; i>=0; i--){
            if(tmp.charAt(i)!=' '){
                counter++;
            }else{
                break;
            }
        }

        return counter;
    }
}