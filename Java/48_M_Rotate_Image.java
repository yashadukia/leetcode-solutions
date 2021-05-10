class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        // rotate number in 4 corners and move in from there
        for (int i = 0; i < n/2; i++)
        {
            for (int j = i; j < n-1-i; j++)
            {
                int temp = matrix[i][j];
                // Go up the rows in left-most col so since i is constant, we use j in the row placeholder
                matrix[i][j] = matrix[n-1-j][i];
                // Go leftwards in col in the bottom row (row constant = i constant)
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; // right-most value
                // Go downwards in rightmost col. row changes but col is contant. So use j for row
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}