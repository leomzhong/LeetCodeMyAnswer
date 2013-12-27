public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int indicator = 1;
        int old = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == old)
                continue;
            A[indicator++] = A[i];
            old = A[i];
        }
        return indicator;
    }
}
