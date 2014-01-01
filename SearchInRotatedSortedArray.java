public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        return Helper(A, 0, A.length - 1, target);
    }

    public int Helper(int[] A, int left, int right, int target) {
        if (left > right)
            return -1;
        if (A[left] < A[right])
            return binarySearch(A, left, right, target);
        else {
            int mid = left + (right - left) / 2;
            if (A[mid] == target)
                return mid;
            else {
                int result = Helper(A, mid + 1, right, target);
                if (result == -1)
                    result = Helper(A, left, mid - 1, target);
                return result;
            }
        }
    }

    public int binarySearch(int[] A, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {4, 5, 6, 7, 0, 1, 2};
        int target = 10;
        SearchInRotatedSortedArray r = new SearchInRotatedSortedArray();
        System.out.println(r.search(test, target));
    }
}
