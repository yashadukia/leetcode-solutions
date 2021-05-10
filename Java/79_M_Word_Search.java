class Solution {
    
    private boolean[][] visited;
    private int ROWS;
    private int COLS;
    private char[][] b;
    String w;
    
    // My previous submissions were good. Just little slow
    // Did it by myself though
    public boolean exist(char[][] board, String word) {
        
        char first = word.charAt(0);
        visited = new boolean[board.length][board[0].length];
        b = board;
        ROWS = board.length;
        COLS = board[0].length;
        w = word;
        
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                if (board[i][j] == first)
                {
                    if (isWord(i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }
    
    // DFS
    public boolean isWord(int i, int j, int idx)
    {
        if (idx >= w.length())
            return true;
        
        if (i < 0 || i >= ROWS || j < 0 || j >= COLS || b[i][j] != w.charAt(idx))
            return false;
        
        if (visited[i][j])
            return false;
        
        // Choose a value mark it visited
        char c = b[i][j];
        visited[i][j] = true;
        
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        boolean ret = false;
        
        // This is for optimised time. See previous submission
        for (int k = 0; k < 4; k++)
        {
            // Choose and unchoose at every step in 4 directions
            ret = isWord(i+rowOffsets[k], j+colOffsets[k], idx+1);
            if (ret)
                break;
        }
        
        // Unchoose and remove from visited
        visited[i][j] = false;
        
        return ret;
    }
}