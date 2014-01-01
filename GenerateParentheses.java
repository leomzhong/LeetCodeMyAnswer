public class GenerateParentheses {
        public ArrayList<String> generateParenthesis(int n) {
                    ArrayList<String> result = new ArrayList<String>();
                            Helper("", n, n, result);
                                    return result;
                                        }
            public void Helper(String s, int left, int right, ArrayList<String> result) {
                        if (left < 0 || right < 0 || left > right)
                                        return;
                                if (left == 0 && right == 0)
                                                result.add(s);
                                        Helper(s + "(", left - 1, right, result);
                                                Helper(s + ")", left, right - 1, result);
                                                    }
}
