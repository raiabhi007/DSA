class Solution {
    public String removeDuplicates(String S) {
        char[] ch = new char[S.length()];
        int i = 0;
        
        for(int j = 0; j < S.length(); j++){
            if(i > 0 && ch[i - 1] == S.charAt(j)){
                i--;
            }
            else{
                ch[i] = S.charAt(j);
                i++;
            }
        }
        return new String(ch, 0, i);
    }
}