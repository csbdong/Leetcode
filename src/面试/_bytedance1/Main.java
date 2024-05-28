package 面试._bytedance1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        char[] ch = new char[]{'a', 'b', 'c', 'd'};
        String s = "acdeabddadbcaef";
        Set<Character> set = new HashSet<>();
        for (char c : ch) {
            set.add(c);
        }
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        while (left <= s.length() - ch.length) {
            int right = left;
            while (right < left + ch.length) {
                Integer i = count.get(s.charAt(right));
                if (!set.contains(s.charAt(right))) {
                    left = right + 1;
                    count.clear();
                    break;
                } else if (i != null && i == 1) {
                    left = right + 1;
                    count.clear();
                    break;
                } else {
                    count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
                    right++;
                    if (right == left + ch.length) {
                        System.out.println(left);
                        return;
                    }
                }


            }


        }
        System.out.println("-1");
    }
}
