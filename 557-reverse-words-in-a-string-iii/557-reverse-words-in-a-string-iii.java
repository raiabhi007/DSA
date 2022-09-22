class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String ans = "";
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].length()-1;j>=0;j--){
                ans+=arr[i].charAt(j);
            }
            if(i!=arr.length-1)
            ans+=" ";
        }
        return ans;
    }
    
}