public class 3Sum {

    public boolean twoSum(int[] num, int pos, int target, int first, ArrayList<ArrayList<Integer>> result) {
        boolean find = false;
        int left = pos;
        int right = num.length - 1;
        while (left < right) {
            if (num[left] + num[right] == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(first);
                list.add(num[left]);
                list.add(num[right]);
                result.add(list);
                left++;
                right--;
                find = true;
                while (left <= right && num[left] == num[left - 1])
                    left++;
                while (right >= left && num[right] == num[right + 1])
                    right--;
            } else if (num[left] + num[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            if(i!=0 && num[i] == num[i-1])
                continue;
            twoSum(num, i + 1, 0 - num[i], num[i], result);
        }
        return result;
    }
}
