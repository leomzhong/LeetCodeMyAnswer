public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = findRow(matrix, target);
        if (binarySearch(matrix, row, target) == -1)
            return false;
        return true;
    }

    public int binarySearch(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target)
                return mid;
            else if (matrix[row][mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target)
                return mid;
            else if (matrix[mid][0] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (left == 0)
            return 0;
        int result = left - 1;
        while (result + 1 < matrix.length && matrix[result + 1][0] <= target)
            result++;
        return result;
    }
}
