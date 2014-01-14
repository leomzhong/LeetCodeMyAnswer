public class sqrt {
    public int sqrt(int x) {
        if (x == 0)
            return 0;
        else if (x == 1)
            return 1;
        double result = x / 2;
        double tmp = 0;
        while (true) {
            tmp = (result + x / result) / 2;
            if (Math.abs(tmp - result) < 0.1) break;
            result = tmp;
        }
        return (int)tmp;
    }
}
