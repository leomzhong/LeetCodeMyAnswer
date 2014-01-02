public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] record = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[0].length; j++) {
                record[i][j] = -1;
            }
        }
        if (obstacleGrid[0][0] == 1)
            return 0;
        record[0][0] = 1;
        return Helper(obstacleGrid, record.length - 1, record[0].length - 1, record);
    }

    public int Helper(int[][] obstacleGrid, int m, int n, int[][] record) {
        if (m < 0 || n < 0)
            return 0;
        if (record[m][n] == -1) {
            record[m][n] = 0;
            if (obstacleGrid[m][n] == 1)
                return 0;
            if (m > 0) {
                record[m][n] += (1 - obstacleGrid[m - 1][n]) * Helper(obstacleGrid, m - 1, n, record);
            }
            if (n > 0) {
                record[m][n] += (1 - obstacleGrid[m][n - 1]) * Helper(obstacleGrid, m, n - 1, record);
            }
        }
        return record[m][n];
    }
}
