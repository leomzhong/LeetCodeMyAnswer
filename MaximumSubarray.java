public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int result = Integer.MIN_VALUE;
        int current = 0;
        int index = 0;
        while (index < A.length) {
            while (index < A.length && current >= 0) {
                current += A[index];
                result = Math.max(result, current);
                index++;
            }
            if (index == A.length)
                break;
            current = 0;
        }
        return result;
    }
}
