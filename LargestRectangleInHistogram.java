// The problem is very tricky
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int length = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.size() == 0)
                stack.push(i);
            else {
                while (stack.size() != 0 && height[i] < height[stack.peek()]) {
                    int tmp = stack.pop();
                    if (stack.size() != 0) {
                        max = Math.max(max, height[tmp] * (i - stack.peek() - 1));
                    } else {
                        max = Math.max(max, height[tmp] * i);
                    }
                }
            } 
            stack.push(i);
        }
        while (stack.size() != 0) {
            int tmp = stack.pop();
            if (stack.size() != 0) {
                max = Math.max(max, height[tmp] * (length - stack.peek() - 1));
            } else {
                max = Math.max(max, height[tmp] * length);
            }
        }


        return max;
    }
}
