class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if (matrix == null)
            return 0;
        
        int n = matrix.length;
        
        if (n == 0)
            return 0;
        
        int m = matrix[0].length;
        
        // Clone the int[][]
        int[][] clone = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                clone[i][j] = matrix[i][j] - '0';
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // Skip the first row and col
                if (i == 0 || j == 0)
                {
                    // This is repeated below as well
                    // Need this if there is only one value in the matrix
                    if (clone[i][j] > result)
                        result = clone[i][j];
                    
                    continue;
                }
                
                // get the min of up, left anf up-left and add 1 to it. This is the answer
                if (matrix[i][j] - '0' > 0)
                {
                    clone[i][j] = 1 + Math.min(clone[i][j-1], Math.min(clone[i-1][j-1], clone[i-1][j]));
                }
                
                if (clone[i][j] > result)
                    result = clone[i][j];
            }
        }
        
        return result*result;
    }
}