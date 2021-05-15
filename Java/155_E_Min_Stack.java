class MinStack {

    Stack<int[]> st;
    
    /** initialize your data structure here. */
    public MinStack() {
        
        st = new Stack<>();
        
    }
    
    public void push(int x) {
        
        if (st.isEmpty())
            st.push(new int[]{x,x});
        else
        {
            int currMin = st.peek()[1];
            st.push(new int[]{x, Math.min(x, currMin)});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */