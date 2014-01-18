public class RestoreIPAdresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s.length() > 12)
            return new ArrayList<String>();
        return helper(s, 0, 0);
    }

    public ArrayList<String> helper(String s, int pos, int level) {
        ArrayList<String> result = new ArrayList<String>();
        int len = 3;
        if (level == 4 && pos == s.length()) {
            result.add("");
            return result;
        } else if (pos == s.length()) {
            return result;
        } else if (s.charAt(pos) == '0')
            len = 1;
        for (int i = 0; i < len; i++) {
            if (pos + i == s.length())
                break;
            String tmp = s.substring(pos, pos + 1 + i);
            int num = Integer.parseInt(tmp);
            if (level < 3)
                tmp = tmp + '.';
            if (num >= 0 && num <= 255) {
                ArrayList<String> nextResult = helper(s, pos + i + 1, level + 1);
                for (String sTmp: nextResult) {
                    sTmp = tmp + sTmp;
                    result.add(sTmp);
                }
            }
        }
        return result;
    }
}
