public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0)
            return "";
        else if (nRows == 1)
            return s;
        String result = ""; 
        for (int i = 0; i < nRows; i++) {
            boolean d = true;
            int j = i;
            while (j < s.length()) {
                result += s.charAt(j);
                if (d) {
                    int plus = 2 * (nRows - i - 1);
                    if (plus == 0)
                        plus = 2 * (nRows - 1);
                    j += plus;
                } else {
                    int plus = 2 * i;
                    if (plus == 0)
                        plus = 2 * (nRows - 1);
                    j += plus;
                }
                d = !d;
            }
        }
        return result;
    }
}
