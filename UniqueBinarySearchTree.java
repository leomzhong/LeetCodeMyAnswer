public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        int[] record = new int[n + 1];
        for (int i = 0; i < record.length; i++) {
            record[i] = 0;
        }
        record[0] = 1;
        record[1] = 1;
        return Helper(n, record);
    }
    public int Helper(int n, int[] record) {
        if (record[n] != 0)
            return record[n];
        else {
            for (int i = 0; i < n; i++) {
                record[n] += (Helper(i, record) * Helper(n - i - 1, record));
            } 
            return record[n];
        }
    }
}
