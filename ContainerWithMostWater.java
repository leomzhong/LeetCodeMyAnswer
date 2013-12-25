public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = -1;
        while (left < right) {
            int tmp = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, tmp);
            if (height[left] < height[right])
                ++left;
            else
                --right;
        }
        return max;
    }
}
