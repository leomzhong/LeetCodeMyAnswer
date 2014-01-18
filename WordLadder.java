public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        LinkedList<String> queue = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        queue.offer(start);
        map.put(start, 1);
        int result = 0;
        int counter1 = 1;
        int counter2 = 0;
        while (queue.size() != 0) {
            String s = queue.poll();
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    char c = (char)(j + 'a');
                    if (s.charAt(i) != c) {
                        String newString = s.substring(0, i) + c + s.substring(i + 1);
                        if (newString.equals(end)) {
                            return result + 2;
                        } else if (dict.contains(newString) && map.get(newString) == null) {
                            queue.offer(newString);
                            counter2++;
                            map.put(newString, 1);
                        }
                    }
                }
            }
            counter1--;
            if (counter1 == 0) {
                counter1 = counter2;
                counter2 = 0;
                result++;
            }
        }
        return 0;
    }
}
