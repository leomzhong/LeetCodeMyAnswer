public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        int d = 0;
        char[] r = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
        int[] a = {1000, 500, 100, 50, 10, 5, 1};
        for (int i = 0; i < s.length(); i++) {
            int index = getIndex(r, s.charAt(i));
            if (i == s.length() - 1)
                result += a[index];
            else {
                int indexNext = getIndex(r, s.charAt(i + 1));
                if (indexNext >= index) {
                    result += a[index];
                } else {
                    result -= a[index];
                    result += a[indexNext];
                    i++;
                }
            }
        }
        return result;
    }

    public int getIndex(char[] dictionary, char c) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] == c)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String test = "MLXVI";
        RomanToInt r = new RomanToInt();
        System.out.println(r.romanToInt(test));
    }
}

