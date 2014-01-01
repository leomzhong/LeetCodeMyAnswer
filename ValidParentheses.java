public class ValidParentheses {
    public boolean isValid(String s) {
        char[] set = {'(', ')', '{', '}', '[', ']'};
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            int index = findIndex(tmp);
            if (index == -1)
                return false;
            else if (index % 2 == 0)
                stack.push(tmp);
            else {
                if (stack.size() == 0)
                    return false;
                if (stack.peek() != set[index - 1])
                    return false;
                stack.pop();
            }
        }
        if (stack.size() == 0)
            return true;
        else
            return false;
    }
    public int findIndex(char c) {
        char[] set = {'(', ')', '{', '}', '[', ']'};
        for (int i = 0; i < set.length; i++) {
            if (c == set[i])
                return i;
        }
        return -1;
    }
}
