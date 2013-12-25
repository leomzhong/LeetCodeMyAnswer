public class Solution {
    public int reverse(int x) {
        int result = 0;
        int tmp = x;
        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp /= 10;
        }
        return result;
    }
}
