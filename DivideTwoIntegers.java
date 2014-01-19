// Any other solutions not using long?
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean positive = true;
        if (dividend < 0)
            positive = !positive;
        if (divisor < 0)
            positive = !positive;

        long a = (long)dividend;
        long b = (long)divisor;

        a = Math.abs(a);
        b = Math.abs(b);

        if (a < b)
            return 0;
        int c = 0;
        while ((b << c) <= a) {
            c++;
        }
        c--;
        int result = 0;
        while (a > 0 && c >= 0) {
            while (a - (b << c) >= 0) {
                result += (1 << c);
                a -= (b << c);
            }
            c--;
        }
        if (!positive)
            result *= -1;
        return result;
    }
}
