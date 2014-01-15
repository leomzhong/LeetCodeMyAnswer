public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        int[] record = new int[n];
        ArrayList<String[]> result = new ArrayList<String[]>();
        Helper(record, 0, result);
        return result;
    }

    public void addToResult(int[] record, ArrayList<String[]> result) {
        String[] newResult = new String[record.length];
        for (int i = 0; i < record.length; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < record[i]; j++) {
                tmp.append('.');
            }
            tmp.append('Q');
            for (int j = record[i] + 1; j < record.length; j++) {
                tmp.append('.');
            }
            newResult[i] = tmp.toString();
        }
        result.add(newResult);
    }

    public void Helper(int[] record, int row, ArrayList<String[]> result) {
        if (row == record.length) {
            addToResult(record, result);
            return;
        } else {
            for (int i = 0; i < record.length; i++) {
                if (isValid(record, row, i)) {
                    record[row] = i;
                    Helper(record, row + 1, result);
                }
            }
        }
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
