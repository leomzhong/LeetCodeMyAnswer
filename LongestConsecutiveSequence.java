public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], 1);
        }
        int result = 1;
        for (int i = 0; i < num.length; i++) {
            if (map.get(num[i]) == null)
                continue;
            int low = num[i] - 1;
            int high = num[i] + 1;
            while (map.get(low) != null) {
                map.remove(low);
                low--;
            }
            while (map.get(high) != null) {
                map.remove(high);
                high++;
            }
            result = Math.max(result, high - low - 1);
        }
        return result;
    }
}
