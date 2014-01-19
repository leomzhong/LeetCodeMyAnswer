public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        int result = Integer.MAX_VALUE;
        int startResult = -1;
        int endResult = -1;
        int[] needToFind = new int[256];
        for (int i = 0; i < T.length(); i++) {
            needToFind[(int)(T.charAt(i))]++;
        }
        int[] find = new int[256];
        int counter = 0;
        for (int start = 0, end = 0; end < S.length(); end++) {
            int index = (int)S.charAt(end);
            if (needToFind[index] == 0)
                continue;
            find[index]++;
            if (find[index] <= needToFind[index])
                counter++;
            if (counter == T.length()) {
                int startIndex = (int)S.charAt(start);
                while (needToFind[startIndex] == 0 || find[startIndex] > needToFind[startIndex]) {
                    if (find[startIndex] > needToFind[startIndex]) {
                        find[startIndex]--;
                    }
                    start++;
                    startIndex = (int)S.charAt(start);
                }
                if (result > end - start + 1) {
                    result = end - start + 1;
                    startResult = start;
                    endResult = end;
                }
            }
        }
        if (startResult == -1)
            return "";
        else
            return S.substring(startResult, endResult + 1);
    }

}
