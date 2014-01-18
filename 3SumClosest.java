public class 3SumClosest {
    private int min;
    public boolean twoSum(int[] num, int pos, int target, int first) {
        boolean find = false;
        int left = pos;
        int right = num.length - 1;
        while (left < right) {
            int sum = num[left] + num[right] + first;
            if (Math.abs(sum - target) < Math.abs(min - target))
                min = sum;
            if (sum == target) {
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3)
            return 0;
        Arrays.sort(num);
        min = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i++) {
            if(i!=0 && num[i] == num[i-1])
                continue;
            twoSum(num, i + 1, target, num[i]);
        }
        return min;
    }
}
