public class Solution {
    public String longestPalindrome(String s) {
        return longestPalindromeHelper(s);
    }

    public String longestPalindromeHelper(String s) {
        boolean[][] record = new boolean[s.length()][s.length()];
        int startIndex = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                record[i][j] = false;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            record[i][i] = true;
            if (i != s.length() - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    record[i][i+1] = true;
                    startIndex = i;
                    maxLen = 2;
                }
            }
        }
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && record[i + 1][j - 1]) {
                    record[i][j] = true;
                    startIndex = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
}
