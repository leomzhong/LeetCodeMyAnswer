public class RotateImage {
    public void rotate(int[][] matrix) {
        Helper(matrix, 0);
    }

    public void Helper(int[][] matrix, int begin) {
        if (begin >= matrix.length / 2)
            return;
        for (int i = begin; i < matrix.length - begin - 1; i++) {
            swapFour(matrix, i, begin);
        }
        Helper(matrix, begin + 1);
    }

    public void swapFour(int[][] matrix, int x, int y) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[matrix.length - 1 - y][x];
        matrix[matrix.length - 1 - y][x] = matrix[matrix.length - 1 - x][matrix.length - 1 - y];
        matrix[matrix.length - 1 - x][matrix.length - 1 - y] = matrix[y][matrix.length - 1 - x];
        matrix[y][matrix.length - 1 - x] = tmp;
    }
}
