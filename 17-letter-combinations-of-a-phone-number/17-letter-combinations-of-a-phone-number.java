class Solution {
    public String[] codes = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length()==0)
            return list;
        helper(digits,list,"",0);
        return list;
    }
    public void helper(String digits,List<String> list,String word,int n){
        if(n==digits.length()){
            list.add(word);
            return;
        }
        int num = digits.charAt(n) - '0';
        for(int i=0;i<codes[num].length();i++){
            char ch = codes[num].charAt(i);
            helper(digits,list,word+ch,n+1);
        }
    }
}