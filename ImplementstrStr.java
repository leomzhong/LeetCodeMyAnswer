public class ImplementstrStr {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return haystack;
        for (int i = 0; i < haystack.length(); i++) {
            if (helper(haystack, i, needle))
                return haystack.substring(i);
        }
        return null;
    }

    public boolean helper(String first, int pos, String second) {
        if (first.length() - pos < second.length())
            return false;
        int firstIndex = pos;
        int secondIndex = 0;
        while (secondIndex < second.length() && firstIndex < first.length()) {
            if (first.charAt(firstIndex) != second.charAt(secondIndex))
                return false;
            else {
                firstIndex++;
                secondIndex++;
            }
        }
        if (secondIndex != second.length())
            return false;
        return true;
    }
}
