class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class MyHashSet {
    ListNode[] hash;
    public MyHashSet() {
        hash = new ListNode[10000];
    }
    
    public void add(int key) {
        int idx = key%10000;
        
        if(hash[idx]==null){
            hash[idx] = new ListNode(key);
            return;
        } 
        ListNode node = hash[idx];
        boolean flag=false;
        while(node.next!=null){
            if(node.val==key) flag = true;
            node = node.next;
        }
        if(node.val==key) flag = true;
            if(flag) return;
        node.next = new ListNode(key);
    }
    
    public void remove(int key){
        int idx = key%10000;
        if(hash[idx]==null) return;
        
        if(hash[idx].val==key){
            hash[idx] = hash[idx].next;
            return;
        } 
        ListNode prev = hash[idx];
        ListNode cur = hash[idx].next;
        while(cur!=null){
            if(cur.val==key){
                prev.next = cur.next;
                break;
            }
            cur = cur.next;
            prev = prev.next;
        }
    }
    
    public boolean contains(int key) {
        int idx = key%10000;
        if(hash[idx]==null) return false;
        ListNode node = hash[idx];
        while(node!=null){
            if(node.val==key) return true;
             node = node.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */