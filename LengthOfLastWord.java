public class LengthOfLastWord {
        public int lengthOfLastWord(String s) {
                    int index = s.length() - 1;
                            int result = 0;
                                    while (index >= 0 && s.charAt(index) == ' ')
                                                    index--;
                                            if (index < 0)
                                                            return 0;
                                                    while (index >= 0 && s.charAt(index) != ' ') {
                                                                    result++;
                                                                                index--;
                                                                                        }
                                                            return result;
                                                                }
}
