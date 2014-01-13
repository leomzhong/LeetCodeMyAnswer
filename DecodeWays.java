public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] record = new int[s.length()];
        for (int i = 0; i < record.length; i++) {
            record[i] = -1;
        }
        return Helper(s, 0, record);
    }

    public int Helper(String s, int pos, int[] record) {
        if (pos == s.length())
            return 1;
        else if (record[pos] != -1)
            return record[pos];
        else {
            int first = -1;
            int second = -1;
            first = Integer.parseInt(s.substring(pos, pos+1));
            if (pos < s.length() - 1) {
                second = Integer.parseInt(s.substring(pos+1, pos+2));
            }
            if (first == 0)
                return 0;
            else {
                record[pos] = Helper(s, pos+1, record);
            }
            if (second != -1 && first <= 2) {
                if (first == 1 || (first == 2 && second <= 6)) {
                    record[pos] += Helper(s, pos + 2, record);
                }
            }
            return record[pos];
        }
    }
}
