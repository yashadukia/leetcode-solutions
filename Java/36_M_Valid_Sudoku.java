class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Idea is to create an array of HashMap for rows cols and boxes.
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        
        // Initialize HashMaps
        for (int i = 0; i < 9; i++)
        {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        
        // Iterate over the whole grid.
        // If the current char is not a '.' then identify the box_idx
        // Add the current char to hashmap of rows cols and box_idx along with freq
        // If any of the freq exceeds 1, then return false
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.')
                {
                    int num = (int) board[i][j];
                    int boxIdx = (i / 3) * 3 + (j / 3);

                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);
                    boxes[boxIdx].put(num, boxes[boxIdx].getOrDefault(num, 0) + 1);
                    
                    if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxes[boxIdx].get(num) > 1)
                        return false;
                }
            }
        }
        
        return true;
        
    }
}