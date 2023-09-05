class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    public Node(){
    }
    public boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch,Node node){
        links[ch-'a'] = node;
    }
    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }
}

class Trie{
    private Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))
                node.put(word.charAt(i),new Node());
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean checkIfAllPrefixExists(String word){
        Node node = root;
        boolean fl = true;
        for(int i=0;i<word.length()&&fl;i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                fl = fl&&node.isEnd();
            }else
                return false;
        }
        return fl;
    }
}
class Solution {
    public String longestWord(String[] words) {
        Trie obj = new Trie();
        for(int i=0;i<words.length;i++) obj.insert(words[i]);
        String longest = "";
        for(String word:words){
            if(obj.checkIfAllPrefixExists(word)){
                if(word.length()>longest.length())
                    longest = word;
                else if(word.length()==longest.length()&&word.compareTo(longest)<0)
                    longest = word;
            }
        }
        return longest;
    }
}