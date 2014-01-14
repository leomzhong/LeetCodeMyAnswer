public class JumpGame {
    public boolean canJump(int[] A) {
        int index = A.length - 1;
        while (index > 0) {
            int tmp = index - 1;
            while (tmp >= 0) {
                if (tmp + A[tmp] >= index)
                    break;
                else
                    tmp--;
            }
            if (tmp == -1)
                return false;
            else
                index = tmp;
        }
        return true;
    }
}
