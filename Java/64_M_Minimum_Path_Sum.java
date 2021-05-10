class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        
        // Fill the dp array from bottom right to top left.
        // See solution for explanation
        for (int i = m-1; i >= 0; i--)
        {
            for (int j = n-1; j >= 0; j--)
            {
                if (i == m-1 && j == n-1) // right bottom cell
                    dp[i][j] = grid[i][j];
                else if (i == m-1 && j < n-1) // last row
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                else if (i < m-1 && j == n-1) // last col
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                else // all others
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}