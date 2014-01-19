public class KMP {
    public void buildPattern(String needle, int[] pattern) {
        pattern[0] = 0;
        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j))
                j = pattern[j - 1];
            if (needle.charAt(i) == needle.charAt(j))
                j++;
            pattern[i] = j;
        }
    }

    public String strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return haystack;
        int[] pa = new int[needle.length()];
        buildPattern(needle, pa);
        int index = 0;
        int pIndex = 0;
        while (index < haystack.length()
                && haystack.charAt(index) != needle.charAt(0))
            index++;
        if (index == haystack.length())
            return null;
        while (index + needle.length() - pIndex <= haystack.length()) {
            while (pIndex < needle.length()
                    && haystack.charAt(index) == needle.charAt(pIndex)) {
                index++;
                pIndex++;
            }
            if (pIndex == needle.length())
                return haystack.substring(index - pIndex);
            else {
                if (pIndex > 0)
                    pIndex = pa[pIndex - 1];
                else
                    index++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String test1 = "mississippi";
        String test2 = "issip";
        KMP r = new KMP();
        System.out.println(r.strStr(test1, test2));
    }
}

