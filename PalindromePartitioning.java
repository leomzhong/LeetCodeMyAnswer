public class PalindromePartitioning {
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

    public ArrayList<ArrayList<String>> partition(String s) {
        boolean[][] record = new boolean[s.length()][s.length()];
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record.length; j++) {
                record[i][j] = false;
            }
        }
        fillInPalindrome(s, record);
        return Helper(s, 0, record);
    }

    public ArrayList<ArrayList<String>> Helper(String s, int pos, boolean[][] record) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (pos == s.length()) {
            result.add(new ArrayList<String>());
            return result;
        }
        for (int i = pos; i < s.length(); i++) {
            if (record[pos][i]) {
                ArrayList<ArrayList<String>> nextResult = Helper(s, i + 1, record);
                for (ArrayList<String> list: nextResult) {
                    list.add(0, s.substring(pos, i + 1));
                    result.add(list);
                }
            }
        }
        return result;
    }
}
