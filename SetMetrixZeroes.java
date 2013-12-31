public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            boolean zero = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zero = true;
                    setSpecialColumn(matrix, j);
                }
            }
            if (zero) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -100000)
                    matrix[i][j] = 0;
            }
        }
    }
    public void setSpecialColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] != 0)
                matrix[i][column] = -100000;
        }
    }
}
