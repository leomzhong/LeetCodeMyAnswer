public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] fac = new int[n];
        char[] res = new char[n];
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            fac[i-1] = counter * i;
            counter = fac[i - 1];
            res[i - 1] = (char)(i + '0');
        }

        int target = k - 1;
        for (int i = 0; i < n - 1; i++) {
            int subTree = target / fac[n - i - 2];
            int mem = target % fac[n - i - 2];
            if (subTree == 0 && mem == 0)
                break;
            else {
                for (int j = i + subTree; j > i; j--) {
                    char tmp = res[j];
                    res[j] = res[j - 1];
                    res[j - 1] = tmp;
                }
                target = mem;
            }
        }
        return convertToResult(res);
    }

    public String convertToResult(char[] res) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            result.append(res[i]);
        }
        return result.toString();
    }
}
