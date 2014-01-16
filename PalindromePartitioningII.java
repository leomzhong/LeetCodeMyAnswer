public class PalindromePartitioningII {
    public void fillInPalindrome(String s, boolean[][] record) {
        for (int i = 0; i < record.length; i++) {
            record[i][i] = true;
        }
        for (int i = 0; i < record.length; i++) {
            for (int j = 1; i - j >= 0 && i + j < record.length; j++) {
                if (s.charAt(i - j) != s.charAt(i + j))
                    break;
                else {
                    record[i - j][i + j] = true;
                }
            }
        }
        for (int i = 0; i < record.length - 1; i++) {
            for (int j = 0; i - j >= 0 && i + 1 + j < record.length; j++) {
                if (s.charAt(i - j) != s.charAt(i + 1 + j))
                    break;
                else {
                    record[i - j][i + 1 + j] = true;
                }
            }
        }
    }
    public int minCut(String s) {
        if (s.length() < 2)
            return 0;
        boolean[][] record = new boolean[s.length()][s.length()];
        fillInPalindrome(s, record);
        int[] mem = new int[s.length()];
        for (int i = 0; i < mem.length; i++)
            mem[i] = -2;
        return Helper(s, 0, mem, record) - 1;
    }

    public int Helper(String s, int pos, int[] mem, boolean[][] record) {
        if (pos == s.length())
            return 0;
        int result = 0;
        if (mem[pos] == -2) {
            mem[pos] = -1;
            for (int i = pos; i < s.length(); i++) {
                if (record[pos][i]) {
                    int nextResult = Helper(s, i + 1, mem, record);
                    if (nextResult != -1) {
                        if (mem[pos] == -1)
                            mem[pos] = nextResult + 1;
                        else
                            mem[pos] = Math.min(mem[pos], nextResult + 1);
                    }
                }
            }
        }
        return mem[pos];
    }
}
