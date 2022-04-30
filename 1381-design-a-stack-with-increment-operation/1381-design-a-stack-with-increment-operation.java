class CustomStack {
    private int stack[];
    private int size;
    private int index;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = maxSize;
        int index = 0;
    }
    
    public void push(int x) {
        if(index<size)
            stack[index++] = x;
    }
    public int pop() {
        if(index==0)
            return -1;
        index--;
        int poppedElement = stack[index];
        return poppedElement;
    }    
    public void increment(int k, int val) {
        if(index==0)
            return;
        for(int i=0;i<index&&i<k;i++)
            stack[i]+=val;        
     }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */