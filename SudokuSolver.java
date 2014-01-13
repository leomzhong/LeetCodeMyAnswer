public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean[][][] record = new boolean[3][board.length][9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < 9; k++) {
                    record[i][j][k] = false;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int value = Character.getNumericValue(board[i][j]) - 1;
                    setChoice(board, record, i, j, value, true);
                }
            }
        }
        Helper(board, record, 0, 0);
    }

    public boolean isValid(boolean[][][] record, int x, int y, int value) {
        if (record[0][x][value] || record[1][y][value])
            return false;
        else {
            int index = (x / 3) * 3 + y / 3;
            if (record[2][index][value])
                return false;
        }
        return true;
    }

    public void setChoice(char[][] board, boolean[][][] record, int x,
            int y, int value, boolean choice) {
        record[0][x][value] = choice;
        record[1][y][value] = choice;
        int index = (x / 3) * 3 + y / 3;
        record[2][index][value] = choice;
        if (choice)
            board[x][y] = Character.forDigit(value + 1, 10);
        else
            board[x][y] = '.';
    }

    public boolean Helper(char[][] board, boolean[][][] record, int x, int y) {
        while (board[x][y] != '.') {
            y += 1;
            if (y == board.length) {
                x += 1;
                y = 0;
                if (x == board.length)
                    return true;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (isValid(record, x, y, i - 1)) {
                setChoice(board,record, x, y, i - 1, true);
                if (Helper(board, record, x, y))
                    return true;
                setChoice(board,record, x, y, i - 1, false);
            }
        }
        return false;
    }
}
