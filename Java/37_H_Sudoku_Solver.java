class Solution {
    
    char[][] board;
    int n = 3;
    int N = 9;
    boolean solved = false;
    
    // Need N+1 as numbers are from 1 -> 9 which are to be filled and these 2d arrays represent numbers as cols. So we need 10 cols (0 -> 9) to fill all numbers
    int[][] rows = new int[N][N+1];
    int[][] cols = new int[N][N+1];
    int[][] boxes = new int[N][N+1];
    
    public boolean couldPlace(int d, int row, int col) {
        /*
        Check if one could place a number d in (row, col) cell
        */
        int idx = (row / n ) * n + col / n;
        return rows[row][d] + cols[col][d] + boxes[idx][d] == 0;
      }
    
    public void placeNumber(int d, int row, int col) {
        /*
        Place a number d in (row, col) cell
        */
        int idx = (row / n ) * n + col / n;

        rows[row][d]++;
        cols[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }
    
    public void removeNumber(int d, int row, int col) {
        /*
        Remove a number which didn't lead to a solution
        */
        int idx = (row / n ) * n + col / n;
        rows[row][d]--;
        cols[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }
    
    public void placeNextNumbers(int row, int col) {
        /*
        Call backtrack function in recursion
        to continue to place numbers
        till the moment we have a solution
        */
        // if we're in the last cell
        // that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
          solved = true;
        }
        // if not yet
        else {
          // if we're in the end of the row
          // go to the next row
          if (col == N - 1)
              backtrack(row + 1, 0);
            // go to the next column
          else 
              backtrack(row, col + 1);
        }
      }
    
    public void backtrack(int row, int col) {
        /*
        Backtracking
        */
        // if the cell is empty
        if (board[row][col] == '.') {
          // iterate over all numbers from 1 to 9
          for (int d = 1; d < 10; d++) {
            if (couldPlace(d, row, col)) {
              placeNumber(d, row, col);
              placeNextNumbers(row, col);
              // if sudoku is solved, there is no need to backtrack
              // since the single unique solution is promised
              if (!solved)
                  removeNumber(d, row, col);
            }
          }
        }
        else placeNextNumbers(row, col);
    }
    
    public void solveSudoku(char[][] board) {
        
        this.board = board;
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (board[i][j] != '.')
                {
                    // Place the number in the int 2d arrays
                    int num = Character.getNumericValue(board[i][j]);
                    // placeNumber(num, i, j);
                    
                    int boxidx = (i / 3) * 3 + (j / 3);
                    
                    rows[i][num]++;
                    cols[j][num]++;
                    boxes[boxidx][num]++;
                }
            }
        }
        backtrack(0, 0);
    }
}