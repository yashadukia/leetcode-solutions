class Solution {
    public int trap(int[] height) {
        
        int ans = 0;
        int curr = 0;
        Stack<Integer> st = new Stack<>();
        
        for (int x: height)
        {
            while (!st.isEmpty() && x > height[st.peek()])
            {
                int top = st.pop();
                
                if (st.isEmpty())
                    break;
                
                int dist = curr - st.peek() - 1;
                int bounded_area = Math.min(x, height[st.peek()]) - height[top];
                ans += dist * bounded_area;
            }
            st.push(curr);
            curr++;
        }
        return ans;
    }
}