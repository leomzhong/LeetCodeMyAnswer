public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        LinkedList<Integer> xList = new LinkedList<Integer>();
        LinkedList<Integer> yList = new LinkedList<Integer>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                xList.add(i);
                yList.add(0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                xList.add(i);
                yList.add(board[0].length - 1);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                xList.add(0);
                yList.add(j);
            }
            if (board[board.length - 1][j] == 'O') {
                xList.add(board.length - 1);
                yList.add(j);
            }
        }

        while (xList.size() != 0) {
            int x = xList.poll();
            int y = yList.poll();
            board[x][y] = 'S';
            if (x > 0 && board[x - 1][y] == 'O') {
                xList.add(x - 1);
                yList.add(y);
            }
            if (x < board.length - 1 && board[x + 1][y] == 'O') {
                xList.add(x + 1);
                yList.add(y);
            }
            if (y > 0 && board[x][y - 1] == 'O') {
                xList.add(x);
                yList.add(y - 1);
            }
            if (y < board[0].length - 1 && board[x][y + 1] == 'O') {
                xList.add(x);
                yList.add(y + 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'S')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
