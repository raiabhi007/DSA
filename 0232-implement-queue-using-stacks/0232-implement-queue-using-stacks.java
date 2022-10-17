class MyQueue {
    private Stack<Integer> st1;
    
    public MyQueue() {
        st1 = new Stack<>();
    }
    
    public void push(int x) {
        Stack<Integer> st2 = new Stack<>();
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st2.push(x);
        while(!st2.isEmpty())
            st1.push(st2.pop());
        
    }
    
    public int pop() {
        if(empty())
            return -1;
        return st1.pop();
    }
    
    public int peek() {
        if(empty())
            return -1;
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */