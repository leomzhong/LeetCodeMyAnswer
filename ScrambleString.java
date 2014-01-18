public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        boolean[][][] record = new boolean[s1.length()][s1.length()][s1.length() + 1];
        for (int length = 1; length < record[0][0].length; length++) {
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    record[i][j][length] = false;
                    if (i + length - 1 >= s1.length() || j + length - 1 >= s1.length())
                        continue;
                    if (length == 1)
                        record[i][j][length] = s1.charAt(i) == s2.charAt(j);
                    else {
                        for (int k = 1; k < length; k++) {
                            record[i][j][length] |= (record[i][j][k] && record[i + k][j + k][length - k]);
                            record[i][j][length] |= (record[i + length - k][j][k] && record[i][j + k][length - k]);
                            if (record[i][j][length])
                                break;
                        }
                    }
                }
            }
        }
        return record[0][0][s1.length()];
    }
}
