public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<String>> record = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < s.length(); i++) {
            record.add(null);
        }
        return Helper(s, 0, dict, record);
    }

    public ArrayList<String> Helper(String s, int pos, Set<String> dict, ArrayList<ArrayList<String>> record) {
        ArrayList<String> result = new ArrayList<String>();
        if (pos >= s.length()) {
            result.add("");
            return result;
        }
        if (record.get(pos) == null) {
            for (int i = pos; i < s.length(); i++) {
                if (dict.contains(s.substring(pos, i + 1))) {
                    ArrayList<String> nextResult = Helper(s, i + 1, dict, record);
                    for (String sTmp: nextResult) {
                        String newString = s.substring(pos, i + 1);
                        if (!sTmp.equals(""))
                            newString = newString + " " + sTmp;
                        result.add(newString);
                    }
                }
            }
            record.set(pos, result);
        }
        return record.get(pos);
    }
}
