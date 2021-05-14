class Solution {
    public void solve(char[][] board) {
        
        if (board == null || board.length == 0)
            return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Iterate thru all borders and perform DFS/BFS on 'O' marking all neighbors as 'E'. So we will have clarity that remaining 'O's will turn into 'X'
        // DFS first and last col. Notice the loop is till rows
        for (int i = 0; i < rows; i++)
        {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][cols-1] == 'O')
                dfs(board, i, cols-1);
        }
        
        // DFS first and last row. Notice the loop is till cols
        for (int i = 0; i < cols; i++)
        {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[rows-1][i] == 'O')
                dfs(board, rows-1, i);
        }
        
        // Mark all 'O' as 'X' and change all 'E' back to 'O'
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void dfs(char[][] b, int i, int j)
    {
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] != 'O')
            return;
        
        // System.out.println(i+" "+j);
        b[i][j] = 'E';
        
        dfs(b, i+1, j);
        dfs(b, i-1, j);
        dfs(b, i, j+1);
        dfs(b, i, j-1);
    }
}