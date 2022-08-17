class Solution {
    public String getHappyString(int n, int k) {
        ArrayList<String> list = new ArrayList<>();
        helper(n,k,"",list);
        if(list.size()<k)
            return "";
        return list.get(k-1);            
    }
    public void helper(int n,int k,String asf,ArrayList<String> list){
        if(n==0){
            list.add(asf);
            return;
        }
        if(asf.equals("")){
            helper(n-1,k,asf+"a",list);
            helper(n-1,k,asf+"b",list);
            helper(n-1,k,asf+"c",list);
            return;
        }
        if(asf.charAt(asf.length()-1)!='a'){
            helper(n-1,k,asf+"a",list);
        }
         if(asf.charAt(asf.length()-1)!='b'){
            helper(n-1,k,asf+"b",list);
        }
         if(asf.charAt(asf.length()-1)!='c'){
            helper(n-1,k,asf+"c",list);
        }
        
    }
}