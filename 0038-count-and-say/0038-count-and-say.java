class Solution {
    public String countAndSay(int n) {
        String ans = "";
        for(int i = 1; i <= n; i++){
            if(i == 1){
                ans += "1";
            }
            else {
                ans = say(ans);    
            }
        }
        return ans;
    }
    
    public static String say(String s){
        String ans = "";
        int i = 0, j = 0;
        while(i < s.length()){
            while(j < s.length() && s.charAt(i) == s.charAt(j)){
                j++;
            }
            ans += (j-i) + String.valueOf(s.charAt(i));
            i = j;
        }
        return ans;
    }
}