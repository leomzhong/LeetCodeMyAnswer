public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return Helper(num, 0, target, -1, true);
    }

    public ArrayList<ArrayList<Integer>> Helper(int[] num, int begin, int target, int pre, boolean chosen) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            result.add(tmp);
            return result;
        } else if (begin >= num.length || num[begin] > target) {
            return result;
        }

        ArrayList<ArrayList<Integer>> next = null;
        if (pre == -1 || pre != num[begin] || chosen) {
            next = Helper(num, begin + 1, target - num[begin], num[begin], true);
        }

        if (next != null) {
            for (ArrayList<Integer> list: next) {
                list.add(0, num[begin]);
                result.add(list);
            }
        }
        result.addAll(Helper(num, begin + 1, target, num[begin], false));
        return result;
    }
}
