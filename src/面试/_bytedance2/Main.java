package 面试._bytedance2;

import java.util.*;

public class Main {
    Trie cur = new Trie();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String product : products) {
            addWords(cur, product);
        }
        boolean flag = false;
        List<List<String>> result = new ArrayList();
        for (int i = 0; i < searchWord.length(); i++) {
            int c = searchWord.charAt(i) - 'a';
            if (flag || cur.children[c] == null) {
                result.add(new ArrayList());
                flag = true;
            } else {
                cur = cur.children[c];
                result.add(cur.words);
            }
        }
        return result;
    }

    void addWords(Trie cur, String word) {
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new Trie();
            }
            cur = cur.children[c];
            cur.words.add(word);
            if (cur.words.size() > 3) {
                cur.words.remove(cur.words.size() - 1);
            }
        }
    }

    class Trie {
        Trie[] children;
        List<String> words;

        Trie() {
            children = new Trie[26];
            words = new ArrayList();
        }
    }


    public static void main(String[] args) {
        new Main().suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags");
    }
}
