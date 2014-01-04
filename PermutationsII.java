public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        return Helper(num, 0);    
    }

    public ArrayList<ArrayList<Integer>> Helper(int[] num, int begin) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (begin >= num.length) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = begin; i < num.length; i++) {
            if (set.contains(num[i]))
                continue;
            swap(num, begin, i);
            ArrayList<ArrayList<Integer>> next = Helper(num, begin + 1);
            for (ArrayList<Integer> list: next) {
                list.add(0, num[begin]);
                result.add(list);
            }
            swap(num, begin, i);
            set.add(num[i]);
        }
        return result;
    }

    public void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
