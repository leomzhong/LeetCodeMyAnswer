import java.util.Arrays;


public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int left = searchLeft(A, target);
        if (left == -1) {
            int[] result = {-1, -1};
            return result;
        }
        System.out.println("left is " + left);
        int right = searchRight(A, target, left);
        System.out.println("right is " + right);
        int[] result = {left, right};
        return result;
    }

    public int searchLeft(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (A[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (A[left] == target)
            return left;
        else
            return -1;
    }
    public int searchRight(int[] A, int target, int left) {
        int right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (A[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left - 1;
    }
    public static void main(String[] args) {
        int[] test = {1};
        int target = 1;
        SearchForRange r = new SearchForRange();
        System.out.println(Arrays.toString(r.searchRange(test, target)));
    }
}

