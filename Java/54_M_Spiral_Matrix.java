class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0)
            return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int left = 0;
        int bottom = m-1;
        int right = n-1;
        
        while (true)
        {
            // left to right. increase col. finally increase top as current row is done
            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            top++;
            
            // top to bottom. increase row. reduce right
            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;
            
            // Condition
            if (left > right || top > bottom)
                break;
            
            // right to left. decrease col. decrease bottom
            for (int i = right; i >= left; i--)
                res.add(matrix[bottom][i]);
            bottom--;
            
            // bottom to top. decrease row. inc left
            for (int i = bottom; i >= top; i--)
                res.add(matrix[i][left]);
            left++;
            
            // Condition
            if (left > right || top > bottom)
                break;
        }
        return res;
    }
}