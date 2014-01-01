public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        else if (word1 == null)
            return word2.length();
        else if (word2 == null)
            return word1.length();

        int[][] record = new int[word1.length()][word2.length()];
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[0].length; j++) {
                record[i][j] = 0;
            }
        }
        return Helper(word1, 0, word2, 0, record);
    }

    public int Helper(String word1, int pos1, String word2, int pos2, int[][] record) {
        if (pos1 == word1.length())
            return word2.length() - pos2;
        else if (pos2 == word2.length())
            return word1.length() - pos1;
        if (record[pos1][pos2] != 0)
            return record[pos1][pos2];
        char tmp1 = word1.charAt(pos1);
        char tmp2 = word2.charAt(pos2);
        if (tmp1 == tmp2)
            record[pos1][pos2] = Helper(word1, pos1 + 1, word2, pos2 + 1, record);
        else {
            int min = Math.min(1 + Helper(word1, pos1 + 1, word2, pos2, record), 1 + Helper(word1, pos1, word2, pos2 + 1, record));
            record[pos1][pos2] = Math.min(min, 1 + Helper(word1, pos1 + 1, word2, pos2 + 1, record));
        }
        return record[pos1][pos2];
    }
}
