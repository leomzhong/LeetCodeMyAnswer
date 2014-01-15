public class NQueensNotRecursive {
    public int totalNQueens(int n) {
        int result = 0;
        int row = 0;
        int[] record = new int[n];
        record[0] = -1;
        while (row >= 0) {
            record[row]++;
            if (record[row] >= n) {
                row--;
                continue;
            } else {
                if (!isValid(record, row, record[row]))
                    continue;
                else {
                    if (row == n - 1) {
                        result++;
                        continue;
                    } else {
                        row++;
                        record[row] = -1;
                    }
                }
            }
        }
        return result;
    }

    public boolean isValid(int[] record, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (record[i] == col)
                return false;
            else if (Math.abs(row - i) == Math.abs(col - record[i]))
                return false;
        }
        return true;
    }
}
