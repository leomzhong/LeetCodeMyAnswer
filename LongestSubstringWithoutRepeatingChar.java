public class Solution {

    private int max = 1;
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        boolean[] indicator = new boolean[26];
        int left = 0;
        int right = 1;
        indicator[getIndex(s.charAt(0))] = true;
        while (right < s.length()) {
            int code = getIndex(s.charAt(right));
            if (!indicator[code]) {
                updateMax(left, right);
                right += 1;
                indicator[code] = true;
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    indicator[getIndex(s.charAt(left++))] = false;
                    updateMax(left, right);
                }
                indicator[getIndex(s.charAt(left++))] = false;
                updateMax(left, right);
            }
        }
        return max;
    }

    public int getIndex(char c) {
        return (int) (c - 'a');
    }

    public void updateMax(int left, int right) {
        if (right - left  + 1> this.max)
            this.max = right - left + 1;
    }

}
