class Solution {
    public int characterReplacement(String s, int k) {
        int arr[] = new int[26];
        int ans = 0;
        int max = 0;
        int i=0;
        StringBuilder str = new StringBuilder(s);
        for(int j=0;j<str.length();j++){
            arr[str.charAt(j)-'A']++;
            max = Math.max(max,arr[str.charAt(j)-'A']);
            if(j-i+1-max>k){
                arr[str.charAt(i)-'A']--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }
}