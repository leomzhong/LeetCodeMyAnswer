public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int index = 0;
        while (index < A.length) {
            if (A[index] == index + 1 || A[index] > A.length || A[index] <= 0)
                index++;
            else {
                if (A[index] == A[A[index] - 1])
                    index++;
                else
                    swap(A, index, A[index] - 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }

    public void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}
