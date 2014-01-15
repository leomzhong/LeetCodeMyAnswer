// This is a very good solution
public class JumpGameII {
    public int jump(int[] A) {
        if (A.length < 2)
            return 0;
        int step = 0;
        int curr = 0;
        int last = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > last) {
                last = curr;
                step++;
            }
            curr = Math.max(curr, i + A[i]);
        }
        return step;
    }
}
