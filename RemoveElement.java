public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            while (right >= left && A[right] == elem)
                --right;
            while (left <= right && A[left] != elem)
                ++left;
            if (left > right) {
                break;
            } else {
                swap(A, left, right);   
            }
        }
        return left;
    }

    public void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
