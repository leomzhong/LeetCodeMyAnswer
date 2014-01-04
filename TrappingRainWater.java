public class TrappingRainWater {
    public int trap(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int[] largest = new int[A.length];
        largest[A.length - 1] = 0;
        int max = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            largest[i] = Math.max(max, largest[i + 1]);
            max = Math.max(max, A[i]);
        }

        int result = 0;
        max = -1;
        int index = 0;
        while (index < A.length) {
            max = Math.min(A[index], largest[index]);
            int total = 0;
            index++;
            while (index < A.length && A[index] < max) {
                total += (max - A[index]);
                index++;
            }
            result += total;
        }
        return result;
    }
}
