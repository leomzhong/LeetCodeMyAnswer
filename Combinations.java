public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n < 1 && k > 0) {
            return result;
        } else if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        for (int i = n; i > 0 ; i--) {
            ArrayList<ArrayList<Integer>> tmp = combine(i - 1, k - 1);
            for (ArrayList<Integer> list: tmp) {
                list.add(i);
                result.add(list);
            }
        }
        return result;
    }
}
