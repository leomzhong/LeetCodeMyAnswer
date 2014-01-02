public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] record = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                record[i][j] = 0;
            }
        }
        record[0][0] = 1;
        return Helper(m-1, n-1, record);
    }

    public int Helper(int m, int n, int[][] record) {
        if (m < 0 || n < 0)
            return 0;
        if (record[m][n] == 0) {
            record[m][n] = Helper(m - 1, n, record) + Helper(m, n - 1, record);
        }
        return record[m][n];
    }
}
