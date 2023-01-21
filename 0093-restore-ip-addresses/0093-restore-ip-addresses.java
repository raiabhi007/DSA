class Solution {
   public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>(); //result list
        restore(s,0,res,"",0);
        return res;
    }

    private void restore(String s,int i,List<String> res,String t,int dots)
    {
        //all characters of string included and no. of dots in restoredIp==3
        if(i==s.length()&&dots==3)
            res.add(t); //adding restoredIp to result

        StringBuilder temp = new StringBuilder();
        for(int idx=i;idx<s.length();idx++){
            temp.append(s.charAt(idx)); 
           //checking for valid conditions.
            if(dots<=3 && isValid(temp.toString())){
                if(idx==s.length()-1)
                    restore(s,idx+1,res,t+temp.toString(),dots); //dot should not be inserted at last
                else
                    restore(s,idx+1,res,t+temp.toString()+'.',dots+1); 
            }
        }
    }

    private boolean isValid(String s){
       //checking for 1st character to not be '0' when len(s)>1
        if(s.length()>1 && s.charAt(0)=='0')
           return false;
       //checking for String value to remain between [0,255]
        if(s.length()>0 && s.length()<4 && Integer.parseInt(s)<256)
           return true;
        return false;
    }
}