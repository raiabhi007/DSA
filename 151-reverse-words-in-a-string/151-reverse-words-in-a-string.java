class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        String str = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==' '){
                if(str=="")
                    continue;
                else
                st.push(str);
                str = "";
            }else
                str+=ch;
        }
        if(str!="")
        st.push(str);
        str = "";
        while(!st.isEmpty()){
            str = str+st.pop();
            if(!st.isEmpty())
                str+=" ";
        }
        return str;
    }
}