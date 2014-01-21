public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sPos = 0;
        int pPos = 0;
        int previousStar = -1;
        int mem = -1;
        while (sPos < s.length()) {
            if (pPos != p.length() && (s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '?')) {
                sPos++;
                pPos++;
            } else if (pPos == p.length() || ((s.charAt(sPos) != p.charAt(pPos) && (p.charAt(pPos) != '*')))) {
                if (previousStar != -1) {
                    pPos = previousStar + 1;
                    sPos = ++mem;
                } else {
                    return false;
                }
            } else if (p.charAt(pPos) == '*') {
                previousStar = pPos;
                pPos++;
                mem = sPos;
            }
        }
        for (int i = pPos; i < p.length(); i++) {
            if (p.charAt(i) != '*')
                return false;
        }
        return true;
    }
}
