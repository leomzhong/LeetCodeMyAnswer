public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < s.length() && (s.charAt(left) > 'z' || s.charAt(left) < 'a') && (s.charAt(left) > '9' || s.charAt(left) < '0'))
                left++;
            while (right >= 0 && (s.charAt(right) > 'z' || s.charAt(right) < 'a') && (s.charAt(right) > '9' || s.charAt(right) < '0'))
                right--;
            if (left >= right)
                break;
            else {
                if (s.charAt(left) != s.charAt(right))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
