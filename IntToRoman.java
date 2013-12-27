public String intToRoman(int num) {
    String result = "";
    char[] r = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
    int d = 0;
    int div = 1000;
    while (div > 0) {
        int tmp = num / div;
        if (tmp < 5) {
            if (tmp == 4) {
                result += r[d];
                result += r[d - 1];
            } else {
                for (int i = 0; i < tmp; i++) {
                    result += r[d];
                }
            }
        } else {
            if (tmp == 9) {
                result += r[d];
                result += r[d - 2];
            } else {
                result += r[d - 1];
                for (int i = 0; i < tmp - 5; i++) {
                    result += r[d];
                }
            }
        }
        num = num % div;
        div /= 10;
        d += 2;
    }
    return result;
}
