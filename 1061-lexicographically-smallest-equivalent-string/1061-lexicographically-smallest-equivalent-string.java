class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // ArrayList to store Each group in a hashSet
        ArrayList<HashSet<Character>> l = new ArrayList<>();

        for(int i=0;i<s1.length();i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            // i1 -> stores index of char a in list if present
            // i2 -> stores index of char b in list if present
            int i1 = -1, i2 = -1;
            for(int j=0;j<l.size();j++){
                if(l.get(j).contains(a))i1 = j;
                if(l.get(j).contains(b))i2 = j;
            }
            // If both characters are not in list than, add a new group in list
            if(i1==-1&&i2==-1){
                HashSet<Character> hs = new HashSet<>();
                hs.add(a);
                hs.add(b);
                l.add(hs);
            }else if(i1!=-1&&i2!=-1){
                // If both characters are in list at different groups
                // than add all elements of group2 in group 1 and remove group 2
                if(i1!=i2){
                    l.get(i1).addAll(l.get(i2));
                    l.remove(i2);
                }else{
                    // Nothing to do
                }
            }else if(i1!=-1){ // If char a is present in list, than put char b also in that group
                l.get(i1).add(b);
            }else{// If char b is present in list, than put char a also in that group
                l.get(i2).add(a);
            }
        }
        // Hashmap to with key is character and value = minimum value character present in its group
        HashMap<Character, Character> hs = new HashMap<>();
        for(int i=0;i<l.size();i++){
            // Finding Minimum character in its group
            char min = 'z';
            for(char c: l.get(i))
                if(min>(char)c)min = c;
            // storing character with value = minimum value character present in its group
            for(char c: l.get(i))
                hs.put(c, min);
        }

        // sbr stores the lexicographically smallest equivalent string of baseStr
        StringBuffer sbr = new StringBuffer("");
        for(char c: baseStr.toCharArray()){
            // If the character is present in hashmap
            if(hs.containsKey(c))sbr.append(hs.get(c));
            else sbr.append(c);
        }
        return sbr.toString();
    }
}