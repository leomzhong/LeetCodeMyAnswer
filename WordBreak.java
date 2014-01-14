public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null)
            return true;
        boolean[][] record = new boolean[s.length()][s.length()];
        for (int i = 0; i < record.length; i++) {
            for (int j = i; j < record.length; j++) {
                String tmp = s.substring(i, j + 1);
                if (dict.contains(tmp))
                    record[i][j] = true;
                else
                    record[i][j] = false;
            }
        }

        boolean[] memo = new boolean[s.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = false;
        }
        memo[s.length()] = true;
        for (int i = record.length - 1; i >= 0; i--) {
            for (int j = i; j < record.length; j++) {
                if (record[i][j] && memo[j+1])
                    memo[i] = true;
            }
        }
        return memo[0];
    }
}
