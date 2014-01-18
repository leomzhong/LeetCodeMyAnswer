public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int result = 0;
        int[][] his = new int[matrix.length][matrix[0].length];
        buildHistogram(matrix, his);
        for (int i = 0; i < matrix.length; i++) {
            result = Math.max(result, largestRectangleArea(his[i]));
        }
        return result;
    }

    public void buildHistogram(char[][] matrix, int[][] his) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    his[i][j] = 0;
                else {
                    if (i == 0)
                        his[i][j] = 1;
                    else
                        his[i][j] = his[i - 1][j] + 1;
                }
            }
        }
    }

    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = height.length;
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.size() == 0)
                stack.push(i);
            else {
                while (stack.size() != 0 && height[i] < height[stack.peek()]) {
                    int tmp = stack.pop();
                    if (stack.size() == 0) {
                        result = Math.max(result, height[tmp] * i);
                    } else {
                        result = Math.max(result, height[tmp] * (i - stack.peek() - 1));
                    }
                }
                stack.push(i);
            }
        }
        while (stack.size() != 0) {
            int tmp = stack.pop();
            if (stack.size() == 0) {
                result = Math.max(result, height[tmp] * len);
            } else {
                result = Math.max(result, height[tmp] * (len - stack.peek() - 1));
            }
        }
        return result;
    }
}
