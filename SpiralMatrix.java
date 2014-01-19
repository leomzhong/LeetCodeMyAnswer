public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < (matrix.length + 1) / 2
                && i < (matrix[0].length + 1) / 2; i++) {
            fillInOneLevel(matrix, result, i);
        }
        return result;
    }

    public void fillInOneDirection(int[][] matrix, ArrayList<Integer> result,
            int level, boolean direction) {
        if (direction) {
            for (int i = level; i < matrix[0].length - level; i++) {
                result.add(matrix[level][i]);
            }
        } else {
            for (int i = level; i < matrix.length - level; i++) {
                result.add(matrix[i][level]);
            }
        }
    }

    public void fillInOneLevel(int[][] matrix, ArrayList<Integer> result,
            int level) {

        int xStart = level;
        int xEnd = matrix.length - 1 - level;
        int yStart = level;
        int yEnd = matrix[0].length - 1 - level;

        if (xStart == xEnd) {
            fillInOneDirection(matrix, result, level, true);
        } else if (yStart == yEnd) {
            fillInOneDirection(matrix, result, level, false);
        } else {
            for (int i = yStart; i < yEnd; i++) {
                result.add(matrix[xStart][i]);
            }
            for (int i = xStart; i < xEnd; i++) {
                result.add(matrix[i][yEnd]);
            }
            for (int i = yEnd; i > yStart; i--) {
                result.add(matrix[xEnd][i]);
            }
            for (int i = xEnd; i > xStart; i--) {
                result.add(matrix[i][yStart]);
            }
        }
    }
}
