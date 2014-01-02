public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] record = new int[n + 1];
        for (int i = 0; i < record.length; i++) {
            record[i] = 0;
        }
        return Helper(n, record);
    }

    public int Helper(int n, int[] record) {
        if (n == 0 || n == 1)
            return 1;
        if (record[n] == 0) {
            record[n] = Helper(n - 1, record) + Helper(n - 2, record);   
        }
        return record[n];
    }
}
