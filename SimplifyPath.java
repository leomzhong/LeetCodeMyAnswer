public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] ss = path.trim().split("/");
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].length() == 0 || ss[i].equals(".")) {
                continue;
            } else if (ss[i].equals("..")) {
                if (stack.size() != 0)
                    stack.pop();
            } else {
                stack.push(ss[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        if (stack.size() == 0)
            return "/";
        while (stack.size() != 0) {
            result.insert(0, "/" + stack.pop());
        }
        return result.toString();
    }
}
