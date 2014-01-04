public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                int right = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                if (j < grid[0].length - 1)
                    right = grid[i][j + 1];
                if (i < grid.length - 1)
                    down = grid[i+1][j];
                if (right == Integer.MAX_VALUE && down == Integer.MAX_VALUE)
                    continue;
                grid[i][j] = grid[i][j] + Math.min(right, down);
            }
        }
        return grid[0][0];
    }
}
