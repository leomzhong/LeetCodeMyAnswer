public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num.length < 2)
            return;
        int second = num.length - 1;
        int first = num.length - 2;
        while (first >= 0) {
            if (num[second] > num[first]) {
                break;
            }
            second -= 1;
            first -= 1;
        }
        if (first < 0)
            swapArray(num, 0, num.length - 1);
        else {
            int index = findNext(num, first);
            swap(num, first, index);
            swapArray(num, first + 1, num.length - 1);
        }
    }

    public int findNext(int[] array, int begin) {
        int target = array[begin];
        int result = begin + 1;
        while (result < array.length && array[result] > target)
            result++;
        return result - 1;
    }

    public void swapArray(int[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    public void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
