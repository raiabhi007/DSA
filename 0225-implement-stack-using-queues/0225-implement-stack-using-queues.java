class MyStack {
    Queue<Integer> q; 
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        while(!q.isEmpty())
            temp.add(q.poll());
        q.add(x);
        while(!temp.isEmpty())
            q.add(temp.poll());
    }
    
    public int pop() {
        if(empty())
            return -1;
        return q.poll();
    }
    
    public int top() {
        if(empty())
            return -1;
        return q.peek();
    }
    
    public boolean empty() {
        return q.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */