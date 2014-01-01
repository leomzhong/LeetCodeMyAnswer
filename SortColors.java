public class SortColors {
    public void sortColors(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int running = 0;
        while (running <= right) {
            if (A[running] == 0)
                swap(A, left++, running++);
            else if (A[running] == 2)
                swap(A, running, right--);
            else
                running++;
        }
    }

    public void swap(int[] A, int first, int second) {
        if (first == second)
            return;
        int tmp = A[first];
        A[first] = A[second];
        A[second] = tmp;
    }
}
