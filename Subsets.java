public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return Helper(S, 0);
    }

    public ArrayList<ArrayList<Integer>> Helper(int[] S, int begin) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (begin == S.length) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<ArrayList<Integer>> tmp = Helper(S, begin + 1);
        for (ArrayList<Integer> list: tmp) {
            result.add(list);
            ArrayList<Integer> newList = deepCopy(list);
            newList.add(0, S[begin]);
            result.add(newList);
        }
        return result;
    }

    public ArrayList<Integer> deepCopy(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer i: list) {
            result.add(i);
        }
        return result;
    }
}
