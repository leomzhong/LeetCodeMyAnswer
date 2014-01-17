public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] mem = new int[s.length()];
        for (int i = 0; i < mem.length; i++)
            mem[i] = 0;
        int result = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int j = i + mem[i + 1] + 1;
                if (j < s.length()) {
                    if (s.charAt(j) == ')') {
                        mem[i] = mem[i + 1] + 2;
                        if (j + 1 < s.length())
                            mem[i] += mem[j + 1];
                    }
                }
            }
            result = Math.max(result, mem[i]);
        }
        return result;
    }
}
