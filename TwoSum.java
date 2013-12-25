import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[numbers.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i + 1;
        }
        quickSort(numbers, index, 0, numbers.length - 1);
        return doTwoSum(numbers, index, target);
    }

    public int[] doTwoSum(int[] numbers, int[] index, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int a = numbers[left];
            int b = numbers[right];
            if (a + b == target)
                break;
            else if (a + b > target)
                --right;
            else
                ++left;
        }
        if (left >= right)
            return null;
        int[] result = {index[left], index[right]};
        if (index[left] > index[right])
            swap(result, 0, 1);
        return result;
    }

    public void quickSort(int[] numbers, int[] index, int left, int right) {
        if (left >= right)
            return;
        int c = numbers[left];
        int l = left;
        int r = right + 1;
        while (l < r) {
            while (numbers[++l] < c && l < right);
            while (numbers[--r] > c && r > left);
            if (l >= r)
                break;
            swapAll(numbers, index, l, r);
        }
        if (left != l) {
            swapAll(numbers, index, left, r);
        }
        quickSort(numbers, index, left, r - 1);
        quickSort(numbers, index, r + 1, right);
    }

    public void swapAll(int[] numbers, int[] index, int left, int right) {
        swap(numbers, left, right);
        swap(index, left, right);
    }

    public void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {2,1,9,4,4,56,90,3};
        int target = 8;
        TwoSum s = new TwoSum();
        System.out.println(Arrays.toString(s.twoSum(test,target)));
    }
}

