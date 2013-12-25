public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int div = 1;
        while (x / div >= 10)
            div *= 10;

        while (x != 0) {
            int l = x % 10;
            int r = x / div;
            if (l != r)
                return false;
            x = (x % div) / 10;
            div = div / 100;
        }
        return true;
    }
}
