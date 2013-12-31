public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                row[i][j] = false;
                column[i][j] = false;
                block[i][j] = false;
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0;j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                int tmp = (int)(c - '1');
                int bId = (j / 3) * 3 + i / 3;
                if (row[i][tmp] || column[j][tmp] || block[bId][tmp])
                    return false;
                row[i][tmp] = true;
                column[j][tmp] = true;
                block[bId][tmp] = true;
            }
        }
        return true;
    }
}
