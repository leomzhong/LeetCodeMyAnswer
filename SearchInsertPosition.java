public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        return binarySearch(A, target);
    }

    public int binarySearch(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int tmp = A[mid];
            if (tmp == target) {
                return mid;
            } else if (tmp > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
