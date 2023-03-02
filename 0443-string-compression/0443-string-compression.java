class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        int n=chars.length;
        sb.insert(0,chars[0]);
        int c=1;
        for(int i=1;i<n;i++)
        {
            
            char curr=chars[i];
            char prev=chars[i-1];
            if(curr==prev)
            {
                c++;
            }
            else
            {
                if(c>1)
                {
                    sb.append(c);
                    c=1;
                }
                sb.append(curr);
            }

        }
        if(c>1)
        {
            sb.append(c);
        }
        n=sb.length();
        for(int i=0;i<n;i++)
        {
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}