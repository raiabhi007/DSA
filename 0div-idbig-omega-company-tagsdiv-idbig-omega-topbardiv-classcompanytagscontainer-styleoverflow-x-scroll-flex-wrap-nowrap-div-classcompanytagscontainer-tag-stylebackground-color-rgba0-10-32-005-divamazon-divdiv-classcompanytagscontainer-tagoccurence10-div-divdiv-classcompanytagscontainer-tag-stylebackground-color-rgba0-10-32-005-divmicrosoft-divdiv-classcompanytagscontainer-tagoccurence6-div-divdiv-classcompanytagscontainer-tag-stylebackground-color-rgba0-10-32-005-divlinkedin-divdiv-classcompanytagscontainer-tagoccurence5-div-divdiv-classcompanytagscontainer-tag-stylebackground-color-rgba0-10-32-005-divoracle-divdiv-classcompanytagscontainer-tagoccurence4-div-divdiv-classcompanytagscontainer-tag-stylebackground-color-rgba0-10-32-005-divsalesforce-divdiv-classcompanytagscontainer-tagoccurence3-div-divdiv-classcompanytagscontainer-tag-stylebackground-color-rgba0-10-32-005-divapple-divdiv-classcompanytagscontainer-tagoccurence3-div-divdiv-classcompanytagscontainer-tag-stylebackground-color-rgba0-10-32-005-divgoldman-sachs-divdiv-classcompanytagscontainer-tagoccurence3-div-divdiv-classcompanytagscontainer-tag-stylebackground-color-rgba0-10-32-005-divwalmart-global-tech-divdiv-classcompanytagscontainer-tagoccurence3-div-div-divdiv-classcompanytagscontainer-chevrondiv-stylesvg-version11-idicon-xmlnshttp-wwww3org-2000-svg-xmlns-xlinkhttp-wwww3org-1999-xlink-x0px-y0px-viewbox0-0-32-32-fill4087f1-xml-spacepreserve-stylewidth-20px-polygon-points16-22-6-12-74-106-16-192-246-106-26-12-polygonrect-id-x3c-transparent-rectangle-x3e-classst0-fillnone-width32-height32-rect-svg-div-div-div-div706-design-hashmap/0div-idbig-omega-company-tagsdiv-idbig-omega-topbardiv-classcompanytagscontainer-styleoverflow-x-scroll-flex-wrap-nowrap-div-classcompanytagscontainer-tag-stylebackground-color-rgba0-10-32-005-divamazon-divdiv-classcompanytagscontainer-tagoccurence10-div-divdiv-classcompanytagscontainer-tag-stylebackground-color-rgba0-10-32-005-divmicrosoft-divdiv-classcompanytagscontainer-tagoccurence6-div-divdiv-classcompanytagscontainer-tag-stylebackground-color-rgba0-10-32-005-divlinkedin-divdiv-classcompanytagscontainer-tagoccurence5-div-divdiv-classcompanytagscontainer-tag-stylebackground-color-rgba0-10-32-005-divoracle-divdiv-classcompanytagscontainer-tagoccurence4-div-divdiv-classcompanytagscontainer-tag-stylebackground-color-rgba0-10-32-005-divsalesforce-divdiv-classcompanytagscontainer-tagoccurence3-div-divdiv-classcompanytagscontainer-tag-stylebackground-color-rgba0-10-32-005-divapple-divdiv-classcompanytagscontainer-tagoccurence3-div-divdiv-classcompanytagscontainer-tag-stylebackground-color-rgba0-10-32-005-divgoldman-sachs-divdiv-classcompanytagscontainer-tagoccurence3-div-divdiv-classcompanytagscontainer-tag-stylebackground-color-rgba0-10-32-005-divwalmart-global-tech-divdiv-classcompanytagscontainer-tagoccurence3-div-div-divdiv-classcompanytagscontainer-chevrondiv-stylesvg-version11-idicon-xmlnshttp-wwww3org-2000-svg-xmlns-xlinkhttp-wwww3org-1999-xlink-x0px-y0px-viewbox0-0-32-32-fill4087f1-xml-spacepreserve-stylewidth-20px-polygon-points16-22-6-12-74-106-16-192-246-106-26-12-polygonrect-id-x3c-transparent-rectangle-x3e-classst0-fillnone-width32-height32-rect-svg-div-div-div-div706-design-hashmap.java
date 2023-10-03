class ListNode {
      int key;
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int key, int val) { this.val = val; this.key = key; }
  }

class MyHashMap {
    ListNode[] hash;
    public MyHashMap() {
        hash = new ListNode[10000];
    }
    
    public void put(int key, int value) {
        int idx = key%10000;
        if(hash[idx]==null){
            hash[idx] = new ListNode(key,value);
            return;
        }
        ListNode node = hash[idx];
        boolean flag=false;
        while(node.next!=null){
            if(node.key==key){
                flag = true;
                node.val = value;
            }
            node = node.next;
        }
        if(node.key==key){
                flag = true;
                node.val = value;
            }
        if(flag) return;
        node.next = new ListNode(key,value);
    }
    
    public int get(int key) {
       int idx = key%10000;
        
        if(hash[idx]==null) return -1;
        ListNode node = hash[idx];
        while(node!=null){
            if(node.key==key) return node.val;
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = key%10000;
        if(hash[idx]==null) return;
        if(hash[idx].key==key){
            hash[idx] = hash[idx].next;
            return;
        }
        ListNode prev = hash[idx];
        ListNode cur = hash[idx].next;
        while(cur!=null){
            if(cur.key==key){
                prev.next = cur.next;
                break;
            }
            cur = cur.next;
            prev = prev.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */