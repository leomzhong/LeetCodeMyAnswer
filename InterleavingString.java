public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        else if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        int[][] record = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[0].length; j++) {
                record[i][j] = -1;
            }
        }
        record[s1.length()][s2.length()] = 1;
        if (Helper(s1, 0, s2, 0, s3, record) == 1)
            return true;
        else
            return false;
    }

    public int Helper(String s1, int pos1, String s2, int pos2, String s3, int[][] record) {
        if (record[pos1][pos2] == -1) {
            record[pos1][pos2] = 0;
            if (pos1 < s1.length()) {
                if (s1.charAt(pos1) == s3.charAt(pos1 + pos2)) {
                    record[pos1][pos2] = Helper(s1, pos1 + 1, s2, pos2, s3, record);
                }
            }
            if (record[pos1][pos2] == 0 && pos2 < s2.length()) {
                if (s2.charAt(pos2) == s3.charAt(pos1 + pos2)) {
                    record[pos1][pos2] = Helper(s1, pos1, s2, pos2 + 1, s3, record);
                }
            }
        }
        return record[pos1][pos2];

    }
}
