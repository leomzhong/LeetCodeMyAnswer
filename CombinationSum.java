public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return Helper(candidates, 0, target);
    }

    public ArrayList<ArrayList<Integer>> Helper(int[] candidates, int begin, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        } else if (begin >= candidates.length) {
            return result;
        }
        for (int i = 0; i * candidates[begin] <= target; i++) {
            ArrayList<ArrayList<Integer>> next = Helper(candidates, begin + 1, target - candidates[begin] * i);
            for (ArrayList<Integer> list: next) {
                for (int j = 0; j < i; j++) {
                    list.add(0, candidates[begin]);
                }
                result.add(list);
            }
        }
        return result;
    }
}
