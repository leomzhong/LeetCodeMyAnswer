public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int result = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                result = i + 1;
                sum = 0;
            }
        }
        if (total < 0)
            return -1;
        return result;
    }
}
