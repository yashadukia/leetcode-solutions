class Solution {
    public void setZeroes(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0)
            return;
        
        Set<Integer> rows = new HashSet();
        Set<Integer> cols = new HashSet();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // Iterate over cols keeping row constant. Notice the use of "n"
        for (int r: rows)
        {
            for (int i = 0; i < n; i++)
                matrix[r][i] = 0;
        }
        // Iterate over rows keeping cols constant. Notice the use of "m"
        for (int c: cols)
        {
            for (int i = 0; i < m; i++)
                matrix[i][c] = 0;
        }
    }
}