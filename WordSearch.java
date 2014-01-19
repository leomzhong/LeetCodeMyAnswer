public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int sPos, int x, int y) {
        if (board[x][y] != word.charAt(sPos))
            return false;
        else {
            if (sPos == word.length() - 1)
                return true;
            board[x][y] = '#';
            boolean result = false;
            if (x - 1 >= 0)
                result |= helper(board, word, sPos + 1, x - 1, y);
            if (!result && x + 1 < board.length)
                result |= helper(board, word, sPos + 1, x + 1, y);
            if (!result && y - 1 >= 0)
                result |= helper(board, word, sPos + 1, x, y - 1);
            if (!result && y + 1 < board[0].length)
                result |= helper(board, word, sPos + 1, x, y + 1);
            board[x][y] = word.charAt(sPos);
            return result;
        }

    }
}
