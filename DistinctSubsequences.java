public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if (S.length() == 0) {
            if (T.length() != 0)
                return 0;
            else
                return 1;
        }
        int[][] record = new int[S.length()][T.length()];
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[0].length; j++) {
                record[i][j] = -1;   
            }
        }
        return Helper(S, 0, T, 0, record);
    }

    public int Helper(String S, int Spos, String T, int Tpos, int[][] record) {
        if (Spos == S.length() && Tpos == T.length())
            return 1;
        else if (Tpos == T.length())
            return 1;
        else if (Spos == S.length())
            return 0;
        if (record[Spos][Tpos] == -1) {
            int tmpSpos = Spos;
            while (tmpSpos < S.length() && S.charAt(tmpSpos) != T.charAt(Tpos))
                tmpSpos++;
            if (tmpSpos == S.length())
                record[Spos][Tpos] = 0;
            else
                record[Spos][Tpos] = Helper(S, tmpSpos + 1, T, Tpos + 1, record) + Helper(S, tmpSpos + 1, T, Tpos, record);
        }
        return record[Spos][Tpos];
    }
}
