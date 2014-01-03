public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows < 1)
            return result;
        ArrayList<Integer> preLevel = new ArrayList<Integer>();
        preLevel.add(1);
        result.add(preLevel);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 0; j < preLevel.size() - 1; j++) {
                tmp.add(preLevel.get(j) + preLevel.get(j+1));
            }
            tmp.add(1);
            result.add(tmp);
            preLevel = tmp;
        }
        return result;
    }
}
