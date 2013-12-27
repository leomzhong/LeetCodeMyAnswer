import java.util.HashMap;
import java.util.Iterator;

public class LongestCommonPrefix {
    class TrieNode {
        public char c;
        public HashMap<Character, TrieNode> children;

        public TrieNode(Character c) {
            this.c = c;
            this.children = new HashMap<Character, TrieNode>();
        }
    }

    public void addToTrie(TrieNode root, String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            char n = word.charAt(i);
            if (!tmp.children.containsKey(n)) {
                tmp.children.put(n, new TrieNode(n));
            }
            tmp = tmp.children.get(n);
        }
    }

    public TrieNode getNextSingleTrieNode(TrieNode node) {
        if (node.children.size() != 1)
            return null;
        Iterator<Character> iter = node.children.keySet().iterator();
        return node.children.get(iter.next());
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode(' ');
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            int length = word.length();
            if (length == 0)
                return "";
            if (length < min)
                min = length;
            addToTrie(root, word);
        }
        String result = "";
        TrieNode tmp = root;
        while ((tmp = getNextSingleTrieNode(tmp)) != null && min > 0) {
            result += tmp.c;
            min--;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] test = {"a", "aa"};
        LongestCommonPrefix r = new LongestCommonPrefix();
        System.out.println(r.longestCommonPrefix(test));
    }
}

