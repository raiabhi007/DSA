class Solution {
    public String makeGood(String s) {
        if(s.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        while(index<sb.length()-1){
            if(Math.abs(sb.charAt(index)-sb.charAt(index+1))==32){
                sb.deleteCharAt(index);
                sb.deleteCharAt(index);
                index = Math.max(index-1,0);
            }else
                index++;
        }
        return sb.toString();
    }
}