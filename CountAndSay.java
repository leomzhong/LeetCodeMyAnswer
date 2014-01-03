public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 0; i < n - 1; i++) {
            result = getNextString(result);
        }
        return result;
    }

    public String getNextString(String s) {
        String result = "";
        char old = s.charAt(0);
        int counter = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == old) {
                counter++;
            } else {
                result = result + counter + old;
                counter = 1;
                old = s.charAt(i);
            }
        }
        result = result + counter + old;
        return result;
    }
}
