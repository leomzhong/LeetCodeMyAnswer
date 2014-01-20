public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        if (words.length == 0)
            return result;
        int start = 0;
        while (start < words.length) {
            int wordLen = 0;
            int lenWithSpace = 0;
            int running = start;
            while (running < words.length) {
                if (lenWithSpace + words[running].length() <= L) {
                    wordLen += words[running].length();
                    lenWithSpace += (words[running].length() + 1);
                    running++;
                } else {
                    result.add(formString(words, start, running - 1, wordLen, L));
                    break;
                }
            }
            if (running != words.length) {
                start = running;
            } else {
                result.add(getFinalString(words, start, L));
                break;
            }
        }
        return result;
    }

    public String getFinalString(String[] words, int start, int L) {
        int len = 0;
        StringBuilder result = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            if (i < words.length - 1) {
                result.append(words[i] + " ");
                len += (words[i].length() + 1);
            } else {
                result.append(words[i]);
                len += words[i].length();
            }
        }
        while (len < L) {
            result.append(' ');
            len++;
        }
        return result.toString();
    }

    public String formString(String[] words, int begin, int end, int length, int L) {
        int num = end - begin + 1;
        if (num == 1) {
            StringBuilder result = new StringBuilder(words[begin]);
            while (result.length() < L) {
                result.append(' ');
            }
            return result.toString();
        }
        int spaceSize = (L - length) / (num - 1);
        int longerSize = (L - length) % (num - 1);
        StringBuilder tmpSpace = new StringBuilder();
        for (int i = 0; i < spaceSize; i++) {
            tmpSpace.append(' ');
        }
        String space = tmpSpace.toString();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < longerSize; i++) {
            result.append(words[begin + i] + space + ' ');
        }
        for (int i = begin + longerSize; i < end; i++) {
            result.append(words[i] + space);
        }
        result.append(words[end]);
        return result.toString();
    }
}
