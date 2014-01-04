public class AddBinary {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int m = 0;
        StringBuilder s = new StringBuilder();
        while (!(aIndex == -1 && bIndex == -1 && m == 0)) {
            int first = 0;
            int second = 0;
            if (aIndex >= 0) {
                first = Character.getNumericValue(a.charAt(aIndex--));
            }
            if (bIndex >= 0) {
                second = Character.getNumericValue(b.charAt(bIndex--));
            }
            int tmpResult = first + second + m;
            if (tmpResult == 2) {
                m = 1;
                tmpResult = 0;
            } else if (tmpResult == 3) {
                m = 1;
                tmpResult = 1;
            } else {
                m = 0;
            }
            s.insert(0, tmpResult);
        }
        return s.toString();
    }
}
