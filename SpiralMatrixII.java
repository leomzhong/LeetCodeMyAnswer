public class SpiralMatrixII {
    public int x = 0;
    public int y = 0;
    public int direction = 0;
    public int[][] generateMatrix(int n) {
        x = 0;
        y = 0;
        int direction = 0;
        int[][] result = new int[n][n];
        if (n < 1)
            return result;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
            }
        }
        Helper(n, result);
        return result;
    }

    public void Helper(int n, int[][] result) {
        int counter = 1;
        result[x][y] = counter++;
        while (getNext(n, result)) {
            result[x][y] = counter++;
        }
    }

    public boolean getNext(int n, int[][] result) {
        switch(direction) {
            case 0:
                if (y == n - 1 || result[x][y + 1] != 0) {
                    x += 1;
                    direction = 1;
                } else {
                    y += 1;
                }
                break;
            case 1:
                if (x == n - 1 || result[x+1][y] != 0) {
                    y -= 1;
                    direction = 2;
                } else {
                    x += 1;
                }
                break;
            case 2:
                if (y == 0 || result[x][y-1] != 0) {
                    x -= 1;
                    direction = 3;
                } else {
                    y -= 1;
                }
                break;
            case 3:
                if (x == 0 || result[x-1][y] != 0) {
                    y += 1;
                    direction = 0;
                } else {
                    x -= 1;
                }
        }
        if (x >= n || y >= n || result[x][y] != 0)
            return false;
        return true;
    }
}
