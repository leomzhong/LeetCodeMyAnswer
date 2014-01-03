public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        ArrayList<Integer> preLevel = new ArrayList<Integer>();
        if (rowIndex < 1)
            return preLevel;
        preLevel.add(1);
        for (int i = 1; i < rowIndex; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 0; j < preLevel.size() - 1; j++) {
                tmp.add(preLevel.get(j) + preLevel.get(j+1));
            }
            tmp.add(1);
            preLevel = tmp;
        }
        return preLevel;
    }
}
