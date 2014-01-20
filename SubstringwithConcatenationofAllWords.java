import java.util.ArrayList;
import java.util.HashMap;

public class SubstringwithConcatenationofAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (L.length == 0)
            return result;
        int len = L[0].length();
        if (S.length() < len)
            return result;
        HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
        HashMap<String, Integer> find = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            String s = L[i];
            if (needToFind.get(s) == null) {
                needToFind.put(s, 1);
                find.put(s, 0);
            } else {
                needToFind.put(s, needToFind.get(s) + 1);
            }
        }

        for (int i = 0; i < len; i++) {
            int start = i;
            int end = i;
            while (end + len <= S.length()) {
                String tmp = S.substring(end, end + len);
                if (needToFind.get(tmp) == null) {
                    end += len;
                    start = end;
                    for (String key: find.keySet()) {
                        find.put(key, 0);
                    }
                } else if (find.get(tmp) < needToFind.get(tmp)) {
                    find.put(tmp, find.get(tmp) + 1);
                    end += len;
                    if (end - start == L.length * len) {
                        result.add(start);
                        String tmp2 = S.substring(start, start + len);
                        find.put(tmp2, find.get(tmp2) - 1);
                        start += len;
                    }
                } else {
                    while (start < end) {
                        String tmp2 = S.substring(start, start + len);
                        if (!tmp.equals(tmp2)) {
                            find.put(tmp2, find.get(tmp2) - 1);
                            start += len;
                        } else {
                            start += len;
                            break;
                        }
                    }
                    end += len;
                }
            }
            for (String key: find.keySet()) {
                find.put(key, 0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String test = "sheateateseatea";
        String[] t = {"sea","tea","ate"};
        SubstringwithConcatenationofAllWords r = new SubstringwithConcatenationofAllWords();
        System.out.println(r.findSubstring(test, t));
    }
}

