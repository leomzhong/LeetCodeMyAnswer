public class Solution {
    public int evalRPN(String[] tokens) {
        String[] op = {"+", "-", "*", "/"};
        Stack<Integer> stack = new Stack<Integer>();
        for (String s: tokens) {
            boolean checkOp = false;
            for (String o: op) {
                if (s.equals(o)) {
                    checkOp = true;
                    if (stack.size() < 2) {
                        throw new RuntimeException("Too many operators");
                    }
                }
            }
            if (!checkOp) {
                stack.push(Integer.parseInt(s));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = -1;
                if (s.equals("+")) {
                    result = a + b;
                } else if (s.equals("-")) {
                    result = a - b;
                } else if (s.equals("*")) {
                    result = a * b;
                } else if (s.equals("/")) {
                    if (b == 0)
                        throw new RuntimeException("b is 0");
                    result = a / b;
                } else {
                    throw new RuntimeException("Invalid operator");
                }
                stack.push(result);
            }
        }
        if (stack.size() != 1)
            throw new RuntimeException("Too many numbers");
        return stack.pop();
    }
}
