//The idea is divide-conquer
public class Pow {
    public double pow(double x, int n) {
        if (x == 0)
            return 0;
        else if (n == 0)
            return 1;
        double div = pow(x, n / 2);
        if (n % 2 == 0)
            return div * div;
        else if (n > 0)
            return div * div * x;
        else
            return div * div / x;
    }
}
