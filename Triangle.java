public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        ArrayList<Integer> level = triangle.get(triangle.size() - 1);
        int[] record = new int[level.size()];
        for (int i = 0; i < record.length; i++) {
            record[i] = level.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            level = triangle.get(i);
            int[] tmp = new int[record.length - 1];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = level.get(j) + Math.min(record[j], record[j+1]);
            }
            record = tmp;
        }
        return record[0];
    }
}
