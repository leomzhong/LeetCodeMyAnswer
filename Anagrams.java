import java.util.HashMap;

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> record = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            String s = sort(strs[i]);
            Integer r = record.get(s);
            if (r == null) {
                record.put(s, i);
            } else if (r.equals(-1)) {
                result.add(strs[i]);
            } else {
                result.add(strs[r]);
                result.add(strs[i]);
                record.put(s, -1);
            }
        }
        return result;
    }

    public String sort(String s) {
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }
}
